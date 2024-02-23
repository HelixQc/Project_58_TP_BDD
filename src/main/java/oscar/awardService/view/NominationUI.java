package oscar.awardService.view;

import oscar.awardService.control.SeeNomination;
import oscar.awardService.data.NominationRepository;
import oscar.awardService.model.Nomination;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NominationUI {

    Scanner sc = new Scanner(System.in);
    public void startNominationUI() {
        System.out.println("Please type in a number between 1 and 3 to naviguate in the option below");
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
                    userStoryController();
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

    public void showAllNomination(){

        // Getting all nominations
        List<Nomination> allNominations = NominationRepository.getInstance().getAllNominations();
        System.out.println("All Nominations :");

        for(int i = 0 ; i < allNominations.size(); i++) {
            System.out.println("nomination: "+ i);
            System.out.println("Year: "+allNominations.get(i).getYear());
            System.out.println("Nominated Work: "+allNominations.get(i).getNominatedWork());
            System.out.println("Obtained Shares: "+allNominations.get(i).getObtainedShares());

            System.out.println("---------------------------------------------");
        }
    }


    public void userStoryController(){
        SeeNomination overWatch = new SeeNomination();
        System.out.println("The user story have not been implimented yet");
    }
}
