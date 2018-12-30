package daoLayer;

import java.sql.SQLException;
import java.util.List;

import beans.Message;

public interface MessageDAO {

	public List<Message> getMessages() throws SQLException;

	public Message getMessage(Long messageId) throws SQLException;

	public Message addMessage(Message message) throws SQLException;

	public Message updateMessage(Message message) throws SQLException;

	public Boolean removeMessage(Long messageId) throws SQLException;
	
}
