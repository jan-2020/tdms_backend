package in.codeblog.tdms.service;
/**
 * 
 * @author Rigwik
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.exception.UserIdException;
import in.codeblog.tdms.model.Users;
import in.codeblog.tdms.repositories.UsersRepo;
@Service
public class UsersService {
	@Autowired
	private UsersRepo usersRepo;
	public Users saveOrUpdate(Users users) {
		try {
			return usersRepo.save(users);
		}
		catch (Exception ex) {
			// TODO: handle exception
			throw new UserIdException("User Id"+users.getId());
		}
	}
	public Iterable<Users> findAllUsers() {
		
		return usersRepo.findAll();
	}
	
	
}
