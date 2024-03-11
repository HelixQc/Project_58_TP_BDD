package oscar.awardService.control;

import oscar.awardService.data.NominationRepository;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;

import java.util.List;

public class NominationControl {
    public void showAllNominationJDBC(){
        NominationDAO_DB_JDBC daoDb = new NominationDAO_DB_JDBC();
        List<Nomination> allNominations =  daoDb.findAllNomination();
        System.out.println("All Nominations :");
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < allNominations.size(); i ++){
            System.out.println("Id; "+ allNominations.get(i).getId());
            System.out.println("Year; "+ allNominations.get(i).getYear());
            System.out.println("Obtained Shares; "+ allNominations.get(i).getObtainedShares());
            System.out.println("Nominated Work; "+ allNominations.get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
        }
    }

    /**
     * Displays the list of all nominations.
     */
    public void showAllNomination(){

        // Getting all nominations
        List<Nomination> allNominations = NominationRepository.getInstance().getAllNominations();
        System.out.println("All Nominations :");
        System.out.println("---------------------------------------------");

        for(int i = 0 ; i < allNominations.size(); i++) {
            System.out.println("nomination: "+ i);
            System.out.println("Year: "+allNominations.get(i).getYear());
            System.out.println("Nominated Work: "+allNominations.get(i).getNominatedWork());
            System.out.println("Obtained Shares: "+allNominations.get(i).getObtainedShares());
            System.out.println("---------------------------------------------");
        }
    }
}
