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
        awards.add(new Award("Best Actor"));
        awards.add(new Award("Best Actress"));
        awards.add(new Award("Best Director"));
        awards.add(new Award("Best Picture"));
        awards.add(new Award("Best Original Screenplay"));
        awards.add(new Award("Best Movie"));
    }

    // Method to get all awards
    public List<Award> getAllAwards() {
        return awards;
    }

}

