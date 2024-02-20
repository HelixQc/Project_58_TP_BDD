package oscar.awardService.model;


/**
 *Documentation
 */

public class Award {

    private String name;

    // Constructor with parameters
    public Award(String name) {
        this.name = name;
    }

    // Empty constructor
    public Award() {
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
        return String.format("Award name = ' %s ' ", name);
    }
}

