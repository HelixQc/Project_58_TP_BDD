package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import java.util.List;
/**
 * CRUD
 */

public interface IAwardDAO {
  
    Award findAwardByName(String name);
    void createAward(Award award);
    void deleteAward(Award award);
    List<Award> findAll(Award award);
    Award UpdateAward(Award award);


}
