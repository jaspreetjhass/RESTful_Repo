package daos;

import java.util.List;

import beans.Profile;

public interface ProfileDAO {

	Profile addProfile(Profile profile);
	Profile updateProfile(Profile profile);
	void deleteProfile(String profileName);
	Profile getProfileByName(String profileName);
	Profile getProfileById(Long profileId);
	List<Profile> getProfileList();
	
}
