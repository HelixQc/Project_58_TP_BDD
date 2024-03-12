package oscar.awardService.view;

import oscar.awardService.control.AwardControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AwardUI {

    Scanner sc = new Scanner(System.in);


    public void startTheAwardUI() {

        AwardControl awardController = new AwardControl();
        System.out.println("Please type in a number 1 or 2 to navigate in the option below");
        System.out.println("option 1 : Nominate a nominated work  ");
        System.out.println("option 2 : Next step ");


        do {
            try {

                int answer = sc.nextInt();

                if (answer == 1) {
                    try{

                        int awnser2 ;

                        System.out.println("Please type in a number between 1 and 3 to navigate in the option below");
                        System.out.println("Options 1: In Memory Repository ");
                        System.out.println("Options 2: JDBC ");
                        System.out.println("Options 3: JPA ");

                        awnser2 = sc.nextInt();

                        if(awnser2 == 1){
                            awardController.createNomination();

                        } else if (awnser2 == 2) {
                            awardController.createNominationJDBC();

                        } else if (awnser2 == 3) {
                            awardController.createNominationJPA();
                        }
                        break;
                    }catch (InputMismatchException ee){
                        System.out.println("Please enter a valid number");
                    }

                } else if(answer == 2){
                    break;
                }else{
                    System.out.println("Please enter either 1 or 2 ");
                    sc.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                sc.next();
            }
        } while (true);
    }

}
