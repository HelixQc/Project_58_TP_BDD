package oscar.electionServices.model;

import java.util.Date;

/**
 *This class is used to create Vote and stock it
 *in the database or in the memory repository
 */

public class Vote {

    private int id;
    private int shares;
    private Date execution;
    private int elector_id;
    private int nomination_id ;


    // Constructor with parameters
    public Vote(int shares, Date execution, int elector_id, int nomination_id) {
        this.shares = shares;
        this.execution = execution;
        this.elector_id = elector_id;
        this.nomination_id = nomination_id;
    }

    // Empty constructor
    public Vote() {
    }


    //***Getters***//
    public int getId(){return id;}
    public double getShares() {
        return shares;
    }
    public Date getExecution() {
        return execution;
    }
    public int getElector_id() {
        return elector_id;
    }
    public int getNomination_id() {
        return nomination_id;
    }

    //***Setters***//
    public void setId(int id){this.id = id;}
    public void setShares(int shares) {
        this.shares = shares;
    }
    public void setExecution(Date execution) {
        this.execution = execution;
    }
    public void setElector_id(int elector_id) {
        this.elector_id = elector_id;
    }
    public void setNomination_id(int nomination_id) {
        this.nomination_id = nomination_id;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "shares=" + shares +
                ", execution=" + execution ;
    }
}


