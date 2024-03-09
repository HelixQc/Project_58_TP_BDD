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
            "INSERT INTO Nomination(id, year, obtainedShares,nominatedWork, awardFK) VALUES "+
            "(?,?,?,?,?)";
}
