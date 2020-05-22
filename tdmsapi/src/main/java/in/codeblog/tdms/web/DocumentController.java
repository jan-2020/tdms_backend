package in.codeblog.tdms.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.domain.Document;
import in.codeblog.tdms.domain.User;
import in.codeblog.tdms.service.DocumentService;
import in.codeblog.tdms.service.UserService;

@RestController
@RequestMapping("/ytdms/document")
@CrossOrigin
public class DocumentController {

	@Autowired
	DocumentService documentService;
	
	@Autowired
	UserService userService;
	
	

	@PostMapping("")
	public ResponseEntity<?> createNewDocument(@RequestBody Document document){
		Document returnedDocument=documentService.saveOrUpdateDocument(document);
		return new ResponseEntity<Document>(returnedDocument,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Document> findAllDocuments(){
		return documentService.findAllDocuments();
	}
	
	@GetMapping("/trainee")
	public List<Document> getAllTrainees(){
		String roleName="trainee";
		List<Integer> roleIds= userService.findAllUsersByRole(roleName);
		Iterable<Document> createdDocuments=documentService.findAllDocuments();
		List<Document> allDocuments=new ArrayList<Document>();
		for(Document document:createdDocuments) {
			allDocuments.add(document);
		}
		return allDocuments;
	}
	
	
}
