package oscar.electionServices.model;

public class AwardElector {

    private int award_id;
    private int elector_id;

    //***Getters***//
    public int getAward_id() {
        return award_id;
    }
    public int getElector_id() {
        return elector_id;
    }

    //***Setters***//
    public void setAward_id(int award_id) {
        this.award_id = award_id;
    }
    public void setElector_id(int elector_id) {
        this.elector_id = elector_id;
    }

    //***Empty***//

    public AwardElector() {
    }

    //***Constructor***//
    public AwardElector(int award_id, int elector_id) {
        this.award_id = award_id;
        this.elector_id = elector_id;
    }

    //***ToString***//
    //To Reformat if you use it!!!!
    @Override
    public String toString() {
        return "AwardElector To Reformat if you use it!!!! {" +
                "award_id=" + award_id +
                ", elector_id=" + elector_id +
                '}';
    }
}
