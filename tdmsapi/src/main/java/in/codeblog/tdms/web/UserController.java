package in.codeblog.tdms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.model.Users;
import in.codeblog.tdms.service.MapValidationErrorService;
import in.codeblog.tdms.service.UsersService;

/**
 * 
 * @author Rigwik
 *
 */
@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UsersService userService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody Users users, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
        if (errorMap != null)
            return errorMap;

        Users user = userService.saveOrUpdate(users);
        return new ResponseEntity<Users>(user, HttpStatus.CREATED);
    }
	@GetMapping("/all")
    public Iterable<Users> getAllUsers() {
        return userService.findAllUsers();
    }
}
