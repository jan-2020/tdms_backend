
package in.codeblog.tdms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.Group;
import in.codeblog.tdms.service.GroupService;
import in.codeblog.tdms.service.MapValidationErrorService;
/**
 * 
 * @author AjiT
 *
 */

@RestController
@RequestMapping("/group")
@CrossOrigin(origins = "*")
public class GroupController {
	@Autowired
	private GroupService groupService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/save")
	public ResponseEntity<?> saveGroup(@Valid @RequestBody Group group, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Group resultGroup = groupService.saveOrUpdate(group);
		return new ResponseEntity<Group>(resultGroup, HttpStatus.OK);
	}

	@GetMapping("/{groupId}")
	public ResponseEntity<?> findGroupById(@PathVariable int groupId) {
		Group group = groupService.findGroupById(groupId);
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<Group> groups = groupService.findAll();
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}

	@GetMapping("/myGroups/{userId}")
	public ResponseEntity<?> findMyGroup(@PathVariable int userId) {
		System.out.println(userId);
		List<Group> groups = groupService.findMyGroup(userId);
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}

	@GetMapping("/otherGroups/{userId}")
	public ResponseEntity<?> findOtherGroup(@PathVariable int userId) {
		List<Group> groups = groupService.findOtherGroup(userId);
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}

	@PutMapping("/changeStatus/{groupId}")
	public ResponseEntity<?> changeStauts(@PathVariable int groupId) {
		Integer result = groupService.changeStatus(groupId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	@PostMapping("createDefault")
	public void createDefaultGroup(){
	        groupService.createDefaultGroup();
	}

}
