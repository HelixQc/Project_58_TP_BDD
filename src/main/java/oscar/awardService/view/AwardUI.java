package oscar.awardService.view;

import oscar.awardService.control.AwardControl;
import oscar.awardService.control.AwardControl_JDBC;
import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.persistence.AwardDAO_DB;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * The AwardUI class provides a user interface for interacting with awards and nominations.
 * It allows users to view a list of awards and choose between different methods for nominating movies.
 */
public class AwardUI {

    Scanner sc = new Scanner(System.in);

    /**
     * Starts the award user interface.
     * It prompts the user to choose between different options such as viewing the list of awards
     * or nominating a movie using different methods by typing in numbers.
     */
    public void startTheAwardUI() {

        System.out.println("Please enter 1 the see the list of awards, 2 to nominate a movie or 3 go too the next step ");

        do {
            try {
                int answer = sc.nextInt();
                if (answer == 1) {
                    showTheAwardList();
                    break;
                } else if (answer == 2) {
                    int awnser2 ;

                    System.out.println("Please type in a number between 1 and 3 to navigate in the option below");
                    System.out.println("Options 1: In Memory Repository ");
                    System.out.println("Options 2: JDBC ");
                    System.out.println("Options 3: JPA ");

                    awnser2 = sc.nextInt();

                    if(awnser2 == 1){
                        userStoryMethode();
                    } else if (awnser2 == 2) {
                        userStoryMethodeJDBC();
                    } else if (awnser2 == 3) {
                        userStoryMethodeJPA();

                    }

                    break;
                } else if(answer == 3){
                    break;
                }else{
                    System.out.println("Please enter either 1, 2 or 3 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                // Clear the input buffer
                sc.next();
            }
        } while (true);
    }

    /**
     * Displays the list of awards.
     */
    public void showTheAwardList() {

        //Getting award repo
        List<Award> awards = AwardRepository.getInstance().getAllAwards();

        //Print the Data
        for (int i = 0; i < AwardRepository.getInstance().getAllAwards().size(); i++) {
            System.out.println(awards.get(i).getName());
        }

    }

    public void showTheAwardListJDBC(){
        //Getting the data
        AwardDAO_DB awardDAODb = new AwardDAO_DB();
        List<Award> awards = awardDAODb.findAllAward();

        for(int i = 0 ; i < awards.size() ; i++ ){
            System.out.println("Awards categories: "+awards.get(i).getName());
        }
    }

    /**
     * Executes the user story method using the in-memory repository.
     */
    public void userStoryMethode() {
        //Call the controler for the userStory
        AwardControl awardController = new AwardControl();
        awardController.chooseTheAwardAndNomination();
    }

    /**
     * Executes the user story method using JDBC.
     */
    private void userStoryMethodeJDBC() {
        AwardControl_JDBC jdbc = new AwardControl_JDBC();
        jdbc.chooseTheAwardAndNominationJDBC();
    }

    /**
     * Executes the user story method using JPA.
     */
    private void userStoryMethodeJPA() {
    }

}
