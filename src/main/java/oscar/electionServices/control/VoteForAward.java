package oscar.electionServices.control;

import oscar.awardService.control.AwardControl;
import oscar.awardService.control.NominationControl;
import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.persistence.JDBC.AwardDAO_DB_JDBC;
import oscar.awardService.persistence.JDBC.AwardNominationDAO_JDBC;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.persistence.JPA.AwardDAO_JPA;
import oscar.awardService.persistence.JPA.NominationDAO_JPA;
import oscar.awardService.persistence.Memory.AwardDAO_Memory;
import oscar.awardService.persistence.Memory.AwardNominationDAO_Memory;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.awardService.view.AwardUI;
import oscar.electionServices.data.AwardElectorRepository;
import oscar.electionServices.model.AwardElector;
import oscar.electionServices.model.Elector;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.JDBC.AwardElectorDAO_JDBC;
import oscar.electionServices.persistence.JDBC.ElectorDAO_JDBC;
import oscar.electionServices.persistence.JDBC.VoteDAO_JDBC;
import oscar.electionServices.persistence.JPA.ElectorDAO_JPA;
import oscar.electionServices.persistence.JPA.VoteDAO_JPA;
import oscar.electionServices.persistence.Memory.AwardElectorDAO_Memory;
import oscar.electionServices.persistence.Memory.ElectorDAO_Memory;
import oscar.electionServices.persistence.Memory.VoteDAO_Memory;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Implement UserStory
 * As an Academy member,
 * I would like to vote
 * for different categories
 * to contribute to the
 * awards selection process.
 */
public class VoteForAward {

    private Scanner sc = new Scanner(System.in);

    private NominationControl nc = new NominationControl();
    private AwardControl ac = new AwardControl();
    private ElectorController ec = new ElectorController();
    private Date today = new Date();


/*
not need it for now!!!
    //InMemory Section
    private List<Vote> votes_Memory = voteDAOMemory.readVote();
    private List<AwardNomination> awardNominationsBridges_Memory = awardNominationDAOMemory.readAwardNomination();
    private List<AwardElector> awardElectorBridge_Memory = awardElectorDAOMemory.readAwardElector();

    //JDBC Section
    private List<Vote> votes_JDBC = voteDAO_jdbc.readVote();
    private List<AwardNomination> getAwardNominationsBridges_JDBC = awardNominationDAO_jdbc.readAwardNomination();
    private List<AwardElector> getAwardElectorBridge_JDBC = awardElectorDAO_jdbc.readAwardElector();
*/


    public void createVoteMemory(){
        ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
        AwardDAO_Memory awardDAOMemory = new AwardDAO_Memory();
        NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();
        VoteDAO_Memory voteDAOMemory = new VoteDAO_Memory();
        AwardNominationDAO_Memory awardNominationDAOMemory = new AwardNominationDAO_Memory();
        AwardElectorDAO_Memory awardElectorDAOMemory = new AwardElectorDAO_Memory();

        Elector me = ec.wichElectorMemory(electorDAOMemory.readElector());
        System.out.println("Choose the nomination by ID in the list below: ");
        this.nc.showAllNomination();
        int awnser = sc.nextInt();
        nominationDAOMemory.findNominationById(awnser);


        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        this.ac.showTheAwardListMemory();
        sc.nextLine();
        String responce = sc.nextLine();
        awardDAOMemory.findAwardByName(responce);

        System.out.println("---------------------------------------------");

        Vote voteTemp = new Vote(me.getWeight(), today, me.getId(), nominationDAOMemory.findNominationById(awnser).getId());
        AwardNomination anTemp = new AwardNomination( awardDAOMemory.findAwardByName(responce).getId() ,nominationDAOMemory.findNominationById(awnser).getId());
        AwardElector aeTemp = new AwardElector(awardDAOMemory.findAwardByName(responce).getId() ,me.getId());

        voteDAOMemory.createVote(voteTemp);
        awardNominationDAOMemory.createAwardNomination(anTemp);
        awardElectorDAOMemory.createAwardElector(aeTemp);

        System.out.println("The vote have been register with success");
    }

    public void createVoteJDBC(){

        ElectorDAO_JDBC electorDAO_jdbc = new ElectorDAO_JDBC();
        AwardDAO_DB_JDBC awardDAO_db_jdbc = new AwardDAO_DB_JDBC();
        NominationDAO_DB_JDBC nominationDAO_db_jdbc = new NominationDAO_DB_JDBC();
        VoteDAO_JDBC voteDAO_jdbc = new VoteDAO_JDBC();
        AwardNominationDAO_JDBC awardNominationDAO_jdbc = new AwardNominationDAO_JDBC();
        AwardElectorDAO_JDBC awardElectorDAO_jdbc = new AwardElectorDAO_JDBC();


        Elector me = ec.wichElectorJDBC(electorDAO_jdbc.readElector());
        System.out.println("Choose the nomination by ID in the list below: ");
        this.nc.showAllNomination();
        int awnser = sc.nextInt();
        nominationDAO_db_jdbc.findNominationById(awnser);
        sc.nextLine();

        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        this.ac.showTheAwardListJDBC();
        String responce = sc.nextLine();
        awardDAO_db_jdbc.findAwardByName(responce);

        System.out.println("---------------------------------------------");

        Vote voteTemp = new Vote(me.getWeight(), today, me.getId(), nominationDAO_db_jdbc.findNominationById(awnser).getId());
        AwardNomination anTemp = new AwardNomination(awardDAO_db_jdbc.findAwardByName(responce).getId() ,nominationDAO_db_jdbc.findNominationById(awnser).getId());
        AwardElector aeTemp = new AwardElector(awardDAO_db_jdbc.findAwardByName(responce).getId() ,me.getId());

        //Update program
        voteDAO_jdbc.readVote().add(voteTemp);
        awardNominationDAO_jdbc.readAwardNomination().add(anTemp);
        awardElectorDAO_jdbc.readAwardElector().add(aeTemp);

        //UpdateDataBase
        voteDAO_jdbc.createVote(voteTemp);
        awardNominationDAO_jdbc.createAwardNomination(anTemp);
        awardElectorDAO_jdbc.createAwardElector(aeTemp);

        System.out.println("The vote have been register with success");
    }

    //Testing needed one test have been done plz delete your test in the db after if it passes!!!
    public void createVoteJPA() {

        AwardElectorDAO_JDBC awardElectorDAO_jdbc = new AwardElectorDAO_JDBC();
        NominationDAO_JPA nominationDAO_jpa = new NominationDAO_JPA();
        AwardDAO_JPA awardDAO_jpa = new AwardDAO_JPA();
        ElectorDAO_JPA electorDAO_jpa = new ElectorDAO_JPA();
        VoteDAO_JPA voteDAO_jpa = new VoteDAO_JPA();

        Elector me = ec.wichElectorJPA(electorDAO_jpa.readElector());
        System.out.println("Choose the nomination by ID in the list below: ");
        this.nc.showAllNominationJPA();
        int awnser = sc.nextInt();
        nominationDAO_jpa.findNominationById(awnser);
        sc.nextLine();

        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        this.ac.showTheAwardListJDBC();
        String responce = sc.nextLine();
        awardDAO_jpa.findAwardByName(responce);

        System.out.println("---------------------------------------------");

        Vote voteTemp = new Vote(me.getWeight(), today, me.getId(), nominationDAO_jpa.findNominationById(awnser).getId());
        voteDAO_jpa.createVote(voteTemp);
        /*This is not supposed to be needed with JPA butt we made an error at the beginning, and we don't have time for a major update
       AwardNomination anTemp = new AwardNomination(awardDAO_jpa.findAwardByName(responce).getId() ,nominationDAO_jpa.findNominationById(awnser).getId());*/
        AwardElector aeTemp = new AwardElector(awardDAO_jpa.findAwardByName(responce).getId() ,me.getId());


        voteDAO_jpa.createVote(voteTemp);
        awardElectorDAO_jdbc.createAwardElector(aeTemp);
        System.out.println("The vote have been added with success");
    }

}
