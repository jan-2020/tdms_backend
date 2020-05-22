package in.codeblog.tdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codeblog.tdms.domain.Document;
import in.codeblog.tdms.repository.DocumentRepository;

@Service
public class DocumentService {
	
	@Autowired
	DocumentRepository documentRepository;

	public Document saveOrUpdateDocument(Document document) {
		// TODO Auto-generated method stub
		return documentRepository.save(document);
	}

	public Iterable<Document> findAllDocuments() {
		// TODO Auto-generated method stub
		return documentRepository.findAll();
	}

}
