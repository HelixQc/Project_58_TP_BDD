package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import java.util.List;

/**
 * Implements
 * CRUD
 * */

public  class NominationDAO implements INominationDAO{
    @Override
    public Nomination findNominationById() {
        return null;
    }

    @Override
    public void createNomination(Nomination n) {

    }

    @Override
    public void deleteNomination(Nomination n) {

    }

    @Override
    public List<Award> findAllNomination(Nomination n) {
        return null;
    }

    @Override
    public Award UpdateNomination(Nomination n) {
        return null;
    }

    /**
     * implement
     * crud
     */

}
