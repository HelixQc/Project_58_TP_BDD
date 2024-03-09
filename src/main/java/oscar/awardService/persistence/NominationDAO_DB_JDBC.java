package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NominationDAO_DB_JDBC extends AwardDAO implements INominationDAO{


    AwardDAO_DB_JDBC awardDAO_db = new AwardDAO_DB_JDBC();
    List<Award> awards = awardDAO_db.findAllAward();
    int maxID = 0;

    @Override
    public Nomination findNominationById(int id) {
        try {
            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindNominationById + id);
            if(result.next()) {

                int year = result.getInt("year");
                int ObtainedShared = result.getInt("obtainedShares");
                String nominatedWork = result.getString("nominatedWork");
                int fk = result.getInt("awardFK");

                // objectify the loaded information => unmarshalling
                return new Nomination(id, year, ObtainedShared ,nominatedWork,new ArrayList<>(), awardDAO_db.findAwardByID(fk));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    } // findNominationById

    @Override
    public void createNomination(Nomination n) {

        try{
            PreparedStatement ps = this.connection.prepareStatement(QueryBox.CreateNomination);
            ps.setLong(1,MaxId());
            ps.setLong(2, n.getYear());
            ps.setDouble(3, n.getObtainedShares());
            ps.setString(4, n.getNominatedWork());
            ps.setInt(5, n.getAwards().getId());
            ps.executeUpdate();
            System.out.println("The nomination: "+ n.getNominatedWork() + " have been added with success");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                int fk = result.getInt("awardFK");

                // Create Nomination object and add it to the list
                Nomination nomination = new Nomination(id, year, obtainedShares, nominatedWork, new ArrayList<>(),awardDAO_db.findAwardByID(fk));
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


    public int MaxId(){
        NominationDAO_DB_JDBC myDAO_JDBC = new NominationDAO_DB_JDBC();
        for(int i = 0 ; i < myDAO_JDBC.findAllNomination().size();i++){
            if(this.maxID < myDAO_JDBC.findAllNomination().get(i).getId()){
                this.maxID = myDAO_JDBC.findAllNomination().get(i).getId();
            }
        }
        return maxID+1;
    }
}



