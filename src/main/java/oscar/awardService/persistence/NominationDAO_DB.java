package oscar.awardService.persistence;

import oscar.awardService.model.Nomination;

import java.sql.PreparedStatement;
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

                int year = result.getInt("year");
                int ObtainedShared = result.getInt("obtainedShares");
                String nominatedWork = result.getString("nominatedWork");

                // objectify the loaded information => unmarshalling
                return new Nomination(id, year, ObtainedShared ,nominatedWork, new ArrayList<>());
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
        List<Nomination> nominations = new ArrayList<>();
        try {
            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindAllNomination);

            while (result.next()) {

                int id = result.getInt("id");
                int year = result.getInt("year");
                int obtainedShares = result.getInt("obtainedShares");
                String nominatedWork = result.getString("nominatedWork");

                // Create Nomination object and add it to the list
                Nomination nomination = new Nomination(id, year, obtainedShares, nominatedWork, new ArrayList<>());
                nominations.add(nomination);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nominations;
    }


    @Override
    public Nomination UpdateNomination(Nomination n) {
        return null;
    }
}

