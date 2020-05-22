package in.codeblog.tdms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Group;
import in.codeblog.tdms.exception.GroupNameException;
import in.codeblog.tdms.repository.GroupRepository;

/**
 * 
 * @author AjiT
 *
 */

@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;

	public Group saveOrUpdate(Group group) {
		final int DEFAULT_STATUS = 1;
		group.setStatus(DEFAULT_STATUS);
		try {
			return groupRepository.save(group);
		} catch (Exception e) {
			throw new GroupNameException("Group Name already exists");
		}
	}

	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	public Group findGroupById(int groupId) {
		Optional<Group> op = groupRepository.findById(groupId);
		Group group = null;
		if (op.isPresent()) {
			group = op.get();
		}
		return group;
	}

	public List<Group> findMyGroup(int userId) {
		final int ACTIVATE = 1;
		return groupRepository.findByStatusAndId(ACTIVATE, userId);
	}

	public List<Group> findOtherGroup(int userId) {
		final int ACTIVATE = 1;
		return groupRepository.findOtherGroup(ACTIVATE, userId);
	}

	public Integer changeStatus(int groupId) {
		Integer updatedStatus = null;
		Optional<Group> op = groupRepository.findById(groupId);
		Group group = op.get();
		if (group.getStatus() == 1) {
			updatedStatus = 2;
		} else {
			updatedStatus = 1;
		}
		group.setStatus(updatedStatus);
		groupRepository.save(group);
		return 1;
	}
	
	public void createDefaultGroup(){
        groupRepository.createDefaultGroup();
}

}