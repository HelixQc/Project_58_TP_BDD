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
    private Award award;

    // Empty constructor
    public Nomination() {}

    // Constructor with parameters
    public Nomination(int id ,int year, double obtainedShares, String nominatedWork, List<Vote> votes, Award award) {
        this.id = id;
        this.year = year;
        this.obtainedShares = obtainedShares;
        this.nominatedWork = nominatedWork;
        this.votes = new ArrayList<>();
        this.award = award;
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
    public Award getAwards() {
        return award;
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
    public void setAwards(Award awards) {
        this.award = award;
    }
    public void setId(int id) {
        this.id = id;
    }


    // toString method using string interpolation
    @Override
    public String toString() {
        return String.format("Nomination year = %d, obtainedShares = %s, nominatedWork = '%s', votes = %s, awards = %s} \n",
                year, obtainedShares, nominatedWork, votes, award);

    }
}


