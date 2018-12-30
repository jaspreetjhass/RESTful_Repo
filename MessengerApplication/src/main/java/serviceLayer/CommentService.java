package serviceLayer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Comment;
import daoLayerImpl.CommentDAOImpl;

@Service
public class CommentService {

	@Autowired
	private CommentDAOImpl commentDAO;

	public List<Comment> getComments(Long messageId) throws SQLException {

		return commentDAO.getComments(messageId);
	}

	public Comment getComment(Long messageId, Long commentId) throws SQLException {

		return commentDAO.getComment(messageId, commentId);
	}

	public Comment addComment(Comment Comment) throws SQLException {

		return commentDAO.addComment(Comment);
	}

	public Comment updateComment(Comment Comment) throws SQLException {

		return commentDAO.updateComment(Comment);
	}

	public Boolean removeComment(Long messageId, Long commentId) throws SQLException {

		return commentDAO.removeComment(messageId, commentId);
	}

}
