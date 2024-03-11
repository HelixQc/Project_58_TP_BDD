package oscar.electionServices.persistence.Memory;

import oscar.electionServices.data.AwardElectorRepository;
import oscar.electionServices.model.AwardElector;
import oscar.electionServices.persistence.IAwardElector;

import java.util.List;

public class AwardElectorDAO_Memory implements IAwardElector {




    @Override
    public void createAwardElector(AwardElector ae) {
        readAwardElector().add(ae);

        System.out.println("AwardElector data as been added in the bridges");
    }

    @Override
    public void deleteAwardElector(AwardElector ae) {

    }

    @Override
    public void UpdateAwardElector(AwardElector ae) {

    }

    @Override
    public List<AwardElector> readAwardElector() {
        return AwardElectorRepository.getInstance().getBridgeAwardElector();
    }
}
