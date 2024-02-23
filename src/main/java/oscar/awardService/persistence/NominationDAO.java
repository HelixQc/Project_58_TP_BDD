package oscar.awardService.persistence;

import oscar.awardService.data.NominationRepository;
import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import java.util.List;

/**
 * Implements
 * CRUD
 * */

public  class NominationDAO implements INominationDAO {

    @Override
    public Nomination findNominationById(int i) {
        Nomination n = NominationRepository.getInstance().getAllNominations().get(i);
        return n;
    }

    @Override
    public void createNomination(String name) {

    }

    @Override
    public void deleteNomination(Nomination n) {

    }

    @Override
    public List<Nomination> findAllNomination() {
        return NominationRepository.getInstance().getAllNominations();
    }

    @Override
    public Nomination UpdateNomination(Nomination n) {
        return null;
    }
}
