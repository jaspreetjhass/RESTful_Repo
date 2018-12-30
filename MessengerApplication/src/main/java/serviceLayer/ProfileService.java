package serviceLayer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Profile;
import daoLayerImpl.ProfileDAOImpl;

@Service
public class ProfileService {

	@Autowired
	private ProfileDAOImpl profileDAO;

	public List<Profile> getProfiles() throws SQLException {

		return profileDAO.getProfiles();
	}

	public Profile getProfile(Long profileId) throws SQLException {

		return profileDAO.getProfile(profileId);
	}

	public Profile addProfile(Profile profile) throws SQLException {
		
		return profileDAO.addProfile(profile);
	}

	public Profile updateProfile(Profile profile) throws SQLException {
		
		return profileDAO.updateProfile(profile);
	}

	public Boolean removeProfile(Long profileId) throws SQLException {
		
		return profileDAO.removeProfile(profileId);
	}

	public Profile getProfileByName(String profileName) throws SQLException {
		
		return profileDAO.getProfileByName(profileName);
	}

}
