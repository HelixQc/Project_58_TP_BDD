package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The NominationDAO_DB class provides methods to interact with the database
 * for performing CRUD operations on Nomination objects.
 */
public class NominationDAO_DB extends AwardServiceDAO implements INominationDAO{


    AwardDAO_DB awardDAO_db = new AwardDAO_DB();
    List<Award> awards = awardDAO_db.findAllAward();

    /**
     * Finds a nomination by its ID.
     * @param id The ID of the nomination to find
     * @return The Nomination object if found, null otherwise
     */
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
                return new Nomination(id, year, ObtainedShared ,nominatedWork,new ArrayList<>(), awards);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    } // findNominationById

    /**
     * Creates a new nomination with the given name.
     * @param name The name of the nomination to create
     */
    @Override
    public void createNomination(String name) {

    }

    /**
     * Deletes a nomination from the database.
     * @param n The Nomination object to delete
     */
    @Override
    public void deleteNomination(Nomination n) {

    }

    /**
     * Finds all nominations stored in the database.
     * @return A list containing all nominations
     */
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
                Nomination nomination = new Nomination(id, year, obtainedShares, nominatedWork, new ArrayList<>(), awards);
                nominations.add(nomination);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nominations;
    }

    /**
     * Updates a nomination in the database.
     * @param n The Nomination object to update
     * @return The updated Nomination object
     */
    @Override
    public Nomination UpdateNomination(Nomination n) {
        return null;
    }
}

