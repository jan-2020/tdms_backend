package in.codeblog.tdms.reposiorities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.User;
@Repository
/**
 * This user repository will perform all the crud operation related to the user
 * @author Ajeet
 *
 */
public interface UserRepository extends CrudRepository<User, Long>  {
/**
 * This findAll method will have the return the list of all users	
 */
	@Override
	public List<User> findAll();
/**
 * 	This findAll will take a id and return user with matching id 
 * @param id
 * @return user with the matching id
 */
    
    public User findById(long id);
    
	
	
}
