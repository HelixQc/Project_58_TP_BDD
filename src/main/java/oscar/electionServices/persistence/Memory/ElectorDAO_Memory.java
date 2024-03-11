package oscar.electionServices.persistence.Memory;

import oscar.electionServices.data.ElectorRepository;
import oscar.electionServices.model.Elector;
import oscar.electionServices.persistence.IElectorDAO;

import java.util.List;

/**
 * The ElectorDAO class provides methods to perform CRUD operations on electors.
 * It interacts with the ElectorRepository to access elector data.
 */
public class ElectorDAO_Memory implements IElectorDAO {

    ElectorRepository repo = ElectorRepository.getInstance();

    /**
     * Creates a new elector.
     * @param e The Elector object to create
     */
    @Override
    public void createElector(Elector e) {

    }

    /**
     * Deletes an elector.
     * @param e The Elector object to delete
     */
    @Override
    public void deleteElector(Elector e) {
        repo.getAllElectors().remove(e);
    }

    /**
     * Retrieves all electors.
     * @return A list containing all electors
     */
    @Override
    public List<Elector> readElector() {
        return repo.getAllElectors();
    }

    /**
     * Updates an elector.
     * @param e The Elector object to update
     * @return The updated Elector object
     */
    @Override
    public Elector updateElector(Elector e) {
        return null;
    }

    /**
     * Finds an elector by its weight.
     * @param weight The weight of the elector to find
     * @return The Elector object if found, null otherwise
     */
    public Elector findElectorByWeight(int weight){
        for(int i = 0; i < repo.getAllElectors().size(); i++){
            if(repo.getAllElectors().get(i).getWeight() == weight){
                return  repo.getAllElectors().get(i);
            }
        }
        return null;
    }
}
