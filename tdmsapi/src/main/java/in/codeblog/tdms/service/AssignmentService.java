package in.codeblog.tdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.repository.AssignmentRepository;

@Service
/**
 * This class will hold all the business logics
 * @author Raj
 *
 */
public class AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;
/**
 * This method will return an assingment by its id 	
 * @param assignmentId
 * @return
 */
	public Assignment getAssignmentUsingId(int assignmentId)
	{
		return assignmentRepository.findById(assignmentId);
	}
}
