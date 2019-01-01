package DAOImpl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.ProfileDAO;
import beans.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private SqlSession session;

	@Override
	public List<Profile> getProfileList() {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		List<Profile> profileList = dao.getProfileList();

		return profileList;
	}

	@Override
	public Profile getProfile(String profileName) {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		Profile profile = dao.getProfile(profileName);

		return profile;
	}

	@Override
	public void addProfile(Profile profile) {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		dao.addProfile(profile);

	}

	@Override
	public void updateProfile(Profile profile) {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		dao.updateProfile(profile);

	}

	@Override
	public void deleteProfile(String profileName) {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		dao.deleteProfile(profileName);

	}

	@Override
	public Date getProfileCreatedDate(String profileName, Long profileId) {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		Date createdDate = dao.getProfileCreatedDate(profileName, profileId);

		return createdDate;
	}

	@Override
	public Long getMaxProfileId() {

		ProfileDAO dao = session.getMapper(ProfileDAO.class);
		Long profileId = dao.getMaxProfileId();

		return profileId;
	}

}
