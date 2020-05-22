package in.codeblog.tdms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
 
       @Override
     Iterable<Group> findAll();
    
}
