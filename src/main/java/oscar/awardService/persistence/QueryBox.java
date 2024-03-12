package oscar.awardService.persistence;

/**
 * sql request
 */

public class QueryBox {
    public static String FindNominationById =
            "SELECT * "+
                    "FROM Nomination "+
                    "WHERE id = "
            ;
    public static String FindAllNomination =
            "SELECT *"+
                    " FROM Nomination";


    public static String FindAwardByName =
            "SELECT * " +
                    "FROM Award " +
                    "WHERE name = ?";

    public static String FindAllAwards =
            "SELECT * "+
                    " FROM Award ";

    public static String FindAwardById =
            "SELECT * "+
                    "FROM Award "+
                    "WHERE id = "
            ;
    public static String CreateNomination =
            "INSERT INTO Nomination( year, obtainedShares,nominatedWork) VALUES "+
            "(?,?,?)";

    public static String CreateAwardNomination =
            "INSERT INTO AwardNomination(award_id,nomination_id) " +
                    "VALUE(?,?)";
    public static String FindAllAwardNomination=
            "SELECT *" +
                    "FROM AwardNomination";
}
