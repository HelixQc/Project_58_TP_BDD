package oscar.electionServices.control;

import org.checkerframework.checker.units.qual.C;
import oscar.awardService.data.NominationRepository;
import oscar.awardService.data.WinnersRepository;
import oscar.awardService.model.Nomination;
import oscar.awardService.model.Winners;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.awardService.view.NominationUI;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.VoteDAO_Memory;

import java.util.ArrayList;
import java.util.List;

public class CalculateVote {

    private List<Winners> winnersList = WinnersRepository.getInstance().getAllWinnersList();
    private NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();
    private double maxShares = 0;
    private VoteDAO_Memory voteDAO = new VoteDAO_Memory();
    private List<Vote> testVoteList;

    public double calculateAllVoteMemory(){

        int i = 0;
        testVoteList = new ArrayList<>();
        for (Nomination nomination : nominationDAOMemory.findAllNomination()) {
            for (Winners winner : winnersList) {
                if (nomination.getAwards().equals(winner.getAward())
                        && voteDAO.readVote().get(i).getElector().getAwards().get(i).getName().equals(nomination.getAwards())) {
                    testVoteList.add(voteDAO.readVote().get(i));
                    maxShares += testVoteList.get(i).getShares();
                    nomination.setVotes(testVoteList);
                    i++;
                }
            }
        }
        System.out.println(maxShares);
      return maxShares;
    }

    public static void main(String[] args) {
        CalculateVote test = new CalculateVote();
        NominationDAO_Memory nominationDAOMemory = new NominationDAO_Memory();
        test.calculateAllVoteMemory();

        System.out.println(nominationDAOMemory.findAllNomination().get(0));
        System.out.println(nominationDAOMemory.findAllNomination().get(1));

    }
}
