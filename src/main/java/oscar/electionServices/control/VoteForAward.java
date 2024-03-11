package oscar.electionServices.control;

import oscar.awardService.control.AwardControl;
import oscar.awardService.control.NominationControl;
import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.persistence.Memory.AwardDAO_Memory;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.awardService.view.AwardUI;
import oscar.electionServices.data.AwardElectorRepository;
import oscar.electionServices.model.AwardElector;
import oscar.electionServices.model.Elector;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.JDBC.ElectorDAO_JDBC;
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
    private ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
    private ElectorDAO_JDBC electorDAO_jdbc = new ElectorDAO_JDBC();
    private AwardDAO_Memory awardDAO = new AwardDAO_Memory();
    private NominationDAO_Memory nominationDAO = new NominationDAO_Memory();
    private VoteDAO_Memory voteDAOMemory = new VoteDAO_Memory();
    private Date today = new Date();


    //InMemory Section
    private List<Vote> votes = voteDAOMemory.readVote();
    private List<AwardNomination> awardNominationsBridges = AwardNominationRepository.getInstance().getBridgeAwardNomination();
    private List<AwardElector> awardElectorBridge = AwardElectorRepository.getInstance().getBridgeAwardElector();


    public void createVoteMemory(){

        Elector me = ec.wichElectorMemory(electorDAOMemory.readElector());
        System.out.println("Choose the nomination by ID in the list below: ");
        this.nc.showAllNomination();
        int awnser = sc.nextInt();
        this.nominationDAO.findNominationById(awnser);
        sc.nextLine();

        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        this.ac.showTheAwardList();
        String responce = sc.nextLine();
        this.awardDAO.findAwardByName(responce);
        //awardDAO.deleteAward(awardDAO.findAwardByName(responce));

        System.out.println("---------------------------------------------");


        this.votes.add(new Vote(me.getWeight(), today, me.getId(), nominationDAO.findNominationById(awnser).getId()));
        this.awardNominationsBridges.add(new AwardNomination( awardDAO.findAwardByName(responce).getId() ,nominationDAO.findNominationById(awnser).getId()));
        this.awardElectorBridge.add(new AwardElector( awardDAO.findAwardByName(responce).getId() ,me.getId()));
        System.out.println("The vote have been register with success");
    }


    public void createVoteJDBC(){

        Elector me = ec.wichElectorMemory(electorDAO_jdbc.readElector());
        System.out.println("Choose the nomination by ID in the list below: ");
        this.nc.showAllNomination();
        int awnser = sc.nextInt();
        this.nominationDAO.findNominationById(awnser);
        sc.nextLine();

        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        this.ac.showTheAwardList();
        String responce = sc.nextLine();
        this.awardDAO.findAwardByName(responce);
        //awardDAO.deleteAward(awardDAO.findAwardByName(responce));

        System.out.println("---------------------------------------------");


        //this section need to be change for jdbc
        //this.votes.add(new Vote(me.getWeight(), today, me.getId(), nominationDAO.findNominationById(awnser).getId()));
        //this.awardNominationsBridges.add(new AwardNomination( awardDAO.findAwardByName(responce).getId() ,nominationDAO.findNominationById(awnser).getId()));
        //this.awardElectorBridge.add(new AwardElector( awardDAO.findAwardByName(responce).getId() ,me.getId()));
        System.out.println("The vote have been register with success");
    }



}
