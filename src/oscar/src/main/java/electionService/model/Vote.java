package electionService.model;

import java.util.Date;

public class Vote {

    private int shares;
    private Date execution;
    private Elector elector;

    // Constructor with parameters
    public Vote(int shares, Date execution, Elector elector) {
        this.shares = shares;
        this.execution = execution;
        this.elector = elector;
    }
    // Empty constructor
    public Vote() {
    }

    public Elector getElector() {
        return elector;
    }

    public void setElector(Elector elector) {
        this.elector = elector;
    }

    // Getter for shares
    public double getShares() {
        return shares;
    }

    // Setter for shares
    public void setShares(int shares) {
        this.shares = shares;
    }

    // Getter for execution
    public Date getExecution() {
        return execution;
    }

    // Setter for execution
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


