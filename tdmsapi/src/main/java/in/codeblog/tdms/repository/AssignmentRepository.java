package in.codeblog.tdms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import in.codeblog.tdms.domain.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment,Long> {

	Assignment findByAssignmentIdentifier(String assignmentId);

	

	

}
