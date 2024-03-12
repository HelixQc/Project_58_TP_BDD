package oscar.awardService.control;

import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.JDBC.AwardDAO_DB_JDBC;
import oscar.awardService.persistence.Memory.AwardDAO_Memory;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;
import oscar.electionServices.persistence.Memory.VoteDAO_Memory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Implement UserStory
 * As a studio executive,
 * I want to nominate a
 * film for an awards category,
 * so that it can be considered
 * for an Oscar.
 */
public class AwardControl {

    Scanner sc = new Scanner(System.in);
    AwardDAO_Memory awardDAOMemory = new AwardDAO_Memory();
    //NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();
    VoteDAO_Memory voteDAOMemory = new VoteDAO_Memory();
    NominationDAO_DB_JDBC nominationDAO_DB = new NominationDAO_DB_JDBC();
    AwardDAO_DB_JDBC awardDAO_db = new AwardDAO_DB_JDBC();

    Date today = new Date();


    public void createNomination(){

        System.out.println("Please enter the nomination work : ");
        String responce = sc.nextLine();

        System.out.println("Please enter the obtained shares: ");
        double shares = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose the award categories in the list below: ");
        showTheAwardListMemory();
        String yourAwnser = sc.nextLine();

        awardDAOMemory.findAwardByName(yourAwnser);

        Nomination n = new Nomination(3, today.getYear(),shares, responce, voteDAOMemory.readVote() ,awardDAOMemory.findAllAward());

        System.out.println(nominate(awardDAOMemory.findAwardByName(yourAwnser), n ));
    }


    public void createNominationJDBC(){

        System.out.println("Please enter the nomination work : ");
        String responce = sc.nextLine();

        System.out.println("Please enter the obtained shares: ");
        double shares = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose the award categories in the list below: ");
        showTheAwardListJDBC();
        String yourAwnser = sc.nextLine();

        awardDAO_db.findAwardByName(yourAwnser);

        Nomination n = new Nomination(2, today.getYear(),shares, responce, new ArrayList<>(),new ArrayList<>());

        System.out.println(nominate(awardDAO_db.findAwardByName(yourAwnser), n ));

        nominationDAO_DB.createNomination(n);
    }

    public void showTheAwardListMemory() {

        //Getting award data
        List<Award> awards = awardDAOMemory.findAllAward();

        //Print the Data
        for (int i = 0; i <  awards.size() ; i++) {
            System.out.println(awards.get(i).getName());
        }
    }

    public void showTheAwardListJDBC(){
        //Getting the data
        List<Award> awards = awardDAO_db.findAllAward();

        for(int i = 0 ; i < awards.size() ; i++ ){
            System.out.println("Awards categories: "+awards.get(i).getName());
        }
    }

    public String nominate(Award a, Nomination n){
        return "The Nominated word is  " + n.getNominatedWork()+ " it have been nominated in the Award category " + a.getName();
    }

}
