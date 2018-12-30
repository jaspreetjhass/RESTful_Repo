package daoLayerImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Comment;
import daoLayer.CommentDAO;
import exceptions.MessengerException;
import utility.ConnectionFactory;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Override
	public List<Comment> getComments(Long messageId) throws SQLException {
		List<Comment> comments = new ArrayList<Comment>();
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from comment where messageId = ? ");
		statement.setLong(1, messageId);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Comment comment = new Comment(rs.getLong(1), rs.getString(2), new java.util.Date(rs.getDate(3).getTime()),
					rs.getString(4), rs.getLong(5));
			comments.add(comment);
		}

		connection.close();

		return comments;
	}

	@Override
	public Comment getComment(Long messageId, Long commentId) throws SQLException {
		Comment Comment = null;
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("select * from Comment where id = ? and messageId = ?");
		statement.setLong(1, commentId);
		statement.setLong(2, messageId);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Comment = new Comment(rs.getLong(1), rs.getString(2), new java.util.Date(rs.getDate(3).getTime()),
					rs.getString(4), rs.getLong(5));
		}

		connection.close();

		return Comment;
	}

	@Override
	public Comment addComment(Comment comment) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into Comment values (?,?,?,?,?)");
		statement.setLong(1, comment.getCommentId());
		statement.setString(2, comment.getComment());
		statement.setDate(3, new Date(comment.getCommentCreated().getTime()));
		statement.setString(4, comment.getAuthor());
		statement.setLong(5, comment.getMessageId());

		int count = statement.executeUpdate();

		connection.close();

		if (count == 1)
			return comment;
		else
			throw new MessengerException("error while inserting data into db");
	}

	@Override
	public Comment updateComment(Comment comment) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"update comment set Comment = ?, dateCreated = ?, author = ? where id = ? and messageId = ?");

		statement.setString(1, comment.getComment());
		statement.setDate(2, new Date(comment.getCommentCreated().getTime()));
		statement.setString(3, comment.getAuthor());
		statement.setLong(4, comment.getCommentId());
		statement.setLong(5, comment.getMessageId());

		int count = statement.executeUpdate();

		connection.close();

		if (count == 1)
			return comment;
		else
			throw new MessengerException("error while updating data into db");
	}

	@Override
	public Boolean removeComment(Long messageId, Long commentId) throws SQLException {
		Connection connection = connectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("delete from comment where id = ? and messageId = ? ");

		statement.setLong(1, commentId);
		statement.setLong(2, messageId);

		int count = statement.executeUpdate();

		connection.close();

		if (count == 1)
			return true;
		else
			return false;
	}

}
