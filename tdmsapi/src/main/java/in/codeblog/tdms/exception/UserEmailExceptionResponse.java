package in.codeblog.tdms.exception;

public class UserEmailExceptionResponse {

	private String mail;
	
	public UserEmailExceptionResponse(String mail) {
		super();
		this.mail=mail;
	}

	public String getEmail() {
		return mail;
	}

	public void setEmail(String mail) {
		this.mail = mail;
	}
	
}
