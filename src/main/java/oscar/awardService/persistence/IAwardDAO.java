package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import java.util.List;
/**
 * CRUD
 */

public interface IAwardDAO {
  
    Award findAwardByName(String name);
    void createAward(String award);
    void deleteAward(Award award);
    Award UpdateAward(Award award);
    List<Award> findAllAward();
}
