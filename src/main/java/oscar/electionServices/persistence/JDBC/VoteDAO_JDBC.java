package oscar.electionServices.persistence.JDBC;


import oscar.awardService.persistence.ConnectionDAO;
import oscar.electionServices.persistence.QueryBox;
import oscar.electionServices.model.Vote;
import oscar.electionServices.persistence.IVoteDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteDAO_JDBC extends ConnectionDAO implements IVoteDAO {


    @Override
    public Vote findVoteById(int id) {
        return null;
    }

    @Override
    public void createVote(Vote v) {

        try{
            PreparedStatement ps = this.connection.prepareStatement(QueryBox.CreateVote);
            ps.setDouble(1, v.getShares());
            //Convert the java Date into a SQL date before sending it to the dataBase
            java.sql.Date executionDate = new java.sql.Date(v.getExecution().getTime());
            ps.setDate(2, executionDate);
            ps.setInt(3,v.getNomination_id());
            ps.setInt(4,v.getElector_id());

            ps.executeQuery();

            System.out.println("The vote have been added with success");

        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }
    }

    @Override
    public void deleteVote(Vote v) {

    }

    @Override
    public List<Vote> readVote() {

        List<Vote> votes = new ArrayList<>();

        try {

            Statement st = this.connection.createStatement();
            ResultSet result = st.executeQuery(QueryBox.FindAllVotes);

            while(result.next()){

                int voteid = result.getInt("id");
                int voteShares = result.getInt("shares");
                Date executionDate = result.getDate("execution");
                int nomination_id = result.getInt("nomination_id");
                int elector_id = result.getInt("elector_id");

                Vote v = new Vote(voteShares, executionDate , nomination_id,elector_id);
                votes.add(v);
            }

        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }

        return votes;
    }

    @Override
    public void updateVote(Vote e) {

    }
}
