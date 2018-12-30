package exceptions;

public class MessengerException extends RuntimeException{

	private static final long serialVersionUID = -5958999407134975359L;
	
	private String errorMessage;
	
	public MessengerException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}
