package in.codeblog.tdms.repository;

import org.springframework.data.repository.CrudRepository;

import in.codeblog.tdms.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
