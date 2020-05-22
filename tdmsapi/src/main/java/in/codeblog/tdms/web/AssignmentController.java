package in.codeblog.tdms.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.service.AssignmentService;

@RestController
@RequestMapping("/ytdms/assignment")
@CrossOrigin
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewAssignment(@RequestBody Assignment assignment){
		Assignment returnedAssignment=assignmentService.saveOrUpdateAssignment(assignment);
		return new ResponseEntity<Assignment>(returnedAssignment,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{assignmentId}")
	public ResponseEntity<?> getProjectById(@PathVariable String assignmentId){
		Assignment assignment=assignmentService.findAssignmentByIdentifier(assignmentId);
		return new ResponseEntity<Assignment>(assignment,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/all")
	public Iterable<Assignment> getAllAssignments(){
		return assignmentService.findAllAssignments();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAssignment(@PathVariable Long id){
		assignmentService.deleteAssignmentById(id);
		return new ResponseEntity<String>("Assignment wid ID'"+id+"' was deleted",HttpStatus.OK);
	}
}
