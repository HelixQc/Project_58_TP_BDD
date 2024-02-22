package oscar.awardService.data;
import oscar.awardService.model.Award;

import java.util.ArrayList;
import java.util.List;

/**
 *Documentation
 */
public class AwardRepository {

    // Singleton instance
    private static AwardRepository instance;

    // List to hold awards
    private List<Award> awards;

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
    }

    // Method to get all awards
    public List<Award> getAllAwards() {
        return awards;
    }

    // Method to add an award
    public void addAward(Award award) {
        awards.add(award);
    }

    // Method to remove an award
    public void removeAward(Award award) {
        awards.remove(award);
    }
}

