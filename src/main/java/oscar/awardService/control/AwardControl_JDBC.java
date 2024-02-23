package oscar.awardService.control;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO_DB;
import oscar.awardService.persistence.NominationDAO_DB;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;
import java.util.Scanner;

public class AwardControl_JDBC {

    Scanner sc = new Scanner(System.in);
    NominationUI nui = new NominationUI();
    AwardUI aui = new AwardUI();
    AwardDAO_DB awardDAO_db = new AwardDAO_DB();
    NominationDAO_DB nominationDAO_DB = new NominationDAO_DB();
    Nomination n ;
    Award a;
    String awardAwnser;
    int answer;

    public void chooseTheAwardAndNominationJDBC(){

        //Nomination
        System.out.println("Choose a nomination id from the list: ");
        nui.showAllNominationJDBC();
        do {
            try {
                System.out.print("Enter the nomination id: ");
                answer = sc.nextInt();
                sc.nextLine();
                n = nominationDAO_DB.findNominationById(answer);
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
        aui.showTheAwardListJDBC();

        this.awardAwnser = sc.nextLine();
        this.a = awardDAO_db.findAwardByName(awardAwnser);

        //Check if the award was found before proceeding
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
