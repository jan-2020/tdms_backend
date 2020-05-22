package in.codeblog.tdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Document;
import in.codeblog.tdms.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
/**
 * The method will return a document by documentId
 * @param documentId
 * @return
 */
	public Document getDocumentUsingId(int documentId)
	{
		return documentRepository.findById(documentId);
	}
}
