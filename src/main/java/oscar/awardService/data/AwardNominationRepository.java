package oscar.awardService.data;



import oscar.awardService.model.AwardNomination;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to represente the bridge table in the DB
 * Will use a singleton pattern to return the data we need
 */
public class AwardNominationRepository {

    //***Singleton***//
    private static AwardNominationRepository instance = null;

    //Data
    List<AwardNomination> bridgeAwardNomination;

    //***PrivateConstructor***//
    private AwardNominationRepository(){
        bridgeAwardNomination = new ArrayList<>();
        populateBridgeAwardNomination();
    }

    public static AwardNominationRepository getInstance(){
        if(instance == null){
            instance = new AwardNominationRepository();
        }
        return instance;
    }

    private void populateBridgeAwardNomination() {
       bridgeAwardNomination.add(new AwardNomination(1,1));
       bridgeAwardNomination.add(new AwardNomination(1,2));
       bridgeAwardNomination.add(new AwardNomination(2,2));
       bridgeAwardNomination.add(new AwardNomination(3,1));
       bridgeAwardNomination.add(new AwardNomination(4,1));

    }

    public List<AwardNomination> getBridgeAwardNomination(){
        return bridgeAwardNomination;
    }
}
