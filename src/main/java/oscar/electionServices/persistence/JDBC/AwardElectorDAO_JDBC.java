package oscar.electionServices.persistence.JDBC;

import oscar.electionServices.model.AwardElector;
import oscar.electionServices.persistence.ElectionConnectionDAO;
import oscar.electionServices.persistence.IAwardElector;

import java.util.List;

public class AwardElectorDAO_JDBC extends ElectionConnectionDAO implements IAwardElector {
    @Override
    public void createAwardElector(AwardElector ae) {

    }

    @Override
    public void deleteAwardElector(AwardElector ae) {

    }

    @Override
    public void UpdateAwardElector(AwardElector ae) {

    }

    @Override
    public List<AwardElector> readAwardElector() {
        return null;
    }
}
