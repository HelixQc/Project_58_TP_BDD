package oscar.electionServices.control;

import oscar.awardService.control.NominationControl;
import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO_Memory;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;
import oscar.electionServices.data.AwardElectorRepository;
import oscar.electionServices.model.AwardElector;
import oscar.electionServices.model.Elector;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.ElectorDAO_Memory;
import oscar.electionServices.persistence.VoteDAO_Memory;

import java.util.ArrayList;
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
    private AwardUI aUI = new AwardUI();
    private ElectorController ec = new ElectorController();
    private ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
    private AwardDAO_Memory awardDAO = new AwardDAO_Memory();
    private NominationDAO_Memory nominationDAO = new NominationDAO_Memory();
    private VoteDAO_Memory voteDAOMemory = new VoteDAO_Memory();
    private Date today = new Date();



    //private List<Nomination> filmWinners = new ArrayList<>();
    private List<Vote> votes = voteDAOMemory.readVote();
    private List<AwardNomination> awardNominationsBridges = AwardNominationRepository.getInstance().getBridgeAwardNomination();
    private List<AwardElector> awardElectorBridge = AwardElectorRepository.getInstance().getBridgeAwardElector();

    public void createVote(){

        Elector me = ec.wichElector(electorDAOMemory.readElector());
        System.out.println("Choose the nomination by ID in the list below: ");
        this.nc.showAllNomination();
        int awnser = sc.nextInt();
        this.nominationDAO.findNominationById(awnser);
        sc.nextLine();

        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        this.aUI.showTheAwardList();
        String responce = sc.nextLine();
        this.awardDAO.findAwardByName(responce);
        //awardDAO.deleteAward(awardDAO.findAwardByName(responce));

        System.out.println("---------------------------------------------");


        this.votes.add(new Vote(me.getWeight(), today, me.getId(), nominationDAO.findNominationById(awnser).getId()));
        this.awardNominationsBridges.add(new AwardNomination( awardDAO.findAwardByName(responce).getId() ,nominationDAO.findNominationById(awnser).getId()));
        this.awardElectorBridge.add(new AwardElector( awardDAO.findAwardByName(responce).getId() ,me.getId()));
        System.out.println("The vote have been register with success");
    }



}
