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

import beans.Message;
import daoLayer.MessageDAO;
import exceptions.MessengerException;
import utility.ConnectionFactory;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Override
	public List<Message> getMessages() throws SQLException {
		List<Message> messages = new ArrayList<Message>();
		Connection connection = connectionFactory.getConnection();
		Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery("select * from message");

		while (rs.next()) {
			Message message = new Message(rs.getLong(1), rs.getString(2), new java.util.Date(rs.getDate(3).getTime()),
					rs.getString(4));
			messages.add(message);
		}

		connection.close();

		return messages;
	}

	@Override
	public Message getMessage(Long messageId) throws SQLException {
		Message message = null;
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from message where id = ? ");
		statement.setLong(1, messageId);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			message = new Message(rs.getLong(1), rs.getString(2), new java.util.Date(rs.getDate(3).getTime()),
					rs.getString(4));
		}

		connection.close();

		return message;
	}

	@Override
	public Message addMessage(Message message) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into message values (?,?,?,?)");
		statement.setLong(1, message.getMessageId());
		statement.setString(2, message.getMessage());
		statement.setDate(3, new Date(message.getMessageCreated().getTime()));
		statement.setString(4, message.getAuthor());

		int count = statement.executeUpdate();

		connection.close();

		if (count == 1)
			return message;
		else
			throw new MessengerException("error while inserting data into db");
	}

	@Override
	public Message updateMessage(Message message) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("update message set message = ?, dateCreated = ?, author = ? where id = ? ");

		statement.setString(1, message.getMessage());
		statement.setDate(2, new Date(message.getMessageCreated().getTime()));
		statement.setString(3, message.getAuthor());
		statement.setLong(4, message.getMessageId());

		int count = statement.executeUpdate();

		connection.close();

		if (count == 1)
			return message;
		else
			throw new MessengerException("error while updating data into db");
	}

	@Override
	public Boolean removeMessage(Long messageId) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from message where id = ? ");

		statement.setLong(1, messageId);

		int count = statement.executeUpdate();

		connection.close();

		if (count == 1)
			return true;
		else
			return false;
	}

}
