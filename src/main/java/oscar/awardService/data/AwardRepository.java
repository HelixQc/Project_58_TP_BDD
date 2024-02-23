package oscar.awardService.data;
import oscar.awardService.model.Award;

import java.util.ArrayList;
import java.util.List;

/**
 *Documentation
 */
public class AwardRepository {

    // Singleton instance
    private static AwardRepository instance = null;

    // List to hold awards
    public List<Award> awards;

    // Private constructor to prevent instantiation from outside
    private AwardRepository() {
        awards = new ArrayList<>();
        initializeAwards();
    }

    // Method to get the singleton instance
    public static AwardRepository getInstance() {
        if (instance == null) {
            instance = new AwardRepository();
        }
        return instance;
    }

    // Method to initialize awards
    private void initializeAwards() {
        awards.add(new Award("BestActor"));
        awards.add(new Award("BestActress"));
        awards.add(new Award("BestDirector"));
        awards.add(new Award("BestPicture"));
        awards.add(new Award("BestOriginalScreenplay"));
        awards.add(new Award("BestMovie"));
    }

    // Method to get all awards
    public List<Award> getAllAwards() {
        return awards;
    }

}

