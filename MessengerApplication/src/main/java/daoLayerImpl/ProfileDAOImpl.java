package daoLayerImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Profile;
import daoLayer.ProfileDAO;
import exceptions.MessengerException;
import utility.ConnectionFactory;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Override
	public List<Profile> getProfiles() throws SQLException {

		List<Profile> profiles = new ArrayList<Profile>();
		Connection connection = connectionFactory.getConnection();
		Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery("select * from profile");

		while (rs.next()) {
			Profile profile = new Profile(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
					new java.util.Date(rs.getDate(5).getTime()));
			profiles.add(profile);
		}
		
		connection.close();
		
		return profiles;
	}

	@Override
	public Profile getProfile(Long profileId) throws SQLException {

		Profile profile = null;
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from profile where id = ? ");
		statement.setLong(1, profileId);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			profile = new Profile(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
					new java.util.Date(rs.getDate(5).getTime()));
		}
		
		connection.close();
		
		return profile;
	}

	@Override
	public Profile addProfile(Profile profile) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into profile values (?,?,?,?,?)");
		statement.setLong(1, profile.getProfileId());
		statement.setString(2, profile.getProfileName());
		statement.setString(3, profile.getFirstName());
		statement.setString(4, profile.getLastName());
		statement.setDate(5, new Date(profile.getCreated().getTime()));

		int count = statement.executeUpdate();

		connection.close();
		
		if (count == 1)
			return profile;
		else
			throw new MessengerException("error while inserting data into db");
	}

	@Override
	public Profile updateProfile(Profile profile) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"update profile set profileName = ?, firstName = ?, lastName = ?, created = ? where id = ? ");

		statement.setString(1, profile.getProfileName());
		statement.setString(2, profile.getFirstName());
		statement.setString(3, profile.getLastName());
		statement.setDate(4, new Date(profile.getCreated().getTime()));
		statement.setLong(5, profile.getProfileId());

		int count = statement.executeUpdate();

		connection.close();
		
		if (count == 1)
			return profile;
		else
			throw new MessengerException("error while updating data into db");
	}

	@Override
	public Boolean removeProfile(Long profileId) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from profile where id = ? ");

		statement.setLong(1, profileId);

		int count = statement.executeUpdate();

		connection.close();
		
		if (count == 1)
			return true;
		else
			return false;
	}

	public Profile getProfileByName(String profileName) throws SQLException{
		Profile profile = null;
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from profile where profileName = ? ");
		statement.setString(1, profileName);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			profile = new Profile(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
					new java.util.Date(rs.getDate(5).getTime()));
		}
		
		connection.close();
		
		return profile;
	}

}
