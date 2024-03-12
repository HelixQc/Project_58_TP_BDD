package oscar.electionServices.control;

import oscar.electionServices.model.Elector;
import oscar.electionServices.persistence.JDBC.ElectorDAO_JDBC;
import oscar.electionServices.persistence.Memory.ElectorDAO_Memory;

import java.util.List;
import java.util.Scanner;

public class ElectorController {

    private ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
    private ElectorDAO_JDBC electorDAO_jdbc = new ElectorDAO_JDBC();
    private Scanner sc = new Scanner(System.in);


    public Elector wichElectorMemory(List<Elector> electors) {

        ///Gestion d'exception!!!!
        String yesOrNo;
        System.out.println("Are you a elector from the list below? ");
        for (Elector elector : electors) {
            System.out.println("ID: " + elector.getId());
            System.out.println("Shares Weight: " + elector.getWeight());
            System.out.println("Name: " + elector.getName());
            System.out.println("---------------------------------------------");
        }

        yesOrNo = sc.nextLine();


        if (yesOrNo.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your share weight: ");
            int weight = sc.nextInt();

            return electorDAOMemory.findElectorByWeight(weight);
        } else if (yesOrNo.equalsIgnoreCase("no")) {

            createNewElectorMemory();
            return createNewElectorMemory();

        } else {
            System.out.println("the elector you choose is not in my database please reselect your elector: ");
            int weight = sc.nextInt();

            return electorDAOMemory.findElectorByWeight(weight);
        }
    }


    public Elector wichElectorJDBC(List<Elector> electors) {
        int weight = 0;
        ///Gestion d'exception!!!!
        String yesOrNo;
        System.out.println("Are you a elector from the list below? (Yes/No) ");
        for (Elector elector : electors) {
            System.out.println("ID: " + elector.getId());
            System.out.println("Shares Weight: " + elector.getWeight());
            System.out.println("Name: " + elector.getName());
            System.out.println("---------------------------------------------");
        }

        yesOrNo = sc.nextLine();


        if (yesOrNo.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your share weight: ");
            weight = sc.nextInt();

            return electorDAO_jdbc.findElectorByWeight(weight);
        } else if (yesOrNo.equalsIgnoreCase("no")) {

            createNewElectorJDBC();
            return createNewElectorJDBC();

        } else if (electorDAO_jdbc.findElectorByWeight(weight) == null) {
            System.out.println("the elector you choose is not in my database please reselect your elector: ");
            weight = sc.nextInt();

            return electorDAO_jdbc.findElectorByWeight(weight);
        }else{
            System.out.println("Please enter Yes or No");
            sc.nextLine();
            return null;
        }
    }


    public int maxIdOfElector(List<Elector> electors){
        int maxID = 0 ;
        for(Elector elector : electors){
            if(maxID < elector.getId()){
                maxID = elector.getId();
            }
        }
        return maxID + 1;
    }



    public Elector createNewElectorMemory() {
        int idOfNewElector = maxIdOfElector(electorDAOMemory.readElector());
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your shares weight: ");
        int share = sc.nextInt();

        Elector me = new Elector(idOfNewElector,share,name );
        return me;
    }




    public Elector createNewElectorJDBC() {
        int idOfNewElector = maxIdOfElector(electorDAO_jdbc.readElector());
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your shares weight: ");
        int share = sc.nextInt();

        Elector me = new Elector(idOfNewElector,share,name );
        return me;
        //Ajouter Elector creer a la database via une autre methode
    }











    public void showElectorListMemory(){
        System.out.println("--------------Elector--------------");
        for(Elector e : electorDAOMemory.readElector()){
            System.out.println("Elector name: "+e.getName());
            System.out.println("Elector share weight: "+e.getWeight());
            System.out.println("-----------------------------------");

        }
    }

    public void showElectorListJDBC() {

        System.out.println("--------------Elector--------------");
        for(Elector e : electorDAO_jdbc.readElector()){
            System.out.println("Elector name: "+e.getName());
            System.out.println("Elector share weight: "+e.getWeight());
            System.out.println("-----------------------------------");

        }
    }

    public void showElectorListJPA() {
    }
}
