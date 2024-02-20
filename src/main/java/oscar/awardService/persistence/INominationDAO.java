package oscar.awardService.persistence;


import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import java.util.List;

/**
* CRUD
*/
public interface INominationDAO {
Nomination findNominationById();
    void createNomination(Nomination n);
    void deleteNomination(Nomination n);
    List<Award> findAll(Nomination n);
    Award UpdateNomination(Nomination n);

}
