package oscar.awardService.view;

import oscar.awardService.control.SeeNomination;
import oscar.awardService.data.NominationRepository;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.NominationDAO_DB_JDBC;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The NominationUI class provides a user interface for interacting with nominations.
 * It allows users to view a list of nominations and perform different actions related to nominations.
 */
public class NominationUI {

    Scanner sc = new Scanner(System.in);
    SeeNomination overWatch = new SeeNomination();

    /**
     * Starts the nomination user interface.
     * It prompts the user to choose between different options such as viewing the list of nominations
     * or executing user story 3.
     */
    public void startNominationUI() {

        System.out.println("Please type in a number between 1, 2 or 3 to navigate in the option below");
        System.out.println("option 1 : show the nomination list");
        System.out.println("option 2 : UserStory");
        System.out.println("option 3 : next step");

        do{
            try{
                int awnser = sc.nextInt();
                if(awnser==1){
                    showAllNomination();
                    break;
                } else if (awnser==2) {
                    overWatch.userStoryController();
                    overWatch.userStoryControllerJDBC();
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

    /**
     * Displays the list of all nominations.
     */
    public void showAllNomination(){

        // Getting all nominations
        List<Nomination> allNominations = NominationRepository.getInstance().getAllNominations();
        System.out.println("All Nominations :");
        System.out.println("---------------------------------------------");

        for(int i = 0 ; i < allNominations.size(); i++) {
            System.out.println("nomination: "+ i);
            System.out.println("Year: "+allNominations.get(i).getYear());
            System.out.println("Nominated Work: "+allNominations.get(i).getNominatedWork());
            System.out.println("Obtained Shares: "+allNominations.get(i).getObtainedShares());
            System.out.println("---------------------------------------------");
        }
    }

    public void showAllNominationJDBC(){
        NominationDAO_DB_JDBC daoDb = new NominationDAO_DB_JDBC();
        List<Nomination> allNominations =  daoDb.findAllNomination();
        System.out.println("All Nominations :");
        System.out.println("---------------------------------------------");
        for(int i = 0 ; i < allNominations.size(); i ++){
            System.out.println("Id; "+ allNominations.get(i).getId());
            System.out.println("Year; "+ allNominations.get(i).getYear());
            System.out.println("Obtained Shares; "+ allNominations.get(i).getObtainedShares());
            System.out.println("Nominated Work; "+ allNominations.get(i).getNominatedWork());
            System.out.println("---------------------------------------------");
        }
    }
}
