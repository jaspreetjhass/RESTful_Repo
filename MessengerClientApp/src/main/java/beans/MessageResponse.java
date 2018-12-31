package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageResponse {

	private Long messageId;
	private String message;
	private Date messageCreated;
	private String author;
	private List<LinkResponse> links = new ArrayList<LinkResponse>();

	public MessageResponse() {
	}

	public MessageResponse(Long messageId, String message, Date messageCreated, String author) {
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

	public List<LinkResponse> getLinks() {
		return links;
	}

	public void setLinks(List<LinkResponse> links) {
		this.links = links;
	}

	public void addUrl(String rel, String href) {
		links.add(new LinkResponse(rel, href));
	}

	@Override
	public String toString() {
		return "MessageResponse [messageId=" + messageId + ", message=" + message + ", messageCreated=" + messageCreated
				+ ", author=" + author + "]";
	}
	
	
}
