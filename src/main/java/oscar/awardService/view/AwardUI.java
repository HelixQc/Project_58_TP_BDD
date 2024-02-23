package oscar.awardService.view;

import oscar.awardService.control.AwardControl;
import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AwardUI {

    Scanner sc = new Scanner(System.in);

    public void startTheAwardUI() {

        System.out.println("Please enter 1 the see the list of awards or 2 to nominate a movie or 3 to go too the next step ");

        do {
            try {
                int answer = sc.nextInt();
                if (answer == 1) {
                    showTheAwardList();
                    break;
                } else if (answer == 2) {
                    userStoryMethode();
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

    public void showTheAwardList() {

        //Getting award repo
        List<Award> awards = AwardRepository.getInstance().getAllAwards();

        //Print the Data
        for (int i = 0; i < AwardRepository.getInstance().getAllAwards().size(); i++) {
            System.out.println(awards.get(i).getName());
        }

    }

    public void userStoryMethode() {
        //Call the controler for the userStory
        AwardControl awardController = new AwardControl();
        awardController.chooseTheAwardAndNomination();
    }
}
