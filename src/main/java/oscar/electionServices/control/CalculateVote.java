package oscar.electionServices.control;


import oscar.awardService.data.AwardNominationRepository;
import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.model.AwardNomination;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.electionServices.data.AwardElectorRepository;
import oscar.electionServices.data.ElectorRepository;
import oscar.electionServices.model.AwardElector;
import oscar.electionServices.model.Elector;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.VoteDAO_Memory;

import java.util.List;

public class CalculateVote {


    private int i = 0;

    private VoteDAO_Memory voteDAO = new VoteDAO_Memory();
    private NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();

    private List<Vote> votes = voteDAO.readVote();
    private List<AwardNomination> bridgesAwardNomination = AwardNominationRepository.getInstance().getBridgeAwardNomination();
    private List<AwardElector> bridgesAwardElector = AwardElectorRepository.getInstance().getBridgeAwardElector();
    private List<Nomination> nominations = nominationDAOMemory.findAllNomination();
    private List<Award> awards = AwardRepository.getInstance().getAllAwards();
    private List<Elector> electors = ElectorRepository.getInstance().getAllElectors();

    public void test() {

        for (Award a : awards) {
            System.out.println();
            System.out.println(a.getName());

            for (Nomination n : nominations) {
                for (Vote vote : votes) {
                    for (AwardNomination an : bridgesAwardNomination) {
                        if (a.getId() == an.getAward_id()) {
                            for (AwardElector ae : bridgesAwardElector) {
                                if (ae.getAward_id() == a.getId()) {
                                    if (an.getNomination_id() == n.getId() && vote.getNomination_id() == an.getNomination_id()) {
                                        System.out.println(n);
                                        System.out.println(vote.getShares());
                                        System.out.println(vote);

                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(calculerMaxShare());
            }
        }
    }


    private double calculerMaxShare() {
        double myShares = 0;

        // On récupère le nominatedWork du premier élément de la liste des nominations (s'il existe)

        String nominatedWork = (nominations.size() > i) ? nominations.get(i).getNominatedWork() : "";

        for (Nomination nomination : nominations) {
            // On vérifie si le nominatedWork de la nomination correspond à celui récupéré précédemment
            if (nomination.getNominatedWork().equals(nominatedWork)) {
                for (Vote vote : nomination.getVotes()) {
                    // On ajoute les shares uniquement si les conditions sont remplies
                    if (nomination.getId() == vote.getNomination_id()) {
                        myShares += vote.getShares();
                    }
                }
                i++;
            }
        }
        return myShares;
    }

    public static void main(String[] args) {
        CalculateVote test = new CalculateVote();
        NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();
        //test.calculateAllVoteMemory();

        test.test();
        System.out.println(test.calculerMaxShare());
    }


     /* private double calculerMaxShare() {

        double myShares = 0;

        for (Nomination nomination : nominations) {
            for (Vote vote : nomination.getVotes()) {
                if (nomination.getNominatedWork() == nomination.getNominatedWork() && nomination.getId() == vote.getNomination_id() && bridgesAwardNomination.get(nomination.getId()-1).getNomination_id() == nomination.getId()) {
                    myShares += vote.getShares();

                }
            }
        }
        return myShares;
    }
*/


       /* public double calculateAllVoteMemory(){
        int i = 0;
        testVoteList = new ArrayList<>();
        for (Nomination nomination : nominationDAOMemory.findAllNomination()) {
            for (Winners winner : winnersList) {
                if (nomination.getAwards().equals(winner.getAward())) {
                    testVoteList.add(voteDAO.readVote().get(i));
                    maxShares += testVoteList.get(i).getShares();
                    nomination.setVotes(testVoteList);
                    i++;
                }
            }
        }
        System.out.println(maxShares);
        return maxShares;
    }*/

}
