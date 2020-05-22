package in.codeblog.tdms.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.service.AssignmentService;
import in.codeblog.tdms.service.MapValidationErrorService;


@RestController
@RequestMapping("/assignment")
@CrossOrigin
public class AssignmentController {
	
	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	/**
	 * this request is responsible for creating a new assignment
	 * @param assignment
	 * @param result
	 * @return
	 */
	@PostMapping("")
	ResponseEntity<?> createNewAssignment(@Valid @RequestBody Assignment assignment,BindingResult result){
		System.out.println("post called");
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap!=null) {
			return errorMap;
		}
		Assignment returnedAssignment=assignmentService.saveOrUpdateAssignment(assignment);
		
		return new ResponseEntity<Assignment>(returnedAssignment,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	Iterable<Assignment> getAllAssignments(){
		return assignmentService.findAllAssignments();
		
	}
	
	@GetMapping("/{id}")
	Optional<Assignment> getAssignmentById(@PathVariable Long id){
		return assignmentService.findById(id);
	}
	
	
	@GetMapping("/subtopic/{subTopicName}")
	List<Assignment> getAssignmentBySubTopicName(@PathVariable String subTopicName){
		return assignmentService.findBySubTopicName(subTopicName);
	}
}
