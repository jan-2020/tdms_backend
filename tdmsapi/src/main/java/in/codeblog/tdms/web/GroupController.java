package in.codeblog.tdms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.Group;
import in.codeblog.tdms.service.GroupService;
@RequestMapping("tdms/groups")
@RestController
@CrossOrigin
public class GroupController {
    
	 @Autowired
	 private GroupService groupService;
    
	 @GetMapping("/all")
	 public Iterable<Group> findAllGroupsByName(){
    	return groupService.findAllGroups();
    }
    
}
