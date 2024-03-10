package oscar.electionServices.data;

import oscar.electionServices.model.AwardElector;

import java.util.ArrayList;
import java.util.List;

/**
 * This Repository is to represent the bridge table in the DB
 */

public class AwardElectorRepository {

    //Singleton patters to return the repo
    private static AwardElectorRepository instance = null;

    //Data we need
    private List<AwardElector> bridgeAwardElector;

    //***PrivateConstructor***//
    private AwardElectorRepository(){
        bridgeAwardElector = new ArrayList<>();
        populateTheBridge();
    }

    private void populateTheBridge() {
        bridgeAwardElector.add(new AwardElector(1,1));
        bridgeAwardElector.add(new AwardElector(2,2));
        bridgeAwardElector.add(new AwardElector(3,1));
        bridgeAwardElector.add(new AwardElector(4,4));
        bridgeAwardElector.add(new AwardElector(5,2));
        bridgeAwardElector.add(new AwardElector(6,3));
    }

    //Returning the instance!!!
    public static AwardElectorRepository getInstance(){
        if(instance == null){
            instance = new AwardElectorRepository();
        }
        return instance;
    }

    //Getting the list of the instance!!
    public List<AwardElector> getBridgeAwardElector() {
        return bridgeAwardElector;
    }

}
