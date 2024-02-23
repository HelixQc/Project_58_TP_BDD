package oscar.awardService.persistence;

import oscar.awardService.model.Award;

import java.awt.*;
import java.util.List;
/**
 * Implements
 * CRUD
 * */
public class AwardDAO_DB implements IAwardDAO{

    @Override
    public Award findAwardByName(String name) {
        return null;
    }

    @Override
    public void createAward(String award) {

    }

    @Override
    public void deleteAward(Award award) {

    }

    @Override
    public Award UpdateAward(Award award) {
        return null;
    }

    @Override
    public List<Award> findAllAward() {
        return null;
    }
}
