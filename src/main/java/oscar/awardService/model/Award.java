package oscar.awardService.model;


import java.util.ArrayList;
import java.util.List;

/**
 *Documentation
 */

public class Award {

    private String name;
    private List<Award> awards;

    // Constructor with parameters
    public Award(String name) {
        this.name = name;
        this.awards = new ArrayList<>();
    }

    // Empty constructor
    public Award() {}

    // Getter
    public String getName() {
        return name;
    }
    public List<Award> getAwards() {
        return awards;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Award name = ' %s ' \n", name);
    }
}

