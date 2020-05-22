package in.codeblog.tdms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.service.UserService;

@RestController
@RequestMapping("/ytdms/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("")
	public ResponseEntity<?> createNewUser(@RequestBody User user){
		User returnedUser=userService.saveOrUpdateUser(user);
		return new ResponseEntity<User>(returnedUser,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{roleName}")
	public List<Integer> getAllIdsByRole(@PathVariable String roleName){
		return userService.findAllUsersByRole(roleName);
		
	}
	
	
	
}
