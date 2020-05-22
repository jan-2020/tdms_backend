package in.codeblog.tdms.repositories;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.Permission;
/**
 * this module perform the CurdOperations
 * Extended CrudRepository and  JpaRepository classes
 * @author Govind
 *
 */

@Repository

public interface PermissionRepository extends CrudRepository<Permission,Long>, JpaRepository<Permission, Long>{

	
	Permission findPermissionByModuleId(String ModuleId);
	

	
	@Override
	List<Permission> findAll();
	

	
	@Query("from  Permission  where moduleId=?1")
	List <Permission> findByModuleId(String moduleId);






	
}

	
