package in.codeblog.tdms.service;
/**
 * @author vijay solanki
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Group;
import in.codeblog.tdms.repository.GroupRepository;

@Service
public class GroupService {
      
	 
	   @Autowired   
      /**
       * This method is used for  find all group
       */
	   private GroupRepository groupRepository;
          public Iterable<Group> findAllGroups() {
        	return groupRepository.findAll();
         }  
  }
   