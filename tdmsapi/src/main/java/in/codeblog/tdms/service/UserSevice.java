package in.codeblog.tdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.exception.UserEmailException;
import in.codeblog.tdms.repository.UserRepository;

@Service
public class UserSevice {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveorUpdate(User user)
	{
		try {
			user.setEmail(user.getEmail());
			return userRepository.save(user);
		}
		catch (Exception e) {
			throw new UserEmailException("E-mail Already Exists");
		}
	}

}
