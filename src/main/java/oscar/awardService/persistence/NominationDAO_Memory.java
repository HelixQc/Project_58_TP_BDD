package oscar.awardService.persistence;

import oscar.awardService.data.NominationRepository;
import oscar.awardService.model.Nomination;
import java.util.List;

/**
 * Implements
 * CRUD
 * */

public  class NominationDAO_Memory implements INominationDAO {

    @Override
    public Nomination findNominationById(int i) {
        Nomination n = NominationRepository.getInstance().getAllNominations().get(i);
        return n;
    }

    @Override
    public void createNomination(Nomination n ) {
        findAllNomination().add(n);
        System.out.println("The nomination have been added with success");
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
