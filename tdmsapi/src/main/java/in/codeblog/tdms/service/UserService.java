package in.codeblog.tdms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.exception.PasswordInvalidException;
import in.codeblog.tdms.exception.UserNotFoundException;
import in.codeblog.tdms.repository.UserRepository;

@Service
public class UserService {
	
@Autowired
private UserRepository userRepository;

	public User findByUserName(String userName,String password) {
		User user=userRepository.findUserByName(userName);
		System.out.print("this is response"+user);
		if(user==null)
			throw new UserNotFoundException("inavalid user");
		else
		{
			System.out.println(user.getPassword());
			//System.out.print(password);
			System.out.println(user.getUserName());
			if(!(user.getPassword().equals(password)))
				throw new PasswordInvalidException("invalid password");
		}
		return user;
	}




		
}

