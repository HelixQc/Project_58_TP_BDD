package oscar.electionServices.model;

import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import java.util.ArrayList;
import java.util.List;

/**
 *The Elector got the role to vote for an award
 *Every elector got a different weight
 */

public class Elector {

    private int id;
    private int weight;
    private String name;
    private List<Award> awards = AwardRepository.getInstance().getAllAwards();
    private int awardElectorFk;

    public int getId() {
        return id;
    }

    public int getAwardElectorFk() {
        return awardElectorFk;
    }

    // constructor with parameters
    public Elector(int weight, String name, int awardElectorFk) {
        this.weight = weight;
        this.name = name;
        this.awardElectorFk = awardElectorFk;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    // Empty constructor
    public Elector() {
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Setter for weight
    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Elector {weight=%d, name='%s'}", weight, name);
    }
}

