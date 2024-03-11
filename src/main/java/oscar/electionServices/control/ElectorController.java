package oscar.electionServices.control;

import oscar.electionServices.model.Elector;
import oscar.electionServices.persistence.ElectorDAO_Memory;

import java.util.List;
import java.util.Scanner;

public class ElectorController {

    private ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
    private Scanner sc = new Scanner(System.in);

    public Elector wichElector(List<Elector> electors){
        String yesOrNo;
        System.out.println("Are you a elector from the list below? ");
        for(Elector elector : electors){
            System.out.println("ID: "+elector.getId());
            System.out.println("Shares Weight: "+elector.getWeight());
            System.out.println("Name: "+elector.getName());
            System.out.println("---------------------------------------------");
        }

        yesOrNo = sc.nextLine();



        if(yesOrNo.equalsIgnoreCase("yes") ){
            System.out.println("Please enter your share weight: ");
            int weight = sc.nextInt();

            return electorDAOMemory.findElectorByWeight(weight);
        }else if(yesOrNo.equalsIgnoreCase("no")){
            createNewElector();
            return createNewElector();
        }else{
            System.out.println("the elector you choose is not in my database please reselect your elector: ");
            int weight = sc.nextInt();

            return electorDAOMemory.findElectorByWeight(weight);
        }

    }


    private Elector createNewElector() {

        int maxID = 0;
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your shares weight: ");
        int share = sc.nextInt();
        for(Elector elector : electorDAOMemory.readElector()){

            if(maxID < elector.getId()){
                maxID = elector.getId();
            }
        }
        Elector me = new Elector(maxID+1,share,name );
        return me;
    }
}
