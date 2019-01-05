package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.Profile;

public interface ProfileDAO {

	@Select("SELECT * FROM PROFILE")
	@Results(value = { @Result(property = "profileId", column = "id"),
			@Result(property = "profileName", column = "profileName"),
			@Result(property = "firstName", column = "firstName"), @Result(property = "lastName", column = "lastName"),
			@Result(property = "created", column = "created") })
	List<Profile> getProfileList();

	@Select("SELECT * FROM PROFILE WHERE PROFILENAME = #{profileName} ")
	@Results(value = { @Result(property = "profileId", column = "id"),
			@Result(property = "profileName", column = "profileName"),
			@Result(property = "firstName", column = "firstName"), @Result(property = "lastName", column = "lastName"),
			@Result(property = "created", column = "created") })
	Profile getProfile(@Param("profileName") String profileName);

	@Insert("INSERT INTO PROFILE VALUES (#{profileId},#{profileName},#{firstName},#{lastName},#{created})")
	void addProfile(Profile profile);

	@Update("UPDATE PROFILE SET PROFILENAME = #{profileName}, FIRSTNAME = #{firstName}, LASTNAME = #{lastName}, CREATED = #{created} WHERE ID = #{profileId}")
	void updateProfile(Profile profile);

	@Delete("DELETE FROM PROFILE WHERE PROFILENAME = #{profileName}")
	void deleteProfile(@Param("profileName") String profileName);

	@Select("SELECT CREATED FROM PROFILE WHERE PROFILENAME = #{profileName} and ID = #{profileId}")
	Date getProfileCreatedDate(String profileName, Long profileId);

}
