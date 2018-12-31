package beans;

import java.util.Date;

public class CommentResponse {

	private Long commentId;
	private String comment;
	private Date commentCreated;
	private String author;
	private Long messageId;
	
	public CommentResponse() {}
	
	public CommentResponse(Long commentId, String comment, Date commentCreated, String author, Long messageId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentCreated = commentCreated;
		this.author = author;
		this.messageId = messageId;
	}

	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentCreated() {
		return commentCreated;
	}
	public void setCommentCreated(Date commentCreated) {
		this.commentCreated = commentCreated;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

}
