package DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.Message;

public interface MessageDAO {

	@Select("SELECT * FROM MESSAGE")
	@Results(value = { @Result(property = "messageId", column = "id"),
			@Result(property = "message", column = "message"),
			@Result(property = "messageCreated", column = "dateCreated"),
			@Result(property = "author", column = "author") })
	List<Message> getMessages();

	@Select("SELECT * FROM MESSAGE WHERE ID = #{messageId}")
	@Results(value = { @Result(property = "messageId", column = "id"),
			@Result(property = "message", column = "message"),
			@Result(property = "messageCreated", column = "dateCreated"),
			@Result(property = "author", column = "author") })
	Message getMessageById(@Param("messageId") Long messageId);

	@Insert("INSERT INTO MESSAGE VALUES(#{messageId},#{message},#{messageCreated},#{author})")
	void addMessage(Message message);

	@Update("UPDATE MESSAGE SET MESSAGE = #{message} WHERE AUTHOR = #{author}")
	void updateMessage(Message message);

	@Delete("DELETE FROM MESSAGE WHERE ID = #{messageId}")
	void deleteMessage(@Param("messageId")Long messageId);

	@Select("SELECT AUTHOR FROM MESSAGE WHERE ID = #{messageId}")
	@ResultType(value = java.lang.String.class)
	String getMessageAuthor(@Param("messageId") Long messageId);

	@Select("SELECT MAX(ID)+1 FROM MESSAGE")
	@ResultType(value = java.lang.Long.class)
	Long getMaxMessageId();

}
