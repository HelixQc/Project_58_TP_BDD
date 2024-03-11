package oscar.awardService.control;

import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.awardService.persistence.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;

import java.util.List;

/**
 * As a film historian,
 * I want to see all nomination
 * categories and respective winners,
 * so I can look for trends and
 * statistics in film awards.
 */
public class SeeNomination {

    NominationDAO_Memory nominationDAO = new NominationDAO_Memory();
    NominationDAO_DB_JDBC nominationDAO_db = new NominationDAO_DB_JDBC();
    NominationControl nc = new NominationControl();

    public List<Nomination> consultNominationInMemoryRepository(){
        return nominationDAO.findAllNomination();
    }
    public List<Nomination> consultNominationJDBC(){
        return nominationDAO_db.findAllNomination();
    }
    public List<Nomination>consultWinner(){
        return null;
    }

    public void userStoryController(){
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < consultNominationInMemoryRepository().size(); i++){
            System.out.println("ID: "+consultNominationInMemoryRepository().get(i).getId());
            System.out.println("Year: "+ consultNominationInMemoryRepository().get(i).getYear());
            System.out.println("Obtained Shares: "+ consultNominationInMemoryRepository().get(i).getObtainedShares());
            System.out.println("Nominated Work: "+ consultNominationInMemoryRepository().get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
            System.out.println("---Awards---");
            for(int j = 0 ; j <  nominationDAO.findAllNomination().size(); j++)
                System.out.println(nominationDAO.findAllNomination().get(j).getAwards());
            System.out.println("---------------------------------------------");
        }
    }
    public void userStoryControllerJDBC(){

        nc.showAllNominationJDBC();
        System.out.println("---------------------------------------------");
        AwardUI aUI = new AwardUI();
        aUI.showTheAwardListJDBC();
    }

}
