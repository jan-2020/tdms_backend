package in.codeblog.tdms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserEmailException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UserEmailException(String errmsg) {
		super(errmsg);
	}

}
