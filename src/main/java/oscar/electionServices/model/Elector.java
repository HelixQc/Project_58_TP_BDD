package oscar.electionServices.model;

import oscar.awardService.model.Award;
import java.util.ArrayList;
import java.util.List;

public class Elector {

    private int weight;
    private String name;
    private List<Award> awards;

    // constructor with parameters

    public Elector(int weight, String name, List<Award> awards) {
        this.weight = weight;
        this.name = name;
        this.awards = new ArrayList<>();
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
        return String.format("Elector {weight=%d, name='%s', awards=%s}", weight, name, awards);

    }
}

