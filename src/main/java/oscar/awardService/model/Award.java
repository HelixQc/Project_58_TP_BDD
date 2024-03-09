package oscar.awardService.model;


import java.util.ArrayList;
import java.util.List;

/**
 * The Award class represents an award category.
 * It contains information about the name of the award and can optionally
 * hold a list of sub-awards if the award is hierarchical.
 */
public class Award {

    private int id;
    private String name;
    private List<Award> awards;

    /**
     * Constructor to initialize an Award object with the specified name.
     * @param name The name of the award
     */
    public Award(int id, String name) {
        this.id = id;
        this.name = name;
        this.awards = new ArrayList<>();
    }

    // Empty constructor
    public Award() {}

    // Getters for all fields
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Award> getAwards() {
        return awards;
    }

    // Setters for all fields
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    /**
     * Generates a string representation of the Award object.
     * @return A string containing the name of the award.
     */
    @Override
    public String toString() {
        return String.format("Award name = %s \n", name);
    }
}

