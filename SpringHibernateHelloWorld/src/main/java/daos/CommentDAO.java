package daos;

import java.util.List;

import beans.Comment;

public interface CommentDAO {

	List<Comment> getComments();

	Comment getCommentById(Long commentId);

	void addComment(Comment comment);

	void updateComment(Comment comment);

	void deleteComment(Long commentId);

	String getCommentAuthor(Long commentId);

	Long getMaxCommentId();
}
