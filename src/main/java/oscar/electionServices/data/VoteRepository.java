package oscar.electionServices.data;

import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.ElectorDAO_Memory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is a memory repository
 * using a singleton to get the instance
 * of the data
 * */
public class VoteRepository {

    private Date today = new Date();
    private ElectorDAO_Memory electorDAO = new ElectorDAO_Memory();

    //singleton
    private static VoteRepository instance = null;

    //Vote List
    private List<Vote> votes;

    //private Ctor
    private VoteRepository(){
        votes = new ArrayList<>();
        populateVotes();
    }

    //Getting the instance
    public static VoteRepository getInstance(){
        if(instance == null){
            instance = new VoteRepository();
        }
        return instance;
    }

    //Creating votes
    private void populateVotes() {
        votes.add(new Vote(100,today,electorDAO.findElectorByWeight(100)));
        votes.add(new Vote(280,today,electorDAO.findElectorByWeight(280)));
        votes.add(new Vote(170,today,electorDAO.findElectorByWeight(170)));
        votes.add(new Vote(60,today,electorDAO.findElectorByWeight(60)));
    }

    //Returning the vote list
    public List<Vote> getAllVote(){
        return votes;
    }
}
