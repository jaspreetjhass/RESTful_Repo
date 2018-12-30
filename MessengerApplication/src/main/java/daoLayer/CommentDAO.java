package daoLayer;

import java.sql.SQLException;
import java.util.List;

import beans.Comment;

public interface CommentDAO {

	public List<Comment> getComments(Long messageId) throws SQLException;

	public Comment getComment(Long messageId, Long commentId) throws SQLException;

	public Comment addComment(Comment comment) throws SQLException;

	public Comment updateComment(Comment comment) throws SQLException;

	public Boolean removeComment(Long messageId, Long commentId) throws SQLException;
	
}
