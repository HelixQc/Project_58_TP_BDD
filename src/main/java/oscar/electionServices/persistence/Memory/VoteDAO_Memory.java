package oscar.electionServices.persistence.Memory;

import oscar.electionServices.data.VoteRepository;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.IVoteDAO;

import java.util.List;

public class VoteDAO_Memory implements IVoteDAO {
    VoteRepository memory = VoteRepository.getInstance();

    @Override
    public Vote findVoteById(int id) {
        return null;
    }

    @Override
    public void createVote(Vote v) {

    }

    @Override
    public void deleteVote(Vote v) {

    }

    @Override
    public List<Vote> readVote() {
        return memory.getAllVote();
    }

    @Override
    public void updateVote(Vote e) {

    }
}
