package oscar.awardService.model;


import jakarta.persistence.*;

/**
 * The Award class represents an award category.
 * It contains information about the name of the award and can optionally
 * hold a list of sub-awards if the award is hierarchical.
 */
@Entity
@Table(name="Award")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    /**
     * Constructor to initialize an Award object with the specified name.
     * @param name The name of the award
     */
    public Award(int id, String name) {
        this.id = id;
        this.name = name;

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


    // Setters for all fields
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
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

