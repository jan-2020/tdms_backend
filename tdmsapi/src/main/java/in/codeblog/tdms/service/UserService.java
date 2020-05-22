package in.codeblog.tdms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User saveOrUpdateUser(User user) {
		
		return userRepository.save(user);
	}

	public List<Integer> findAllUsersByRole(String roleName) {
		Iterable<User> getAllUsers=userRepository.findByRole(roleName);
		List<Integer> getAllIds=new ArrayList<Integer>();
		
		for(User user:getAllUsers) {
			if(user.getRole()=="trainee") {
				getAllIds.add(user.getId());
			}	
		}
		
		return getAllIds;
	}

	
}
