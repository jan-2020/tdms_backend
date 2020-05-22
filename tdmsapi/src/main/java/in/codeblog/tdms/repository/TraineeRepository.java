package in.codeblog.tdms.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.codeblog.tdms.domain.Trainee;
/**
 * The repository for the Trainne 
 * All the crud operations will be performed here
 */

@Repository
public interface TraineeRepository extends CrudRepository<Trainee, Integer>
{
	/**
	 * This method finds the trainee by its id
	 * @param id
	 * @return a trainee
	 */
public Trainee findById(int id);

}
