package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Message")
@Table(name = "message")
public class Message {

	@Id
	@Column(name = "id")
	private Long messageId;
	@Column(name = "message")
	private String message;
	@Column(name = "dateCreated")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date messageCreated;
	@Column(name = "author")
	private String author;

	public Message() {

	}

	public Message(Long messageId, String message, Date messageCreated, String author) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageCreated = messageCreated;
		this.author = author;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getMessageCreated() {
		return messageCreated;
	}

	public void setMessageCreated(Date messageCreated) {
		this.messageCreated = messageCreated;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", messageCreated=" + messageCreated
				+ ", author=" + author + "]";
	}

}
