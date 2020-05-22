package in.codeblog.tdms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.model.Users;
@Repository
public interface UsersRepo extends CrudRepository<Users, Long>{
	
	@Override
	Iterable<Users> findAll();
	
	@Override
    Iterable<Users> findAllById(Iterable<Long> ids);

}
