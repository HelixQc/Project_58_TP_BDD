package oscar.awardService.model;

public class AwardNomination {

    private int award_id;
    private int nomination_id;

    //***Getters***//
    public int getAward_id() {
        return award_id;
    }
    public int getNomination_id() {
        return nomination_id;
    }

    //***Setters***//
    public void setAward_id(int award_id) {
        this.award_id = award_id;
    }
    public void setNomination_id(int nomination_id) {
        this.nomination_id = nomination_id;
    }

    //***Empty***//
    public AwardNomination(){}

    //***Constructor***//
    public AwardNomination(int award_id, int nomination_id) {
        this.award_id = award_id;
        this.nomination_id = nomination_id;
    }

    @Override
    public String toString() {
        return "AwardNomintaion reformate if use{" +
                "award_id=" + award_id +
                ", nomination_id=" + nomination_id +
                '}';
    }
}
