package in.codeblog.tdms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.Assignment;
import java.lang.String;
import java.util.List;
import java.lang.Long;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
	
	
	
	Optional<Assignment> findById(Long id);
	
	List<Assignment> findBySubTopicName(String subTopicName);
	

	@Override
	Iterable<Assignment> findAll();

}
