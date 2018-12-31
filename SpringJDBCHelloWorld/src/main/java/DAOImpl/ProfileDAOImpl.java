package DAOImpl;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import DAO.ProfileDAO;
import beans.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private JdbcTemplate template;

	public List<Profile> getProfileList() {

		RowMapper<Profile> rowmapper = (rs, index) -> {

			Profile profile = new Profile(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getDate(5));

			return profile;
		};

		List<Profile> profileList = template.query("select * from profile", rowmapper);

		return profileList;
	}

	public Profile getProfile(String profileName) {

		PreparedStatementCallback<Profile> ps = p -> {
			Profile profile = null;
			p.setString(1, profileName);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {
				profile = new Profile(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}

			return profile;
		};
		Profile profile = template.execute("select * from profile where profileName = ?", ps);
		return profile;
	}

	public void addProfile(Profile profile) {

		int count = template.update("insert into profile values (?,?,?,?,?)", new Object[] { profile.getProfileId(),
				profile.getProfileName(), profile.getFirstName(), profile.getLastName(), profile.getCreated() });
		if (count == 1)
			System.out.println("record inserted successfully");
		else
			System.out.println("error while inserting record");

	}

	public void updateProfile(Profile profile) {

		int count = template.update("update profile set firstName = ?, lastName = ? where profileName = ?",
				profile.getFirstName(), profile.getLastName(), profile.getProfileName());
		if (count == 1)
			System.out.println("record updated successfully");
		else
			System.out.println("error while updating record");
	}

	public void deleteProfile(String profileName) {

		int count = template.update("delete from profile where profileName = ? ", new Object[] { profileName });
		if (count == 1)
			System.out.println("record deleted successfully");
		else
			System.out.println("error while deleting record");

	}

	@Override
	public Date getProfileCreatedDate(String profileName) {

		Date createdDate  = template.queryForObject("select created from profile where profileName = ?", Date.class, profileName);
		
		return createdDate;
	}

}
