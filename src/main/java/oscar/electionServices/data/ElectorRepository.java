package oscar.electionServices.data;


import oscar.electionServices.model.Elector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ElectorRepository {

    //Singleton
    private static ElectorRepository instance = null;

    //List Elector
    private List<Elector> electors;

    //private constructor
    private  ElectorRepository(){
        electors = new ArrayList<>();
        populateElector();
    }
    //Creating the instance
    public static ElectorRepository getInstance(){
        if(instance == null){
            instance = new ElectorRepository();
        }
        return instance;
    }

    //Initiate the singleton data
    private void populateElector() {
        Elector e1 = new Elector(100,"Aramis");
        electors.add(e1);
        Elector e2 = new Elector(200,"Athos");
        electors.add(e2);
        Elector e3 = new Elector(300,"D'Artagnan");
        electors.add(e3);
        Elector e4 = new Elector(400, "Portos");
        electors.add(e4);
    }


    //Getting the instance
    public List<Elector> getAllElectors(){return electors;}

}