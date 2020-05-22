package in.codeblog.tdms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {
	
@ExceptionHandler(value=UserNotFoundException.class)
public final ResponseEntity<Object> handlerUserException(UserNotFoundException ex,WebRequest request){
	UserNotFoundExceptionResponse exceptionResponse=new UserNotFoundExceptionResponse(ex.getMessage());
	return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(value=PasswordInvalidException.class)
public final ResponseEntity<Object> handlePasswordException(PasswordInvalidException ex,WebRequest request){
	UserNotFoundExceptionResponse exceptionResponse= new UserNotFoundExceptionResponse(ex.getMessage());
	return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
}

}
