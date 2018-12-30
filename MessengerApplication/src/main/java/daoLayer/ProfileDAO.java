package daoLayer;

import java.sql.SQLException;
import java.util.List;

import beans.Profile;

public interface ProfileDAO {

	public List<Profile> getProfiles() throws SQLException;

	public Profile getProfile(Long profileId) throws SQLException;

	public Profile addProfile(Profile profile) throws SQLException;

	public Profile updateProfile(Profile profile) throws SQLException;

	public Boolean removeProfile(Long profileId) throws SQLException;

	public Profile getProfileByName(String profileName) throws SQLException;
}
