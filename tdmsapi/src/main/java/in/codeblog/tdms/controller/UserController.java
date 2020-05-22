package in.codeblog.tdms.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.StringResponse;
import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.service.MapValidationErrorService;
import in.codeblog.tdms.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/tdms")
public class UserController {
	
@Autowired
private UserService userservice;

@Autowired
private MapValidationErrorService mapValidationErrorService;



@PostMapping("/login")
public ResponseEntity<?> login (@RequestBody User user){
	System.out.println("user password from client"+user.getPassword());
	System.out.print("user name from client"+user.getUserName());
User user1=userservice.findByUserName(user.getUserName(),user.getPassword());
StringResponse sr=null;
if(user!=null)
{
	 sr=new StringResponse("Authentication Successfull",user);
}
return new ResponseEntity<StringResponse>(sr,HttpStatus.OK);
}



//@GetMapping("/logincheck/{userName}/{password}")
//public  ResponseEntity<?> getlogin (@PathVariable String userName,@PathVariable String password) {
//	User user=userservice.findByUserName(userName,password);
//	System.out.println("userName:"+user.getUserName()+"password"+user.getPassword());
//	StringResponse sr=null;
//	if(user!=null)
//	{
//		 sr=new StringResponse("Authentication Successfull",user);
//	}
//	return new ResponseEntity<StringResponse>(sr,HttpStatus.OK);
//}

}
