package oscar.awardService.control;

import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;

import java.util.List;

/**
 * As a film historian,
 * I want to see all nomination
 * categories and respective winners,
 * so I can look for trends and
 * statistics in film awards.
 */
public class SeeNomination {

    private NominationDAO_Memory nominationDAO = new NominationDAO_Memory();
    private NominationDAO_DB_JDBC nominationDAO_db = new NominationDAO_DB_JDBC();
    private NominationControl nc = new NominationControl();
    private AwardControl ac = new AwardControl();
    private AwardControl_JDBC ac_JDBC = new AwardControl_JDBC();

    private List<Nomination> consultNominationInMemoryRepository(){
        return nominationDAO.findAllNomination();
    }
    private List<Nomination> consultNominationJDBC(){
        return nominationDAO_db.findAllNomination();
    }
    private List<Nomination>consultWinner(){
        return null;
    }

    //Verifier la redondance du code
    public void userStoryController(){
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < consultNominationInMemoryRepository().size(); i++){
            System.out.println("ID: "+consultNominationInMemoryRepository().get(i).getId());
            System.out.println("Year: "+ consultNominationInMemoryRepository().get(i).getYear());
            System.out.println("Obtained Shares: "+ consultNominationInMemoryRepository().get(i).getObtainedShares());
            System.out.println("Nominated Work: "+ consultNominationInMemoryRepository().get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
            System.out.println("---Awards---");
            ac.showTheAwardList();
        }
    }


    public void userStoryControllerJDBC(){

        nc.showAllNominationJDBC();
        System.out.println("---------------------------------------------");

        ac_JDBC.showTheAwardListJDBC();
    }

}
