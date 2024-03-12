package oscar.electionServices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *The Elector got the role to vote for an award
 *Every elector got a different weight
 */
@Entity
@Table(name = "Elector")
public class Elector {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "weight")
    private int weight;
    @Column(name = "name")
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
    public int getWeight() {
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

