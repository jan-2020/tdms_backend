/**
 * 
 */
package in.codeblog.tdms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Rigwik
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * This will create project id Exception with err msg
	 * @param errmsg
	 */
	public UserIdException (String errMsg) {
		super(errMsg);
	}
}
