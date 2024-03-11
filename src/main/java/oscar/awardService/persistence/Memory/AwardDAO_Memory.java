package oscar.awardService.persistence.Memory;

import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.persistence.IAwardDAO;

import java.util.List;
/**
 * implements
 * crud
*/
public class AwardDAO_Memory implements IAwardDAO {

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
        Award a = new Award(7,name);
    }


    @Override
    public List<Award> findAllAward() {
        return  AwardRepository.getInstance().getAllAwards();
    }

    @Override
    public void deleteAward(Award award) {
        AwardRepository.getInstance().getAllAwards().remove(award);
    }

    @Override
    public Award UpdateAward(Award award) {
        return null;
    }
}
