package Providers;

public class CommentQueryProvider {

	public CommentQueryProvider() {
		System.out.println("constructed invoked");
	}
	
	public String getComments() {

		String sql = "SELECT * FROM COMMENT";
		return sql;
	}

	public String getCommentById() {

		String sql = "SELECT * FROM COMMENT WHERE ID = #{commentId}";
		return sql;
	}

	public String addComment() {

		String sql = "INSERT INTO COMMENT VALUES(#{commentId},#{comment},#{commentCreated},#{author},#{messageId})";
		return sql;
	}

	public String updateComment() {

		String sql = "UPDATE COMMENT SET COMMENT = #{comment} WHERE AUTHOR = #{author} and MESSAGEID = #{messageId}";
		return sql;
	}

	public String deleteComment() {

		String sql = "DELETE FROM COMMENT WHERE ID = #{commentId}";
		return sql;
	}

	public String getCommentAuthor() {

		String sql = "SELECT AUTHOR FROM COMMENT WHERE ID = #{commentId}";
		return sql;
	}

	public String getMaxCommentId() {

		String sql = "SELECT MAX(ID)+1 FROM COMMENT";
		return sql;
	}

}
