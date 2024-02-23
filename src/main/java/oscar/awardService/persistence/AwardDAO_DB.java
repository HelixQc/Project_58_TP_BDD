package oscar.awardService.persistence;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Implements
 * CRUD
 * */
public class AwardDAO_DB extends AwardServiceDAO implements IAwardDAO {

    @Override
    public Award findAwardByName(String name) {
        try {

            PreparedStatement ps = this.connection.prepareStatement(QueryBox.FindAwardByName + "?");
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Award a = new Award(name);
                return a;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public void createAward(String award) {

    }

    @Override
    public void deleteAward(Award award) {

    }

    @Override
    public Award UpdateAward(Award award) {
        return null;
    }

    @Override
    public List<Award> findAllAward() {
        List<Award> awards = new ArrayList<>();
        try {
            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindAllAwards);

            while (result.next()) {
                String name = result.getString("name");
                Award a = new Award(name);
                awards.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return awards;
    }
}

