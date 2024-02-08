package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import java.util.List;

/**
* CRUD
*/
public interface INominationDAO {

    void createAward(Nomination n);
    void deleteAward(Nomination n);
    List<Award> ReadAward(Nomination n);
    Award UpdateAward(Nomination n);

}
