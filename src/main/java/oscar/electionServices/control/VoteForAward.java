package oscar.electionServices.control;

import oscar.awardService.model.Nomination;
import oscar.awardService.model.Winners;
import oscar.awardService.persistence.AwardDAO_Memory;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.ElectorDAO_Memory;

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

    private ElectorDAO_Memory electorDAO = new ElectorDAO_Memory();
    private AwardDAO_Memory awardDAO = new AwardDAO_Memory();
    private NominationDAO_Memory nominationDAO = new NominationDAO_Memory();
    private Date today = new Date();
    private List<Nomination> filmWinners = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void addVote(){
       for(int i = 0 ; i < electorDAO.readElector().size() ; i++){
           createWinner();
       }
    }

    public void createWinner(){

        NominationUI nUI = new NominationUI();
        AwardUI aUI = new AwardUI();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the nomination by ID in the list below: ");
        nUI.showAllNomination();
        int awnser = sc.nextInt();
        nominationDAO.findNominationById(awnser);
        sc.nextLine();

        System.out.println("---------------------------------------------");

        System.out.println("Select the award you want to vote for: ");
        aUI.showTheAwardList();
        String responce = sc.nextLine();
        awardDAO.findAwardByName(responce);
        //awardDAO.deleteAward(awardDAO.findAwardByName(responce));

        System.out.println("---------------------------------------------");

        System.out.println("Choose which elector you are in the list below: ");
        for(int i = 0 ; i < electorDAO.readElector().size(); i++){
            System.out.println("Name: "+electorDAO.readElector().get(i).getName());
            System.out.println("Vote Weight: "+electorDAO.readElector().get(i).getWeight());
            System.out.println("---------------------------------------------");
        }

        System.out.println("Add your vote shares: ");
        int shares = sc.nextInt();
        electorDAO.findElectorByWeight(shares);
        System.out.println("---------------------------------------------");

        this.filmWinners.add(nominationDAO.findNominationById(awnser));
        this.votes.add(new Vote(shares, today, electorDAO.findElectorByWeight(shares)));

        Winners w = new Winners(awardDAO.findAwardByName(responce),this.filmWinners, this.votes);

        System.out.println(w.getAward());
        System.out.println(w.getNomination().get(0).getNominatedWork());
        System.out.println(electorDAO.readElector());

    }
}
