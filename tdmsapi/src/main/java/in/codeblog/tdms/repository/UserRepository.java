package in.codeblog.tdms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

	Iterable<User> findByRole(String roleName);

	
}
