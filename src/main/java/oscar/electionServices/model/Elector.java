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







    // constructor with parameters
    public Elector(int id, int weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;

    }

    // Empty constructor
    public Elector() {
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    // Setter for weight
    public void setWeight(int weight) {
        this.weight = weight;
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

