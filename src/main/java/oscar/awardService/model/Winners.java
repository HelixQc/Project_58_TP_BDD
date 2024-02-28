package oscar.awardService.model;

import oscar.electionServices.model.Vote;
import java.util.List;

public class Winners {

    Award award;
    List<Nomination> nominations;
    List<Vote> votes;

    //***Getters***//
    public Award getAward() {
        return award;
    }
    public List<Nomination> getNomination() {
        return nominations;
    }
    public List<Vote> getVote() {
        return votes;
    }

    //***Setters***//
    public void setAward(Award award) {
        this.award = award;
    }
    public void setNomination(List<Nomination> nomination) {
        this.nominations = nomination;
    }
    public void setVote(List<Vote> vote) {
        this.votes = vote;
    }

    //***Empty***//
    public Winners() {
    }

    //***Constructor***//
    public Winners(Award award, List<Nomination> nominations, List<Vote> votes) {
        this.award = award;
        this.nominations = nominations;
        this.votes = votes;
    }

    //***toString***//
    @Override
    public String toString() {
        return "Winners{" +
                "award=" + award +
                ", nominations=" + nominations +
                ", votes=" + votes +
                '}';
    }
}
