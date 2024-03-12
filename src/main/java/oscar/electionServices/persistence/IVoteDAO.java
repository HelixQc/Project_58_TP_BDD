package oscar.electionServices.persistence;


import oscar.electionServices.model.Vote;

import java.util.List;

public interface IVoteDAO {
    Vote findVoteById(int id);

    void createVote(Vote v);
    void deleteVote(Vote v);
    List<Vote> readVote();
    void updateVote(Vote e);
}
