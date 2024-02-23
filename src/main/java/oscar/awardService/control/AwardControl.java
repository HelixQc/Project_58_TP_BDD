package oscar.awardService.control;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO;
import oscar.awardService.persistence.NominationDAO;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implement UserStory
 * As a studio executive,
 * I want to nominate a
 * film for an awards category,
 * so that it can be considered
 * for an Oscar.
 */
public class AwardControl {

    Scanner sc = new Scanner(System.in);
    NominationUI nui = new NominationUI();
    AwardUI aui = new AwardUI();
    AwardDAO awardDAO = new AwardDAO();
    NominationDAO nominationDAO = new NominationDAO();
    Nomination n ;
    Award a;
    String awardAwnser;
    int answer;

    public void chooseTheAwardAndNomination(){

        //Nomination
        System.out.println("Choose a nomination id from the list: ");
        nui.showAllNomination();
        do {
        try {
                System.out.print("Enter the nomination id: ");
                answer = sc.nextInt();
                n = nominationDAO.findNominationById(answer);
                if (n == null) {
                    System.out.println("Invalid nomination id. Please try again.");
                }

        } catch (Exception e) {
            System.out.println("Error. Enter a number.");
            sc.next();
        }
    } while (n == null);

        //Awards
        System.out.println("Choose an Award category from the list: ");
        aui.showTheAwardList();
        this.awardAwnser = sc.next();
        this.a = awardDAO.findAwardByName(awardAwnser);

        // Check if the award was found before proceeding
        if (a != null ) {
            System.out.println(nominate(a, n));
        } else {
            System.out.println("Award not found.");
        }
    }

    public String nominate(Award a, Nomination n){
        return "The Nominated word is  " + n.getNominatedWork()+ " it have been nominated in the Award category " + a.getName();
    }
}
