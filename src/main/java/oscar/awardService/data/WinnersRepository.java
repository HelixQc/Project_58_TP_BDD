package oscar.awardService.data;

import oscar.awardService.model.Winner;
import oscar.awardService.persistence.Memory.AwardDAO_Memory;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.electionServices.persistence.Memory.VoteDAO_Memory;

import java.util.ArrayList;
import java.util.List;

public class WinnersRepository {

    VoteDAO_Memory voteDAO = new VoteDAO_Memory();
    AwardDAO_Memory awardDAOMemory = new AwardDAO_Memory();
    NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();
    //NominationDAO_DB_JDBC nominationDAO_db_jdbc = new NominationDAO_DB_JDBC();
    //singleton
    private static WinnersRepository instance = null;

    //Winners list
    public List<Winner> winnersList;

    //private constructor
    private WinnersRepository(){
        winnersList = new ArrayList<>();
        //populateWinners();
    }

    public static WinnersRepository getInstance() {
        if(instance == null){
            instance = new WinnersRepository();
        }
        return instance;
    }

  /*  private void populateWinners() {
        winnersList.add(new Winners(awardDAOMemory.findAwardByName("Best Actor"), nominationDAOMemory.findAllNomination(),voteDAO.readVote()));
        winnersList.add(new Winners(awardDAOMemory.findAwardByName("Best Actress"), nominationDAOMemory.findAllNomination(),voteDAO.readVote()));
        winnersList.add(new Winners(awardDAOMemory.findAwardByName("Best Director"), nominationDAOMemory.findAllNomination(),voteDAO.readVote()));
        winnersList.add(new Winners(awardDAOMemory.findAwardByName("Best Picture"), nominationDAOMemory.findAllNomination(),voteDAO.readVote()));
        winnersList.add(new Winners(awardDAOMemory.findAwardByName("Best Original Screenplay"), nominationDAOMemory.findAllNomination(),voteDAO.readVote()));
        winnersList.add(new Winners(awardDAOMemory.findAwardByName("Best Movie"), nominationDAOMemory.findAllNomination(),voteDAO.readVote()));
    }
*/
    public List<Winner> getAllWinnersList(){
        return winnersList;
    }
}
