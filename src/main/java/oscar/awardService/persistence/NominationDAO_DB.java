package oscar.awardService.persistence;

import oscar.awardService.model.Nomination;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NominationDAO_DB extends AwardServiceDAO implements INominationDAO{


    @Override
    public Nomination findNominationById(int id) {
        try {
            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindNominationById + id);
            if(result.next()) {
                String movie = result.getString("");
                int year = result.getInt("");
                int ObtainedShared = result.getInt("");
                String nominatedWork = result.getString("");
                int fk =  result.getInt("");

                // objectify the loaded information => unmarshalling
                return new Nomination(id, movie, year, nominatedWork, new ArrayList<>());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    } // findNominationById

    @Override
    public void createNomination(String name) {

    }

    @Override
    public void deleteNomination(Nomination n) {

    }

    @Override
    public List<Nomination> findAllNomination() {
        return null;
    }

    @Override
    public Nomination UpdateNomination(Nomination n) {
        return null;
    }
}

