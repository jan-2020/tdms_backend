package in.codeblog.tdms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.domain.Document;
import in.codeblog.tdms.domain.Trainee;
import in.codeblog.tdms.service.AssignmentService;
import in.codeblog.tdms.service.DocumentService;
import in.codeblog.tdms.service.TraineeService;


@CrossOrigin
@RequestMapping("api/trainee")
@RestController
/**
 * This TraineeController handle all the request   
 * @author Raj
 *
 */
public class TraineeController {

    @Autowired
    private TraineeService traineeService;
    @Autowired
	private DocumentService documentService;
	@Autowired
    private AssignmentService assignmentService;
	/**
	 * This create Trainee will create or update the trainee   
	 * @param trainee
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<?>createTrainee(@Valid @RequestBody Trainee trainee)
	{
		trainee=traineeService.saveOrUpdate(trainee);
		return new ResponseEntity<Trainee>(trainee,HttpStatus.CREATED);
	}
	
/**
 * This List of assinged Documents will return the list of docements
 * @return listOfDocuments
 */
	@GetMapping("/listOfAssignedDocuments")
	public ResponseEntity<?>listOfAssignedDocuments()
	{
		//This is the dependency this will have to be got from session based on the request 
		int traineeId=1;
		Trainee trainee=traineeService.getListOfAssignedDocuments(traineeId);
		Set<Document>documents=trainee.getAssignedDocuments();
		System.out.println(documents);
		
		return new ResponseEntity<Set<Document>>(documents,HttpStatus.OK);
	}
	
	
	/**
	 * This List of Assinged Documents.
	 * @return
	 */
	@GetMapping("/listOfAssignedAssignments")
		public ResponseEntity<?>listOfAssignedAssignments()
		{
		//This is the dependency this will have to be got from session based on the request 
			int traineeId=1;
			Trainee trainee=traineeService.getListOfAssignedAssignments(traineeId);
			Set<Assignment>assignments=trainee.getAssignedAssignments();
			return new ResponseEntity<Set<Assignment>>(assignments,HttpStatus.OK);
		}
	
	
	/**
	 * This getDocumnet will get the document by the documentId
	 * @param documentId
	 * @return
	 */
	@GetMapping("/document/{documentId}")
	public ResponseEntity<?>getDocument(@PathVariable int documentId)
	{
		Document document=documentService.getDocumentUsingId(documentId);
		return new ResponseEntity<Document>(document,HttpStatus.OK);
	}
/**
 * 	
 * @param assignmentId
 * @return
 */
	@GetMapping("/assignment/{assignmentId}")
	public ResponseEntity<?>getAssignment(@PathVariable int assignmentId)
	{
		Assignment assignment=assignmentService.getAssignmentUsingId(assignmentId);
		return new ResponseEntity<Assignment>(assignment,HttpStatus.OK);
	}
   
	/**
	 * 
	 * @param file
	 * @param userId
	 * @param assignmentId
	 * @return
	 */
	@PostMapping("/upload/{userId}/{assignmentId}")
	public ResponseEntity<?>uploadAnAssignment(@RequestParam("file") MultipartFile file,@PathVariable int userId,@PathVariable int assignmentId)
	{
		if(file.isEmpty())
		{
			return new ResponseEntity<String>("Empty file upload file having some content...", HttpStatus.OK);
		}
	String whereToUploadFile="c://temp//";
	String fileName=null;
	try
	{
	byte[] bytes=file.getBytes();
	fileName=java.util.UUID.randomUUID().toString()+".txt";
	Path path=Paths.get(whereToUploadFile+fileName);
	Files.write(path, bytes);
	}catch(IOException ioException)
	{
		return new ResponseEntity<String>("Some error while submitting your assignment", HttpStatus.NOT_ACCEPTABLE);
	}
	//This is the dependency this will have to be got from session based on the request 
	userId=1;
	traineeService.assignmentUploader(fileName,assignmentId,userId);
	return new ResponseEntity<String>("Assignment Submitted Successfully", HttpStatus.OK);
	}
    











 
}
