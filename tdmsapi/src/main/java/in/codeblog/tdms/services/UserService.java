package in.codeblog.tdms.services;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.reposiorities.UserRepository;
/**
 * This is the UserService class and has all service related methods
 * @author Ajeet
 *
 */
@Service
public class UserService {
@Autowired
private UserRepository userRepository;
/**
 * This getPendingRequests method will return list of pending user 
 * @return list of users
 */
public List<User>getPendingUserRequests()
{
	List<User>users=userRepository.findAll();
	List<User>toSend=new LinkedList<>();
	for(User user:users)
	{
		if(user.getRequest()==0)
		{
			toSend.add(user);
		}
	}
	users=null;
return toSend;
}
/**
 * This approveOrReject method will take a user as an argument and save the user approval or disapproval 
 * @param user
 */
public void approveOrReject(User user) {

	long userId=user.getUserId();
	User newUser=userRepository.findById(userId);
	newUser.setRequest(user.getRequest());
    newUser.setMessage(user.getMessage());
	userRepository.save(newUser);
}
/**
 * This change role method will take a user as a parameter and will save the user
 * @param user
 */
public void changeRole(User user) {
	long userId=user.getUserId();
	User newUser=userRepository.findById(userId);
	newUser.setRole(user.getRole());
	userRepository.save(newUser);
	
}

}