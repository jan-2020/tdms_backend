package in.codeblog.tdms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.service.UserService;
@RequestMapping("/tdms/users")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
	private UserService userService;       
    @GetMapping("/all")
    public Iterable<User> findAllProjects(){
 	   return userService.findAllTrainees();
    }
	@PostMapping("")
	public ResponseEntity<?> saveAllUsers( User users[]) {

		Iterable userList=userService.saveAllUsers(users);
		return new ResponseEntity<Iterable>(userList, HttpStatus.CREATED);
	
	}
	
	@GetMapping("{groupId}")
	public ResponseEntity<?> getAllTraineesGroupByName(int groupId) {

		Iterable userList=userService.getAllUserGroupById(groupId);
		return new ResponseEntity<Iterable>(userList, HttpStatus.CREATED);
	}
	
	
 
    //find trainees by groupId(order by group Id)
}
