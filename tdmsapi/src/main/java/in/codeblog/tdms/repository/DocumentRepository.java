package in.codeblog.tdms.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codeblog.tdms.domain.Document;

/**
 * This layer is used to perform all the CRUD operations.
 */

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

	Document findByDocumentId(Long documentId);
	
	@Override
	Iterable<Document> findAll();

}
