package in.codeblog.tdms.reposiorities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.User;
@Repository

public interface UserRepository extends CrudRepository<User, Long>  {
	
    
	
	
}
