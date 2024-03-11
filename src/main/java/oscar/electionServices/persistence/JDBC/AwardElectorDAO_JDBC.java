package oscar.electionServices.persistence.JDBC;

import oscar.electionServices.model.AwardElector;
import oscar.electionServices.persistence.ElectionConnectionDAO;
import oscar.electionServices.persistence.IAwardElector;
import oscar.electionServices.persistence.QueryBox;

import javax.swing.event.ListDataEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AwardElectorDAO_JDBC extends ElectionConnectionDAO implements IAwardElector {
    @Override
    public void createAwardElector(AwardElector ae) {
        try{
            PreparedStatement ps = this.connection.prepareStatement(QueryBox.CreateAwardElector);
        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }

    }

    @Override
    public void deleteAwardElector(AwardElector ae) {

    }

    @Override
    public void UpdateAwardElector(AwardElector ae) {

    }

    @Override
    public List<AwardElector> readAwardElector() {

        try{
            List<AwardElector> awardElectorsBridge = new ArrayList<>();

            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindAllAwardElector);

            while(result.next()){

                int award_id = result.getInt("award_id");
                int elector_id = result.getInt("elector_id");

                AwardElector ae = new AwardElector(award_id, elector_id);
                awardElectorsBridge.add(ae);

            }

            return awardElectorsBridge;

        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }
    }
}
