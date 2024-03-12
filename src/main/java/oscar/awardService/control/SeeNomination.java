package oscar.awardService.control;

import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.model.Nomination;
import oscar.awardService.model.Winner;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;
import oscar.electionServices.model.Vote;

import java.util.ArrayList;
import java.util.List;

/**
 * As a film historian,
 * I want to see all nomination
 * categories and respective winners,
 * so I can look for trends and
 * statistics in film awards.
 */
public class SeeNomination {

    private NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();

    private List<AwardNomination> bridgesAwardNomination = AwardNominationRepository.getInstance().getBridgeAwardNomination();
    private List<Nomination> nominations = nominationDAOMemory.findAllNomination();
    private List<Award> awards = AwardRepository.getInstance().getAllAwards();
    private List<Winner> winners;


    public List<Winner> VoteFilterMemory() {

        double maxShare = 0 ;
        double totalShare = 0 ;
        Winner winnerTemp = new Winner();
        this.winners = new ArrayList<>();

        for (Award a : this.awards) {
            for (Nomination n : this.nominations) {
                for (AwardNomination an : this.bridgesAwardNomination) {
                    if (a.getId() == an.getAward_id()) {
                        if (an.getNomination_id() == n.getId()) {
                            totalShare = calculerShare(n);
                            if(maxShare < totalShare){
                                maxShare = totalShare;
                                winnerTemp = new Winner(a, n , totalShare);

                            }
                        }
                    }
                }
            }
            //List the winner
            this.winners.add(winnerTemp);
            maxShare = 0;
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
    public void printeWinners(List<Winner> winners) {

        List<Award> awardsEmpty = new ArrayList<>();

        for (Winner winner : winners) {
            if(!awardsEmpty.contains(winner.getAward())){
                awardsEmpty.add(winner.getAward());
                System.out.println(winner);
                System.out.println();
            }
        }
    }
}




