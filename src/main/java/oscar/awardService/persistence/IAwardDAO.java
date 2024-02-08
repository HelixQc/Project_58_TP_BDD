package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import java.util.List;
/**
 * CRUD
 */
public interface IAwardDAO {

    void createAward(Award award);
    void deleteAward(Award award);
    List<Award> ReadAward(Award award);
    Award UpdateAward(Award award);

}
