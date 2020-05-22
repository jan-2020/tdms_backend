package in.codeblog.tdms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.repository.AssignmentRepository;

@Service
public class AssignmentService {
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	public Assignment saveOrUpdateAssignment(Assignment assignment){
	
		return assignmentRepository.save(assignment);	
	}
	
	
	/**
	 * used for finding assignment uniquely by their id
	 * @param assignmetId
	 * @return assignment
	 */
	

	public Optional<Assignment> findById(Long id) {
		Optional<Assignment> assignment =  assignmentRepository.findById(id);
		return assignment;	
	}
	
	
	public List<Assignment> findBySubTopicName(String subTopicName){
		return	assignmentRepository.findBySubTopicName(subTopicName);
	}
	
	/**
	 * finds all assignment
	 * @return list of all assignment
	 */
	public Iterable<Assignment> findAllAssignments(){
		return assignmentRepository.findAll();
	}
	

}

