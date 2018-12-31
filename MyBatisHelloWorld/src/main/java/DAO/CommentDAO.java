package DAO;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import Providers.CommentQueryProvider;
import beans.Comment;

public interface CommentDAO {

	@SelectProvider(method = "getComments", type = CommentQueryProvider.class)
	@Results(value = { @Result(property = "commentId", column = "id"),
			@Result(property = "comment", column = "comment"),
			@Result(property = "commentCreated", column = "dateCreated"),
			@Result(property = "author", column = "author"), @Result(property = "messageId", column = "messageId") })
	List<Comment> getComments();

	@SelectProvider(method = "getCommentById", type = CommentQueryProvider.class)
	@Results(value = { @Result(property = "commentId", column = "id"),
			@Result(property = "comment", column = "comment"),
			@Result(property = "commentCreated", column = "dateCreated"),
			@Result(property = "author", column = "author"), @Result(property = "messageId", column = "messageId") })
	Comment getCommentById(@Param("commentId") Long commentId);

	@InsertProvider(method = "addComment", type = CommentQueryProvider.class)
	void addComment(Comment comment);

	@UpdateProvider(method = "updateComment", type = CommentQueryProvider.class)
	void updateComment(Comment comment);

	@DeleteProvider(method = "deleteComment", type = CommentQueryProvider.class)
	void deleteComment(@Param("commentId") Long commentId);

	@SelectProvider(method = "getCommentAuthor", type = CommentQueryProvider.class)
	@ResultType(value = java.lang.String.class)
	String getCommentAuthor(@Param("commentId") Long commentId);

	@SelectProvider(method = "getMaxCommentId", type = CommentQueryProvider.class)
	@ResultType(value = java.lang.Long.class)
	Long getMaxCommentId();
}
