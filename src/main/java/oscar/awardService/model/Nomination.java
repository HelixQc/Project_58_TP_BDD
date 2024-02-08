package oscar.awardService.model;
import oscar.electionServices.model.Vote;
import java.util.ArrayList;
import java.util.List;


/**
 *Documentation
 */
public class Nomination {
    private int year;
    private double obtainedShares;
    private String nominatedWork;
    private List<Vote> votes; // A list to hold multiple Vote objects
    private List<Award> awards;

    // Empty constructor
    public Nomination() {
    }

    // Constructor with parameters
    public Nomination(int year, double obtainedShares, String nominatedWork, List<Vote> votes) {
        this.year = year;
        this.obtainedShares = obtainedShares;
        this.nominatedWork = nominatedWork;
        this.votes = new ArrayList<>();
        this.awards = new ArrayList<>();
    }

    // Getters and setters for all fields

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getObtainedShares() {
        return obtainedShares;
    }

    public void setObtainedShares(double obtainedShares) {
        this.obtainedShares = obtainedShares;
    }

    public String getNominatedWork() {
        return nominatedWork;
    }

    public void setNominatedWork(String nominatedWork) {
        this.nominatedWork = nominatedWork;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    // toString method using string interpolation
    @Override
    public String toString() {

        return String.format("Nomination{year=%d, obtainedShares=%s, nominatedWork='%s', votes=%s, awards=%s}",
                year, obtainedShares, nominatedWork, votes, awards);

    }
}


