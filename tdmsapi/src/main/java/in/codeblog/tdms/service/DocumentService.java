package in.codeblog.tdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Document;
import in.codeblog.tdms.exception.DocumentIdException;
import in.codeblog.tdms.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	public Document saveOrUpdate(Document document) {
			return documentRepository.save(document);
		
	}
	public Document findByDocumentId(Long documentId)
	{
		Document document=documentRepository.findByDocumentId(documentId);
		if(document==null)
		{
			throw new DocumentIdException("Document Id '"+documentId+"' does not exists !");
		}
		return document;
		
	}
	public Iterable<Document> findAllDocuments()
	{
		return documentRepository.findAll();
	}
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
