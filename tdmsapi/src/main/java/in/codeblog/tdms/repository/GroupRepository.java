package in.codeblog.tdms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.Group;
/**
 * 
 * @author AjiT
 *
 */

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
	@Query(value = "SELECT * FROM groupss g where g.status = :ACTIVATE AND g.user_id = :userId", nativeQuery = true)
	public List<Group> findByStatusAndId(@Param("ACTIVATE") int ACTIVATE, @Param("userId") int userId);

	@Query(value = "SELECT * FROM groupss g where g.status = :ACTIVATE AND g.user_id <> :userId", nativeQuery = true)
	public List<Group> findOtherGroup(@Param("ACTIVATE") int ACTIVATE, @Param("userId") int userId);
	
	@Query(value="INSERT INTO groupss(id,name,status,user_id) VALUES(-123,'Generic Group',1,-123)",nativeQuery=true )
	public void createDefaultGroup();
}
