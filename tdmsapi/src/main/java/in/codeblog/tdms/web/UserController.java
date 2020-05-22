package in.codeblog.tdms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.service.MapValidationErrorService;
import in.codeblog.tdms.service.UserSevice;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserSevice userSevice;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if (errorMap!=null) {
			return errorMap;
		}
		User user2=userSevice.saveorUpdate(user);
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);
	}
}
