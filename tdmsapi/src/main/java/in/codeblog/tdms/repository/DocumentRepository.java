package in.codeblog.tdms.repository;

/**
 * The repository for the Document 
 * All the crud operations will be performed here
 */

import org.springframework.data.repository.CrudRepository;

import in.codeblog.tdms.domain.Document;

public interface DocumentRepository extends CrudRepository<Document,Integer> {
/**
 * The method finds the document by its id
 * @param id
 * @return
 */
	public Document findById(int id);
	
}
