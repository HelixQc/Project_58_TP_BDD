package oscar.awardService.control;

import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.NominationDAO;
import oscar.awardService.persistence.NominationDAO_DB;

import java.util.List;

/**
 * As a film historian,
 * I want to see all nomination
 * categories and respective winners,
 * so I can look for trends and
 * statistics in film awards.
 */
public class SeeNomination {

    NominationDAO nominationDAO = new NominationDAO();
    NominationDAO_DB nominationDAO_db = new NominationDAO_DB();

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
            for(int j = 0 ; j <  consultNominationInMemoryRepository().get(i).getAwards().size(); j++)
                System.out.println(consultNominationInMemoryRepository().get(i).getAwards().get(j).getName());
            System.out.println("---------------------------------------------");
        }
    }

    public void userStoryControllerJDBC(){
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < consultNominationJDBC().size(); i++){
            System.out.println("ID: "+consultNominationJDBC().get(i).getId());
            System.out.println("Year: "+consultNominationJDBC().get(i).getYear());
            System.out.println("Obtained Shares: "+consultNominationJDBC().get(i).getObtainedShares());
            System.out.println("Nominated Work: "+consultNominationJDBC().get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
            System.out.println("---Awards---");
            for(int j = 0 ; j < consultNominationJDBC().get(i).getAwards().size(); j++)
                System.out.println(consultNominationJDBC().get(i).getAwards().get(j).getName());
            System.out.println("---------------------------------------------");
        }

    }
}
