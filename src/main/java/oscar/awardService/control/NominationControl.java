package oscar.awardService.control;


import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;

import java.util.List;

/**
 * Displays the list of all nominations.
 */

public class NominationControl {

    private NominationDAO_DB_JDBC daoDb = new NominationDAO_DB_JDBC();
    private NominationDAO_Memory daoMemory = new NominationDAO_Memory();
    private List<Nomination> allNominationsJDBC =  daoDb.findAllNomination();
    private List<Nomination> allNominationsInMemory = daoMemory.findAllNomination();


    //Section InMemory
    public void showAllNomination(){
        System.out.println("All Nominations :");
        System.out.println("---------------------------------------------");

        for(int i = 0 ; i < allNominationsInMemory.size(); i++) {
            System.out.println("nomination: "+ i);
            System.out.println("Year: "+allNominationsInMemory.get(i).getYear());
            System.out.println("Nominated Work: "+allNominationsInMemory.get(i).getNominatedWork());
            System.out.println("Obtained Shares: "+allNominationsInMemory.get(i).getObtainedShares());
            System.out.println("---------------------------------------------");
        }
    }


    //Section JDBC
    public void showAllNominationJDBC(){

        System.out.println("All Nominations :");
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < allNominationsJDBC.size(); i ++){
            System.out.println("Id; "+ allNominationsJDBC.get(i).getId());
            System.out.println("Year; "+ allNominationsJDBC.get(i).getYear());
            System.out.println("Obtained Shares; "+ allNominationsJDBC.get(i).getObtainedShares());
            System.out.println("Nominated Work; "+ allNominationsJDBC.get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
        }
    }


}
