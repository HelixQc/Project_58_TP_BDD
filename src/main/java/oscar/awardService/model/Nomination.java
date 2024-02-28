package oscar.awardService.model;
import oscar.awardService.data.AwardRepository;
import oscar.electionServices.model.Vote;
import java.util.ArrayList;
import java.util.List;


/**
 * The Nomination class represents a nomination for an award in a particular year.
 * It contains information such as the year, obtained shares, nominated work,
 * associated votes, and the award for which the nomination is made.
 */
public class Nomination {
    private int id; // The unique identifier for the nomination
    private int year; // The year of the nomination
    private double obtainedShares; // The number of shares obtained by the nomination
    private String nominatedWork; // The work nominated for the award
    private List<Vote> votes; // A list to hold multiple Vote objects associated with this nomination
    private Award award; // The award for which the nomination is made

    // Empty constructor
    public Nomination() {}

    /**
     * Constructor to initialize a Nomination object with specified parameters.
     * @param id The unique identifier for the nomination
     * @param year The year of the nomination
     * @param obtainedShares The number of shares obtained by the nomination
     * @param nominatedWork The work nominated for the award
     * @param votes A list of votes associated with this nomination
     * @param award The award for which the nomination is made
     */
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


    /**
     * Generates a string representation of the Nomination object.
     * @return A string containing the year, obtained shares, nominated work,
     *         associated votes, and award of the nomination.
     */
    @Override
    public String toString() {
        return String.format("Nomination year = %d, obtainedShares = %s, nominatedWork = '%s', votes = %s, awards = %s} \n",
                year, obtainedShares, nominatedWork, votes, award);

    }
}


