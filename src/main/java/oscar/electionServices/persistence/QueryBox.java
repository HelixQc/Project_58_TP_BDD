package oscar.electionServices.persistence;

public class QueryBox {

    //***Elector***//
    public static String FindAllElectors =
            "Select *" +
            "From Elector";

    public static String FindElectorByWeight =
            "SELECT *" +
                    "FROM Elector " +
                    "WHERE weight =";

    public static String CreateElector =
            "INSERT INTO Elector(weight,name) " +
                    "VALUE(?,?)";

    //***Vote***//
    public static String FindAllVotes =
            "SELECT *" +
                    "FROM Vote";

    public static String CreateVote =
            "INSERT INTO Vote(shares, execution, nomination_id, elector_id) " +
                    "VALUE(?,?,?,?)";

    //***AwardElector***//
    public static String FindAllAwardElector =
            "SELECT *" +
                    "FROM AwardElector";

    public static String CreateAwardElector =
            "INSERT INTO AwardElector(award_id,elector_id) " +
                    "VALUE(?,?)";


}
