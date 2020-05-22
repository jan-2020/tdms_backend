package in.codeblog.tdms.repository;
/**
 * The repository for the Assingment 
 * All the crud operations will be performed here
 */
import org.springframework.data.repository.CrudRepository;

import in.codeblog.tdms.domain.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment,Integer> {
/**
 * This method finds all assingment by id
 * @param id
 * @return Assingment
 */
	public Assignment findById(int id);
	
}
