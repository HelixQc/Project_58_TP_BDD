package oscar.awardService.data;


import oscar.awardService.model.Nomination;
import java.util.ArrayList;
import java.util.List;

/**
 *Documentation
 */
    public class NominationRepository {

        // Singleton instance
        private static NominationRepository instance;

        // List to hold nominations
        private List<Nomination> nominations;

        // Private constructor to prevent instantiation from outside
        private NominationRepository() {
            nominations = new ArrayList<>();
        }

        // Method to get the singleton instance
        public static NominationRepository getInstance() {
            if (instance == null) {
                instance = new NominationRepository();
            }
            return instance;
        }

        // Method to add a nomination
        public void addNomination(Nomination nomination) {
            nominations.add(nomination);
        }

        // Method to remove a nomination
        public void removeNomination(Nomination nomination) {
            nominations.remove(nomination);
        }

        // Method to get all nominations
        public List<Nomination> getAllNominations() {
            return nominations;
        }
    }


