package oscar.awardService.persistence.JDBC;

import oscar.awardService.model.AwardNomination;
import oscar.awardService.persistence.ConnectionDAO;
import oscar.awardService.persistence.IAwardNomination;
import oscar.awardService.persistence.QueryBox;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AwardNominationDAO_JDBC extends ConnectionDAO implements IAwardNomination {

    public AwardNominationDAO_JDBC(){
        super();
    }


    @Override
    public void createAwardNomination(AwardNomination an) {
        try{

            PreparedStatement ps = this.connection.prepareStatement(QueryBox.CreateAwardNomination);
            ps.setInt(1,an.getAward_id());
            ps.setInt(2,an.getNomination_id());
            ps.executeQuery();

            System.out.println("The bridge have been updated with success");
        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }
    }

    @Override
    public void deleteAwardNomination(AwardNomination an) {

    }

    @Override
    public void updateAwardNomination(AwardNomination an) {

    }

    @Override
    public List<AwardNomination> readAwardNomination() {
        try{
            List<AwardNomination> awardNominationsBridge = new ArrayList<>();

            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindAllAwardNomination);

            while(result.next()){

                int award_id = result.getInt("award_id");
                int nomination_id = result.getInt("nomination_id");

                AwardNomination an = new AwardNomination(award_id, nomination_id);
                awardNominationsBridge.add(an);

            }

            return awardNominationsBridge;

        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }
    }
}
