package in.codeblog.tdms.services;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.reposiorities.UserRepository;
@Service
public class UserService {
@Autowired
private UserRepository userRepository;
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
public void approveOrReject(User user) {

	long userId=user.getUserId();
	User newUser=userRepository.findById(userId);
	newUser.setRequest(user.getRequest());
    newUser.setMessage(user.getMessage());
	userRepository.save(newUser);
}

}