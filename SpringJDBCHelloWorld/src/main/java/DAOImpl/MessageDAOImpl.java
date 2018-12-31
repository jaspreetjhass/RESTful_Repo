package DAOImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import DAO.MessageDAO;
import beans.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<Message> getMessages() {

		RowMapper<Message> rowMapper = (rs,index) ->
		{
			Message message = new Message(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getString(4)); 
			
			return message;
		};
		
		List<Message> messageList = template.query("select * from message", rowMapper);

		return messageList;
	}

	@Override
	public Message getMessageById(Long messageId) {

		ResultSetExtractor<Message> rse = rs -> {
			Message message = null;
			while (rs.next()) {
				message = new Message(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getString(4));
			}
			return message;
		};

		Message message = template.query("select * from message where id = ?", new Object[] { messageId }, rse);

		return message;
	}

	@Override
	public void addMessage(Message message) {

		PreparedStatementCallback<Integer> ps = p -> {
			p.setLong(1, message.getMessageId());
			p.setString(2, message.getMessage());
			p.setDate(3, new Date(message.getMessageCreated().getTime()));
			p.setString(4, message.getAuthor());
			
			Integer count = null;
			count = p.executeUpdate();
			
			return count;
		};

		Integer count = template.execute("insert into message values (?,?,?,?)", ps);

		if (count == 1)
			System.out.println("record inserted successfully");
		else
			System.out.println("error while inserting record");

	}

	@Override
	public void updateMessage(Message message) {
		
		Integer count = template.update("update message set message = ?, dateCreated = ? where author = ?", new Object[]{message.getMessage(),message.getMessageCreated(),message.getAuthor()});

		if (count == 1)
			System.out.println("record updated successfully");
		else
			System.out.println("error while updating record");
		
	}

	@Override
	public void deleteMessage(Long messageId) {

		Integer count = template.update("delete from message where id = ?", new Object[]{messageId});

		if (count == 1)
			System.out.println("record deleted successfully");
		else
			System.out.println("error while deleting record");
		
	}

	@Override
	public String getMessageAuthor(Long messageId) {

		String author= template.queryForObject("select author from message where id = ? ", new Object[]{messageId}, String.class);
		
		return author;
	}

}
