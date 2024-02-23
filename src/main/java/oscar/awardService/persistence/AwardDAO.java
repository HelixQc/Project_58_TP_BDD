package oscar.awardService.persistence;

import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;

import java.util.List;
/**
 * implements
 * crud
*/
public class AwardDAO implements IAwardDAO{

    @Override
    public Award findAwardByName(String name) {
        List<Award> allAwards = AwardRepository.getInstance().getAllAwards();

        for (Award award : allAwards) {
            if (award.getName().equalsIgnoreCase(name)) {
                return award;
            }
        }
        return null;
    }

    @Override
    public void createAward(String name) {
        Award a = new Award(name);
    }


    @Override
    public List<Award> findAllAward() {
        return  AwardRepository.getInstance().getAllAwards();
    }



    @Override
    public void deleteAward(Award award) {

    }
    @Override
    public Award UpdateAward(Award award) {
        return null;
    }
}
