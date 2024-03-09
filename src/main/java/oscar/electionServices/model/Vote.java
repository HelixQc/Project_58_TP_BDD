package oscar.electionServices.model;

import java.util.Date;

/**
 *This class is used to create Vote and stock it
 *in the database or in the memory repository
 */

public class Vote {

    private int shares;
    private Date execution;
    private Elector elector;

    // Constructor with parameters
    public Vote( int shares, Date execution, Elector elector) {

        this.shares = shares;
        this.execution = execution;
        this.elector = elector;
    }
    // Empty constructor
    public Vote() {
    }

    //***Getters***//
    public Elector getElector() {
        return elector;
    }
    public double getShares() {
        return shares;
    }
    public Date getExecution() {
        return execution;
    }

    //***Setters***//
    public void setElector(Elector elector) {
        this.elector = elector;
    }
    public void setShares(int shares) {
        this.shares = shares;
    }
    public void setExecution(Date execution) {
        this.execution = execution;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "shares=" + shares +
                ", execution=" + execution +
                ", elector=" + elector +
                '}';
    }
}


