package oscar.electionServices.persistence;

import oscar.electionServices.model.AwardElector;

import java.util.List;

public interface IAwardElector {

    void createAwardElector(AwardElector ae);
    void deleteAwardElector(AwardElector ae);
    void UpdateAwardElector(AwardElector ae);
    List<AwardElector> readAwardElector();

}
