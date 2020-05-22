package in.codeblog.tdms.domain;

public class StringResponse {
	private String message;
	private User user;
	public StringResponse(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public User getUser() {
		return user;
	}
	
	

	
}
