package oscar.electionServices.data;


import oscar.electionServices.model.Elector;
import java.util.ArrayList;
import java.util.List;

/**
 * The ElectorRepository class manages a collection of electors.
 * It provides methods to interact with the electors data.
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

    /**
     * Returns the singleton instance of ElectorRepository.
     * If the instance is not yet created, it creates one.
     * @return The singleton instance of ElectorRepository
     */
    public static ElectorRepository getInstance(){
        if(instance == null){
            instance = new ElectorRepository();
        }
        return instance;
    }

    //Populate the singleton data
    private void populateElector() {
        Elector e1 = new Elector(1,100.0,"Aramis");
        electors.add(e1);
        Elector e2 = new Elector(2,280.0,"Athos");
        electors.add(e2);
        Elector e3 = new Elector(3,170.0,"D'Artagnan");
        electors.add(e3);
        Elector e4 = new Elector(4,60.0, "Portos");
        electors.add(e4);
    }


    //Getting the instance
    public List<Elector> getAllElectors(){return electors;}

}