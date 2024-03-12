package oscar.awardService.view;

import oscar.awardService.control.AwardControl;
import oscar.awardService.control.NominationControl;
import oscar.awardService.control.SeeNomination;
import oscar.awardService.model.Winner;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The NominationUI class provides a user interface for interacting with nominations.
 * It allows users to view a list of nominations and perform different actions related to nominations.
 */
public class NominationUI {

    Scanner sc = new Scanner(System.in);
    private NominationControl nc = new NominationControl();
    private AwardControl ac = new AwardControl();
    private SeeNomination v = new SeeNomination();
    private List<Winner> winnersMemory = v.VoteFilterMemory();
    private List<Winner> winnerJDBC = v.VoteFilterJDBC();
    private List<Winner> winnerJPA  = v.VoteFilterJPA();

    /**
     * Starts the nomination user interface.
     * It prompts the user to choose between different options such as viewing the list of nominations
     * or executing user story 3.
     */
    public void startNominationUI() {

        System.out.println("Please type in a number between 1, 2 or 3 to navigate in the option below");
        System.out.println("option 1 : Display the nomination list and the award list");
        System.out.println("option 2 : Display the winners");
        System.out.println("option 3 : End program");

        do{
            try{

                int awnser = sc.nextInt();
                if(awnser==1){

                    ///Ameliorer laffichage pour optimer cette methode
                    System.out.println("---------------------------------------------");
                    System.out.println("---Nominations---Memory---");
                    this.nc.showAllNomination();
                    System.out.println("---Awards---Memory---");

                    this.ac.showTheAwardListMemory();

                    System.out.println("---------------------------------------------");
                    System.out.println("---Nominations---JDBC---");
                    nc.showAllNominationJDBC();
                    System.out.println("---Awards---JDBC---");
                    ac.showTheAwardListJDBC();

                    sc.nextLine();
                    System.out.println("---------------------------------------------");

                    System.out.println("---------------------------------------------");
                    System.out.println("---Nominations---JPA---");
                    nc.showAllNominationJPA();
                    System.out.println("---Awards---JPA---");
                    ac.showTheAwardListJPA();
                    String awnser2;

                    //ameliorer la gestion des exception ici!!!
                    System.out.println("Do you want to see the winner? (Yes/No) ");
                    do{
                        awnser2 = sc.nextLine();
                        if(awnser2.equalsIgnoreCase("yes")){
                            displayWinner();
                            break;
                        }else if(awnser2.equalsIgnoreCase("no")){
                            break;
                        }else{
                            System.out.println("We need yes or no");
                        }
                    }while(true);
                    break;
                } else if (awnser==2) {
                    displayWinner();
                    break;
                } else if (awnser == 3) {
                    break;
                }else{
                    System.out.println("Please enter either 1, 2 or 3");
                }
            }catch (InputMismatchException em1){
                System.out.println("Please enter a proper number: ");
                sc.next();
            }
        }while(true);
    }


    public void displayWinner(){
        System.out.println("---------------------------------------------");
        System.out.println("---Winners---Memory---");
        v.printeWinners(this.winnersMemory);

        System.out.println("---------------------------------------------");
        System.out.println("---Winners---JDBC---");
        v.printeWinners(this.winnerJDBC);

        System.out.println("---------------------------------------------");
        System.out.println("---Winners---JPA---");
        v.printeWinners(this.winnerJPA);
    }

}
