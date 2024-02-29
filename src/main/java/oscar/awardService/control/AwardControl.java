package oscar.awardService.control;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO_Memory;
import oscar.awardService.persistence.NominationDAO_Memory;
import oscar.awardService.persistence.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;

import java.util.ArrayList;
import java.util.Date;
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
    AwardDAO_Memory awardDAO = new AwardDAO_Memory();
    NominationDAO_Memory nominationDAO = new NominationDAO_Memory();
    NominationDAO_DB_JDBC nominationDAO_DB = new NominationDAO_DB_JDBC();
    Nomination n ;
    Award a;
    String awardAwnser;
    int answer;
    Date today = new Date();


    public void createNomination(){

        System.out.println("Please enter the nomination work : ");
        String responce = sc.nextLine();

        System.out.println("Please enter the obtained shares: ");
        double shares = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose the award categories in the list below: ");
        aui.showTheAwardList();
        String yourAwnser = sc.nextLine();

        awardDAO.findAwardByName(yourAwnser);

        Nomination n = new Nomination(3, today.getYear(),shares, responce, new ArrayList<>(),awardDAO.findAwardByName(yourAwnser));

        System.out.println(nominate(awardDAO.findAwardByName(yourAwnser), n ));
    }

    public String nominate(Award a, Nomination n){
        return "The Nominated word is  " + n.getNominatedWork()+ " it have been nominated in the Award category " + a.getName();
    }
}
