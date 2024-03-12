package oscar.awardService.model;

public class Winner {

    private Award award;
    private Nomination nominations;
    private double shares;


    //***Getters***//
    public Award getAward() {
        return award;
    }
    public Nomination getNominations() {
        return nominations;
    }
    public double getShares() {
        return shares;
    }

    //***Setters***//
    public void setAward(Award award) {
        this.award = award;
    }
    public void setNominations(Nomination nominations) {
        this.nominations = nominations;
    }
    public void setShares(double shares) {
        this.shares = shares;
    }


    //***Empty***//
    public Winner() {
    }

    //***Constructor***//
    public Winner(Award award, Nomination nominations, double shares) {
        this.award = award;
        this.nominations = nominations;
        this.shares = shares;
    }

    //***toString***//
    @Override
    public String toString() {
        return "Winner: ==>" +"\n"+
                "award: " + award.getName() +"\n"+
                "nomination: " + nominations.getNominatedWork() +"\n"+
                "share: "+shares;
    }
}
