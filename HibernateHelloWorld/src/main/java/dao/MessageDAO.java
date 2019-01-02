package dao;

import java.util.List;

import beans.Message;

public interface MessageDAO {

	List<Message> getMessages();

	Message getMessageById(Long messageId);

	void addMessage(Message message);

	void updateMessage(Message message);

	void deleteMessage(Long messageId);

	String getMessageAuthor(Long messageId);

	Long getMaxMessageId();

}
