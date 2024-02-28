package oscar.awardService.data;
import oscar.awardService.model.Award;

import java.util.ArrayList;
import java.util.List;

/**
 * The AwardRepository class represents a repository for managing awards.
 * It provides methods to interact with the awards data.
 */
public class AwardRepository {

    // Singleton instance
    private static AwardRepository instance = null;

    // List to hold awards
    public List<Award> awards;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the awards list and populates it with initial data.
     */
    private AwardRepository() {
        awards = new ArrayList<>();
        initializeAwards();
    }

    /**
     * Returns the singleton instance of AwardRepository.
     * If the instance is not yet created, it creates one.
     * @return The singleton instance of AwardRepository
     */
    public static AwardRepository getInstance() {
        if (instance == null) {
            instance = new AwardRepository();
        }
        return instance;
    }

    /**
     * Initializes the awards list with some predefined awards.
     * This method is called once during the initialization of the repository.
     */
    private void initializeAwards() {
        awards.add(new Award("Best Actor"));
        awards.add(new Award("Best Actress"));
        awards.add(new Award("Best Director"));
        awards.add(new Award("Best Picture"));
        awards.add(new Award("Best Original Screenplay"));
        awards.add(new Award("Best Movie"));
    }

    /**
     * Retrieves all awards stored in the repository.
     * @return A list containing all awards
     */
    public List<Award> getAllAwards() {
        return awards;
    }

}

