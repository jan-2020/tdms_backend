package in.codeblog.tdms.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Assignment;
import in.codeblog.tdms.domain.Document;
import in.codeblog.tdms.domain.Trainee;
import in.codeblog.tdms.repository.TraineeRepository;

@Service
/**
 * This class traineeService will hold all the business logics related to the trainee 
 * @author Raj
 *
 */
public class TraineeService {
	@Autowired
private TraineeRepository traineeRepository;

/**
 * This saveOrUpdate method will save the trainee 
 * @param trainee
 * @return traineeRepository
 */
	public Trainee saveOrUpdate(Trainee trainee)
{
	
	return traineeRepository.save(trainee);	
}

/**
 * The getListOfAssingmentDocument will return the trainee and 
 * 
 * @param traineeId
 * @return
 */
	public Trainee getListOfAssignedDocuments(int traineeId) {
	
	Trainee trainee=traineeRepository.findById(traineeId);
	Set<Document>documentsList=null;
	documentsList=trainee.getAssignedDocuments();
	Set<Document>newDocumentsList=new HashSet<>();
	for(Document document:documentsList)
	{  
		//System.out.println(document);
		document.setContent("");;
		newDocumentsList.add(document);
	}
	documentsList=null;
	trainee.setAssignedDocuments(newDocumentsList);
return trainee;
}

/**
 * This getListOfAssingment will return the trainee and take traineeId as a parameter	
 * @param traineeId
 * @return
 */
	public Trainee getListOfAssignedAssignments(int traineeId) {
	
	Trainee trainee=traineeRepository.findById(traineeId);
	Set<Assignment>assignmentsList=null;
	assignmentsList=trainee.getAssignedAssignments();
	Set<Assignment>newAssignmentsList=new HashSet<>();
	for(Assignment assignment:assignmentsList)
	{
		assignment.setContent("");
		newAssignmentsList.add(assignment);
	}
	assignmentsList=null;
	trainee.setAssignedAssignments(newAssignmentsList);
    return trainee;
    }

/**
 * This assignmentUploader method will take fileName , assingmentId and UseId as a parameter
 * @param fileName
 * @param assignmentId
 * @param userId
 */
public void assignmentUploader(String fileName, int assignmentId,int userId) {
	Trainee trainee=traineeRepository.findById(userId);
	trainee.getSubmittedOne().put(assignmentId,fileName);
	traineeRepository.save(trainee);
}
}
