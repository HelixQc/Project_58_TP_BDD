package oscar.awardService.model;
import oscar.awardService.data.AwardRepository;
import oscar.electionServices.model.Vote;
import java.util.ArrayList;
import java.util.List;


/**
 *Documentation
 */
public class Nomination {
    private int id ;
    private int year;
    private double obtainedShares;
    private String nominatedWork;
    private List<Vote> votes; // A list to hold multiple Vote objects
    private List<Award> awards;

    // Empty constructor
    public Nomination(int i,  int year, String nominatedWork, ArrayList<Vote> votes) {
    }

    // Constructor with parameters
    public Nomination(int id ,int year, double obtainedShares, String nominatedWork, List<Vote> votes) {
        this.id = id;
        this.year = year;
        this.obtainedShares = obtainedShares;
        this.nominatedWork = nominatedWork;
        this.votes = new ArrayList<>();
        this.awards = AwardRepository.getInstance().awards;
    }

    // Getters for all fields
    public int getYear() {
        return year;
    }
    public double getObtainedShares() {
        return obtainedShares;
    }
    public String getNominatedWork() {
        return nominatedWork;
    }
    public List<Vote> getVotes() {
        return votes;
    }
    public List<Award> getAwards() {
        return awards;
    }
    public int getId() {
        return id;
    }



    // Setters for all fields
    public void setYear(int year) {
        this.year = year;
    }
    public void setObtainedShares(double obtainedShares) {
        this.obtainedShares = obtainedShares;
    }
    public void setNominatedWork(String nominatedWork) {
        this.nominatedWork = nominatedWork;
    }
    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }
    public void setId(int id) {
        this.id = id;
    }


    // toString method using string interpolation
    @Override
    public String toString() {
        return String.format("Nomination year = %d, obtainedShares = %s, nominatedWork = '%s', votes = %s, awards = %s} \n",
                year, obtainedShares, nominatedWork, votes, awards);

    }
}


