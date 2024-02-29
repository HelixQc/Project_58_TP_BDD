package oscar.awardService.data;


import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO_Memory;

import java.util.ArrayList;
import java.util.List;

/**
 *Documentation
 */
    public class NominationRepository {

        AwardDAO_Memory awardDAO = new AwardDAO_Memory();

        // Singleton instance
        private static NominationRepository instance;

        // List to hold nominations
        private List<Nomination> nominations;

        // Private constructor to prevent instantiation from outside
        private NominationRepository() {
            nominations = new ArrayList<>();
            populateNomination();
        }

        // Method to get the singleton instance
        public static NominationRepository getInstance() {
            if (instance == null) {
                instance = new NominationRepository();
            }
            return instance;
        }

        private void populateNomination(){
            Nomination nomination = new Nomination(1,2024, 8.5, "Harry Potter", new ArrayList<>(), awardDAO.findAwardByName("Best Movie"));
            nominations.add(nomination);

            Nomination nomination1 = new Nomination(2,2022, 7.5, "Star Wars", new ArrayList<>(), awardDAO.findAwardByName("Best Movie"));
            nominations.add(nomination1);
        }

        // Method to get all nominations
        public List<Nomination> getAllNominations() {
            return nominations;
        }
    }


