package oscar.awardService.persistence.JDBC;

import oscar.awardService.model.AwardNomination;
import oscar.awardService.persistence.ConnectionAwardDAO;
import oscar.awardService.persistence.IAwardNomination;

import java.util.List;

public class AwardNominationDAO_JDBC extends ConnectionAwardDAO implements IAwardNomination {
    @Override
    public void createAwardNomination(AwardNomination an) {

    }

    @Override
    public void deleteAwardNomination(AwardNomination an) {

    }

    @Override
    public void updateAwardNomination(AwardNomination an) {

    }

    @Override
    public List<AwardNomination> readAwardNomination() {
        return null;
    }
}
