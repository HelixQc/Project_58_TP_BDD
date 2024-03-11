package oscar.electionServices.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Here is the connection to the database.
 * the data is stored on alwaydata.com
 * every info will be in this DAO.
 * Use MariaDB when you start the connection.
 */

public abstract class ElectionConnectionDAO {
    //connection to Database is here!!!!
    protected static final String DB_HOST = "jdbc:mariadb://mysql-helixqc.alwaysdata.net:3306/";
    protected static final String DB_NAME ="helixqc_oscar";
    protected static final String DB_USER = "helixqc";
    protected static final String DB_PASSWORD = "Jujube98!";
    protected static final String DB_URL = DB_HOST + DB_NAME;
    protected Connection connection;

    public ElectionConnectionDAO(){
        try{
            this.connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
