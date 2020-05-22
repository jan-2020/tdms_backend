package in.codeblog.tdms.web;
/**
 * This UserController will have various rest services and Url Mapping
 * @author Ajeet Chouhan
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.services.UserService;


@CrossOrigin
@RequestMapping("api/user")
@RestController  
public class UserController {
	@Autowired
	private UserService userService;
/**
 * The getPendingRequests method has a get type request
 * This will return list of pending user 
 * @return
 */
@GetMapping("/pendingrequest")
public ResponseEntity<?>getPendingRequests()
{
	List<User>pendingRequestUsers=userService.getPendingUserRequests();
return new ResponseEntity<List<User>>(pendingRequestUsers, HttpStatus.OK);

}
/**
 * This approveOrReject Method will take a user as parameter and save the status of request
 * It has post type request
 * @param user
 */

@PostMapping("/approveOrReject")
public void approveOrReject(@RequestBody User user)
{
	//System.out.println(user);
	userService.approveOrReject(user);
}
/**
 * This approveOrReject Method will take a user as parameter and save the status of request
 * It has post type request
 * @param user
 */

@PostMapping("/changeRole")
/**
 * This changeUserRole Method will take a user as parameter and save the status of request
 * It has post type request
 * @param user
 */
public void changeUserRole(@RequestBody User user) 
{
	System.out.println(user);
	userService.changeRole(user);
}


}

