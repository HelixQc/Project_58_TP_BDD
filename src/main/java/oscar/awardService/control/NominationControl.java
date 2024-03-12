package oscar.awardService.control;

import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.persistence.JPA.NominationDAO_JPA;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;

import java.util.List;

/**
 * Displays the list of all nominations.
 */

public class NominationControl {

    //Section InMemory
    public void showAllNomination(){
        NominationDAO_Memory daoMemory = new NominationDAO_Memory();
        List<Nomination> allNominationsInMemory = daoMemory.findAllNomination();
        System.out.println("All Nominations : InMemory");
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
        NominationDAO_DB_JDBC daoDb = new NominationDAO_DB_JDBC();
        List<Nomination> allNominationsJDBC =  daoDb.findAllNomination();
        System.out.println("All Nominations : JDBC");
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < allNominationsJDBC.size(); i ++){
            System.out.println("Id: "+ allNominationsJDBC.get(i).getId());
            System.out.println("Year: "+ allNominationsJDBC.get(i).getYear());
            System.out.println("Obtained Shares: "+ allNominationsJDBC.get(i).getObtainedShares());
            System.out.println("Nominated Work: "+ allNominationsJDBC.get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
        }
    }

    public void showAllNominationJPA() {
        NominationDAO_JPA daoJpa = new NominationDAO_JPA();
        List<Nomination> allNominationJPA = daoJpa.findAllNomination();
        System.out.println("All Nominations : JPA");
        System.out.println("---------------------------------------------");
        for(Nomination n : allNominationJPA){
            System.out.println("Id: "+ n.getId());
            System.out.println("Year: "+ n.getYear());
            System.out.println("Obtained Shares: "+ n.getObtainedShares());
            System.out.println("Nominated Work: "+ n.getNominatedWork());
            System.out.println("---------------------------------------------");
        }

    }
}
