package oscar.electionServices.persistence;

import oscar.electionServices.data.ElectorRepository;
import oscar.electionServices.model.Elector;

import java.util.List;

public class ElectorDAO implements IElectorDAO {

    ElectorRepository repo = ElectorRepository.getInstance();

    @Override
    public void createElector(Elector e) {

    }

    @Override
    public void deleteElector(Elector e) {
        repo.getAllElectors().remove(e);
    }

    @Override
    public List<Elector> readElector() {
        return repo.getAllElectors();
    }

    @Override
    public Elector updateElector(Elector e) {
        return null;
    }

    public Elector findElectorByWeight(int weight){
        for(int i = 0; i < repo.getAllElectors().size(); i++){
            if(repo.getAllElectors().get(i).getWeight() == weight){
                return  repo.getAllElectors().get(i);
            }
        }
        return null;
    }
}
