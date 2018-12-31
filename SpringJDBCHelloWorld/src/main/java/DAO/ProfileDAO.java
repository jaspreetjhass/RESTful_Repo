package DAO;

import java.util.List;

import beans.Profile;

public interface ProfileDAO {

	List<Profile> getProfileList();
	Profile getProfile(String profileName);
	void addProfile(Profile profile);
	void updateProfile(Profile profile);
	void deleteProfile(String profileName);
	
}
