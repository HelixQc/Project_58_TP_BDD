package oscar.electionServices.persistence;

import oscar.awardService.model.Award;
import oscar.electionServices.model.Elector;
import java.util.List;

/**
 * CRUD
 */

public interface IElectorDAO {
    void createElector(Elector e);
    void deleteElector(Elector e);
    List<Elector> readElector(Elector e);
    Elector updateElector(Elector e);
}
