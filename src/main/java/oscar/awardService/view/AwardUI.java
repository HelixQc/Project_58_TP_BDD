package oscar.awardService.view;

import oscar.awardService.control.AwardControl;
import oscar.awardService.control.AwardControl_JDBC;
import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.persistence.JDBC.AwardDAO_DB_JDBC;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AwardUI {

    Scanner sc = new Scanner(System.in);
    private AwardControl awardController = new AwardControl();

    //private AwardDAO_DB_JDBC awardDAODb_JDBC = new AwardDAO_DB_JDBC();

    public void startTheAwardUI() {

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
                            this.awardController.createNomination();

                        } else if (awnser2 == 2) {
                            this.awardController.createNominationJDBC();

                        } else if (awnser2 == 3) {
                            userStoryMethodeJPA();
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

    //JPA
    private void userStoryMethodeJPA() {
        System.out.println("not ready yet");
    }

}
