package in.codeblog.tdms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.codeblog.tdms.domain.*;
import in.codeblog.tdms.exception.DocumentIdException;
import in.codeblog.tdms.repository.*;

/**
 * Here the business logic is written.
 * @author hp
 *
 */
@Service
public class DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	
	/**
	 * This method return list of document.
	 * @return
	 */
	public Iterable<Document> findAllDocuments()
	{
		return documentRepository.findAll();
	}
	
	/**
	 * This method is used for deletion of document
	 * @param documentId
	 * @return
	 */
	public Document deleteDocumentByIdentifier(Long documentId)
	{
		Document document=documentRepository.findByDocumentId(documentId);
		if(document==null)
		{
			throw new DocumentIdException("Document with Id '"+documentId+"' does not exists !");
		}
		documentRepository.delete(document);
		return document;
	}
}
