package in.codeblog.tdms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * for finding all the registered trainees.
	 * 
	 * @return UserList
	 */

	public Iterable<User> findAllTrainees() {
		Iterable<User> users = userRepository.findAll();
		List trainees = new ArrayList();
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			User user = (User) it.next();
			if (user.getRole() == 1 && user.getRequest() == 1) {
				trainees.add(user);
			}

		}
		return trainees;
	}

	/**
	 * for regisetring the all user in bulk
	 * 
	 * @param users it is the list of users
	 * @return List of the users
	 */
	public Iterable<User> saveAllUsers(User[] users) {
		for (User user : users) {
			user.setPaasword("Tdmsapi@2020");
			user.setUsername(user.getEmail().substring(0, 5) + user.getContactNumber().substring(0, 3));
			user.setRequest(1);
			user.setRole(1);
		}

		return userRepository.saveAll(Arrays.asList(users));
	}

	/**
	 * for displaying list of trainees group wise
	 * 
	 * @param groupId
	 * @return
	 */
	public Iterable<User> getAllUserGroupById(int groupId) {
		Iterable<User> users = userRepository.findAll();
		List usersWithGroupId = new ArrayList();
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			User user = (User) it.next();
			if (user.getGroupId() == groupId && user.getRole() == 1 && user.getRequest() == 1) {
				usersWithGroupId.add(user);
			}

		}
		return usersWithGroupId;
	}

	/**
	 * Group update
	 */
	public void UpdateGroupOfSelectedTrainees() {
		// TODO update the trainees group
	}
}
