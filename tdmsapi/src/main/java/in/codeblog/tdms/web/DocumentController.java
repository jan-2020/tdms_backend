package in.codeblog.tdms.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.codeblog.tdms.domain.*;
import in.codeblog.tdms.service.MapValidationErrorService;
import in.codeblog.tdms.service.DocumentService;

@RestController
@RequestMapping("/api/document")
@CrossOrigin
public class DocumentController {
	@Autowired
	DocumentService documentService;
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> saveDocument(@Valid @RequestBody Document document,BindingResult result)
	{
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		Document doc=documentService.saveOrUpdate(document);
		return new ResponseEntity<Document>(doc, HttpStatus.CREATED);
	}
	@GetMapping("/{documentId}")
	public ResponseEntity<?> getDocumentByDocumentId(@PathVariable Long documentId)
	{
		Document document=documentService.findByDocumentId(documentId);
		return new ResponseEntity<Document>(document,HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Document> findAllDocuments()
	{
		return documentService.findAllDocuments();
	}
	
	
}
