package oscar.electionServices.control;


import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.model.Nomination;
import oscar.awardService.model.Winner;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.electionServices.model.Vote;

import java.util.ArrayList;
import java.util.List;

public class CalculateVote {

    private NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();

    private List<AwardNomination> bridgesAwardNomination = AwardNominationRepository.getInstance().getBridgeAwardNomination();
    private List<Nomination> nominations = nominationDAOMemory.findAllNomination();
    private List<Award> awards = AwardRepository.getInstance().getAllAwards();
    private List<Winner> winners;
    private List<Winner> realWinners = new ArrayList<>();


    public List<Winner> VoteFilter() {

        this.winners = new ArrayList<>();
        for (Award a : awards) {
            //System.out.println();
            //System.out.println(a.getName());
            for (Nomination n : nominations) {
                for (AwardNomination an : bridgesAwardNomination) {
                    if (a.getId() == an.getAward_id()) {
                        if (an.getNomination_id() == n.getId()) {
                            //System.out.println(n);
                            //System.out.println(calculerShare(n));


                                this.winners.add(new Winner(a, n, calculerShare(n)));

                        }
                    }
                }
            }
        }
        return this.winners;
    }

    public double calculerShare(Nomination nomination) {
        double myShares = 0;
        for (Vote vote : nomination.getVotes()) {
            if (nomination.getId() == vote.getNomination_id()) {
                myShares += vote.getShares();
            }
        }
        return myShares;
    }

  /*  public double calculerMaxShares(List<Winner>winners){
        double maxShare = 0 ;
        for(Winner winner : winners){
            if(winner.getShares() > maxShare){
                maxShare = winner.getShares();
            }
        }
        return maxShare;
    }


    public List<Winner> checkRealWinners() {
        double maxShare1 = 0;

        for (int i = 0; i < winners.size(); i++) {
            if (maxShare1 < winners.get(i).getShares()) {
                maxShare1 = winners.get(i).getShares();
            }
        }


        for (Winner winner : winners) {
            if (winner.getShares() == maxShare1) {
                System.out.println(winner);
                realWinners.add(winner);
            }
        }
        return realWinners;
    }


   public void filtrerWinners(){
        for(Nomination nomination : nominations){
            System.out.println(nomination.getNominatedWork());
            for(Winner winner : winners ){
                if(winner.getNominations() == nomination){
                    System.out.println(winner.getAward().getName());
                }
            }
            System.out.println();
        }
    }
*/
  public void printeWinners(List<Winner> winners) {

      for (Winner winner : winners) {
          System.out.println(winner);
          System.out.println();

      }
  }

   /* public static void main(String[] args) {
        CalculateVote test = new CalculateVote();

        test.VoteFilter();
        test.printeWinners(test.VoteFilter());
        //test.filtrerWinners();
    }*/
}
