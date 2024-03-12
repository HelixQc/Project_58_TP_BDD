package oscar.electionServices.model;

import jakarta.persistence.*;

/**
 *The Elector got the role to vote for an award
 *Every elector got a different weight
 */
@Entity
@Table(name = "Elector")
public class Elector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "name")
    private String name;

    // constructor with parameters
    public Elector(Integer id, Double weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;

    }

    // Empty constructor
    public Elector() {
    }

    // Getter for weight
    public Double getWeight() {
        return weight;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    // Setter for weight
    public void setWeight(Double weight) {
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

