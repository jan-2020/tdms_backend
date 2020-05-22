	package in.codeblog.tdms.web;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	import in.codeblog.tdms.domain.Permission;
	import in.codeblog.tdms.service.PermissionService;

	@RestController
	@RequestMapping("/api/permission")
	@CrossOrigin
	public class PermissionController {

		@Autowired
		private PermissionService permissionService;

		@PostMapping("")
		public ResponseEntity<?> createNewPermission(@RequestBody Permission permission) {

			Permission per = permissionService.saveOrUpdateProject(permission);
			return new ResponseEntity<Permission>(per, HttpStatus.CREATED);
		}
		
		@GetMapping("/{moduleId}")
		public ResponseEntity<?> getPermissionById(@PathVariable String moduleId){
			Permission permission = permissionService.findPermissionByModuleId(moduleId);
			return new ResponseEntity<Permission>(permission, HttpStatus.OK);
		}
		@GetMapping("/all")
		public Iterable<Permission> getAllPermissions(){
			return permissionService.findAllPermission();
		}
		@GetMapping("/all/{moduleId}")
		public List<Permission> findByModuleId(@PathVariable String moduleId)
		{
			return permissionService.findByModuleId(moduleId);
		}
		

		
	






}
