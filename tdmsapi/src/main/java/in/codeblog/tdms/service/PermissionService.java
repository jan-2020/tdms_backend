package in.codeblog.tdms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Permission;
import in.codeblog.tdms.repositories.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	public Permission saveOrUpdateProject(Permission permission) {

		return permissionRepository.save(permission);
	}

	public String saveOrUpdateProject(List<Permission> permissions) {
		for (Permission permission : permissions) {
			permissionRepository.save(permission);
		}
		return "Assigned Successfully";
	}

	public Permission findPermissionByModuleId(String ModuleId) {
		Permission permission = permissionRepository.findPermissionByModuleId(ModuleId);
		return permission;

	}

	public List<Permission> findByModuleId(String moduleId) {
		return permissionRepository.findByModuleId(moduleId);

	}

	public Iterable<Permission> findAllPermission() {
		return permissionRepository.findAll();

	}

	public void deletePermissionById(int id) {
		Permission permission = permissionRepository.findPermissionById(id);
		permissionRepository.delete(permission);
	}

}