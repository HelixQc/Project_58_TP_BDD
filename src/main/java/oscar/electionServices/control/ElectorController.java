package oscar.electionServices.control;


import oscar.electionServices.model.Elector;
import oscar.electionServices.persistence.JDBC.ElectorDAO_JDBC;
import oscar.electionServices.persistence.JPA.ElectorDAO_JPA;
import oscar.electionServices.persistence.Memory.ElectorDAO_Memory;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ElectorController {

    Scanner sc = new Scanner(System.in);


    public Elector whichElectorMemory(List<Elector> electors) {
        int weight;
        ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
        String yesOrNo;

        do{
            try{

                System.out.println("Are you a elector from the list below? ");
                showElectorListMemory();

                yesOrNo = sc.nextLine();


                if (yesOrNo.equalsIgnoreCase("yes")) {

                    System.out.println("Please enter your share weight: ");
                    weight = sc.nextInt();

                    while (electorDAOMemory.findElectorByWeight(weight) == null) {
                        if (electorDAOMemory.findElectorByWeight(weight) == null) {
                            System.out.println("the elector you choose is not in my database please reselect your elector: ");
                            weight = sc.nextInt();
                        }
                    }
                        return electorDAOMemory.findElectorByWeight(weight);


                } else if (yesOrNo.equalsIgnoreCase("no")) {

                    return createNewElectorMemory();

                }else{
                    System.out.println("Please enter Yes or No");

                    sc.nextLine();
                }

            }catch (InputMismatchException imp){
                System.out.println("Error of input please try again");
            }
        }while(true);
    }


    public Elector whichElectorJDBC(List<Elector> electors) {


        ElectorDAO_JDBC electorDAO_jdbc = new ElectorDAO_JDBC();
        int weight = 0;

        do{
            try{

        String yesOrNo;
        System.out.println("Are you a elector from the list below? (Yes/No) ");
        showElectorListJDBC();

        yesOrNo = sc.nextLine();


        if (yesOrNo.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your share weight: ");
            weight = sc.nextInt();

            while (electorDAO_jdbc.findElectorByWeight(weight) == null) {
                if (electorDAO_jdbc.findElectorByWeight(weight) == null) {
                    System.out.println("the elector you choose is not in my database please reselect your elector: ");
                    weight = sc.nextInt();
                }
            }

            return electorDAO_jdbc.findElectorByWeight(weight);


        } else if (yesOrNo.equalsIgnoreCase("no")) {

            return  createNewElectorJDBC();

        }else{
            System.out.println("Please enter Yes or No");
            sc.nextLine();
            return null;
        }

            }catch (InputMismatchException imp){
                System.out.println("Error of input please try again");
            }
        }while(true);
    }



    public Elector whichElectorJPA(List<Elector> electors) {

        ElectorDAO_JPA electorDAO_jpa = new ElectorDAO_JPA();
        int id = 0;
        String yesOrNo;
        do{
            try{
        System.out.println("Are you a elector from the list below? (Yes/No) ");
        showElectorListJPA();

        yesOrNo = sc.nextLine();


        if (yesOrNo.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your elector id: ");
            id = sc.nextInt();
            while (electorDAO_jpa.findElectorByWeight(id) == null) {
                if (electorDAO_jpa.findElectorByWeight(id) == null) {
                    System.out.println("the elector you choose is not in my database please reselect your elector: ");
                    id = sc.nextInt();
                }
            }
            return electorDAO_jpa.findElectorById(id);
        } else if (yesOrNo.equalsIgnoreCase("no")) {

            return createNewElectorJPA();

        }else{
            System.out.println("Please enter Yes or No");
            sc.nextLine();
        }
            }catch (InputMismatchException imp){
                System.out.println("Error of input please try again");
            }
        }while(true);
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

        ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
        int idOfNewElector = maxIdOfElector(electorDAOMemory.readElector());
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your shares weight: ");
        double share = sc.nextInt();

        return new Elector(idOfNewElector,share,name );

    }


    public Elector createNewElectorJDBC() {
        ElectorDAO_JDBC electorDAO_jdbc = new ElectorDAO_JDBC();
        int idOfNewElector = maxIdOfElector(electorDAO_jdbc.readElector());
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your shares weight: ");
        double share = sc.nextInt();

        Elector me = new Elector(idOfNewElector,share,name );
        electorDAO_jdbc.createElector(me);
        return me;
    }

    public Elector createNewElectorJPA(){

        ElectorDAO_JPA electorDAO_jpa = new ElectorDAO_JPA();
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your shares weight: ");
        double share = sc.nextInt();

        Elector me = new Elector(share,name);
        electorDAO_jpa.createElector(me);
        return me;
    }

    public void showElectorListMemory(){
        ElectorDAO_Memory electorDAOMemory = new ElectorDAO_Memory();
        System.out.println("--------------Elector--------------");
        for(Elector e : electorDAOMemory.readElector()){
            System.out.println("Elector name: "+e.getName());
            System.out.println("Elector share weight: "+e.getWeight());
            System.out.println("-----------------------------------");

        }
    }

    public void showElectorListJDBC() {
        ElectorDAO_JDBC electorDAO_jdbc = new ElectorDAO_JDBC();
        System.out.println("--------------Elector--------------");
        for(Elector e : electorDAO_jdbc.readElector()){
            System.out.println("Elector name: "+e.getName());
            System.out.println("Elector share weight: "+e.getWeight());
            System.out.println("-----------------------------------");

        }
    }

    public void showElectorListJPA() {
        ElectorDAO_JPA electorDAO_jpa = new ElectorDAO_JPA();
        System.out.println("--------------Elector--------------");
        for(Elector e : electorDAO_jpa.readElector()){
            System.out.println("Elector name: "+e.getName());
            System.out.println("Elector share weight: "+e.getWeight());
            System.out.println("-----------------------------------");
        }
    }

}
