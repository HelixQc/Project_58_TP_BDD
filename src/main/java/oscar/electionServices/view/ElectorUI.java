package oscar.electionServices.view;

import oscar.awardService.control.NominationControl;
import oscar.awardService.model.Nomination;
import oscar.awardService.view.NominationUI;
import oscar.electionServices.control.VoteForAward;
import oscar.electionServices.persistence.JDBC.ElectorDAO_JDBC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ElectorUI {

    private NominationControl nc = new NominationControl();
    private VoteForAward voteFor = new VoteForAward();


    Scanner sc = new Scanner(System.in);

    public void startElectorUI() {


            System.out.println("Please type in a number between 1, 2 or 3 to navigate in the option below");
            System.out.println("option 1 : show the nomination list");
            System.out.println("option 2 : vote");
            System.out.println("option 3 : next Step");

           do{
                try{
                int awnser = sc.nextInt();
                if(awnser == 1){
                    System.out.println("not ready");
                    break;
                }else if (awnser==2){
                    voteFor.createVoteMemory();
                    break;
                } else if (awnser == 3) {
                    break;
                }else {
                    System.out.println("PLease enter a number between 1 and 3");
                }
                }catch (InputMismatchException e){
                    System.out.println("Please enter a number: ");
                    sc.next();
                }
            }while(true);
    }

   /* public static void main(String[] args) {
        ElectorDAO_JDBC jdbc = new ElectorDAO_JDBC();

        System.out.println(jdbc.findElectorByWeight(200));

    }*/
}
