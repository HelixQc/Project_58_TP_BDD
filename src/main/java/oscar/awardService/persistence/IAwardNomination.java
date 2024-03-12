package oscar.awardService.persistence;

import oscar.awardService.model.AwardNomination;

import java.util.List;

public interface IAwardNomination {

    void createAwardNomination(AwardNomination an);
    void deleteAwardNomination(AwardNomination an);
    void updateAwardNomination(AwardNomination an);
    List<AwardNomination> readAwardNomination();
}
