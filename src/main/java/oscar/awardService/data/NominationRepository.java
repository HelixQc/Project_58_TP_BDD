package oscar.awardService.data;


import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO_Memory;
import oscar.electionServices.data.VoteRepository;
import oscar.electionServices.persistence.VoteDAO_Memory;

import java.util.ArrayList;
import java.util.List;

/**
 * The NominationRepository class represents a repository for managing nominations.
 * It provides methods to interact with the nominations data.
 */
    public class NominationRepository {

        VoteDAO_Memory voteDAOMemory = new VoteDAO_Memory();
        AwardDAO_Memory awardDAOMemory = new AwardDAO_Memory();



        // Singleton instance
        private static NominationRepository instance;

        // List to hold nominations
        private List<Nomination> nominations;

        /**
         * Private constructor to prevent instantiation from outside the class.
         * Initializes the nominations list and populates it with initial data.
         */
        private NominationRepository() {
            nominations = new ArrayList<>();
            populateNomination();
        }

        /**
         * Returns the singleton instance of NominationRepository.
         * If the instance is not yet created, it creates one.
         * @return The singleton instance of NominationRepository
         */
        public static NominationRepository getInstance() {
            if (instance == null) {
                instance = new NominationRepository();
            }
            return instance;
        }

        /**
         * Populates the nominations list with initial data.
         * This method is called once during the initialization of the repository.
         */
        private void populateNomination(){
            Nomination nomination = new Nomination(1,2024, 8.5, "Harry Potter", voteDAOMemory.readVote(),awardDAOMemory.findAllAward());
            nominations.add(nomination);

            Nomination nomination1 = new Nomination(2,2022, 7.5, "Star Wars", voteDAOMemory.readVote(), awardDAOMemory.findAllAward());
            nominations.add(nomination1);
        }

        // Method to get all nominations
        public List<Nomination> getAllNominations() {
            return nominations;
        }
    }


