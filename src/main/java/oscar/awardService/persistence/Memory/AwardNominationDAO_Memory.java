package oscar.awardService.persistence.Memory;

import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.persistence.IAwardNomination;

import java.util.List;

public class AwardNominationDAO_Memory implements IAwardNomination {


    @Override
    public void createAwardNomination(AwardNomination an) {

    }

    @Override
    public void deleteAwardNomination(AwardNomination an) {

    }

    @Override
    public void updateAwardNomination(AwardNomination an) {

    }

    @Override
    public List<AwardNomination> readAwardNomination() {
        return AwardNominationRepository.getInstance().getBridgeAwardNomination();
    }
}
