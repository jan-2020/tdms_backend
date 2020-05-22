package in.codeblog.tdms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.repository.AssignmentRepository;

@Service
public class AssignmentService {

	@Autowired
	AssignmentRepository assignmentRepository; 
	public Assignment saveOrUpdateAssignment(Assignment assignment) {
		
		return assignmentRepository.save(assignment);
	}
	
	
	public Iterable<Assignment> findAllAssignments(){
		return assignmentRepository.findAll();
	}
	public void deleteAssignmentById(Long id) {
		Optional<Assignment> assignment=assignmentRepository.findById(id);
		if(assignment==null) {
			
		}
		assignmentRepository.deleteById(id);
	}


	public Assignment findAssignmentByIdentifier(String assignmentId) {
		Assignment assignment=assignmentRepository.findByAssignmentIdentifier(assignmentId);
		return assignment;
	}
	
	

}
