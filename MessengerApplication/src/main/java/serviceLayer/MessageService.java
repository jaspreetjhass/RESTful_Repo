package serviceLayer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Message;
import daoLayerImpl.MessageDAOImpl;

@Repository
public class MessageService {

	@Autowired
	private MessageDAOImpl messageDAO;

	public List<Message> getMessages() throws SQLException {

		return messageDAO.getMessages();
	}

	public Message getMessage(Long MessageId) throws SQLException {

		return messageDAO.getMessage(MessageId);
	}

	public Message addMessage(Message Message) throws SQLException {

		return messageDAO.addMessage(Message);
	}

	public Message updateMessage(Message Message) throws SQLException {

		return messageDAO.updateMessage(Message);
	}

	public Boolean removeMessage(Long MessageId) throws SQLException {

		return messageDAO.removeMessage(MessageId);
	}

}
