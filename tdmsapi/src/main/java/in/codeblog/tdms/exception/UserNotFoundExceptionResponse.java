package in.codeblog.tdms.exception;

public class UserNotFoundExceptionResponse {
	
//private String userName;
//private String password;
//
//
//public UserNotFoundExceptionResponse(String userName) {
//	super();
//	this.userName=userName;
//}
//public String getUserName() {
//	return userName;
//}
//public void setUserName(String userName) {
//	this.userName = userName;
//}
//public String getPassword() {
//	return password;
//}
//public void setPassword(String password) {
//	this.password = password;
//}
	
private String message;


public UserNotFoundExceptionResponse(String message) {
	super();
	this.message=message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
