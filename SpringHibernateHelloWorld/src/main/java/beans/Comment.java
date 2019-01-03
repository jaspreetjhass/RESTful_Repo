package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "comment")
@Table(name = "comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3486229352586387434L;

	@Id
	@Column(name = "id")
	private Long commentId;
	private String comment;
	@Column(name = "dateCreated")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date commentCreated;
	private String author;
	private Long messageId;

	public Comment() {
	}

	public Comment(Long commentId, String comment, Date commentCreated, String author, Long messageId) {
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

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentCreated=" + commentCreated
				+ ", author=" + author + ", messageId=" + messageId + "]";
	}

}
