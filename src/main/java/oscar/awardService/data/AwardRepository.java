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
        awards.add(new Award(1,"Best Actor"));
        awards.add(new Award(2,"Best Actress"));
        awards.add(new Award(3,"Best Director"));
        awards.add(new Award(4,"Best Picture"));
        awards.add(new Award(5,"Best Original Screenplay"));
        awards.add(new Award(6,"Best Movie"));
    }

    /**
     * Retrieves all awards stored in the repository.
     * @return A list containing all awards
     */
    public List<Award> getAllAwards() {
        return awards;
    }

}

