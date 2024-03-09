package oscar.awardService.control;

import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardDAO_DB_JDBC;
import oscar.awardService.persistence.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AwardControl_JDBC {

    Scanner sc = new Scanner(System.in);
    NominationUI nui ;
    AwardUI aui = new AwardUI();
    AwardDAO_DB_JDBC awardDAO_db = new AwardDAO_DB_JDBC();
    NominationDAO_DB_JDBC nominationDAO_DB = new NominationDAO_DB_JDBC();
    Nomination n ;
    Award a;
    String awardAwnser;
    int today = 2023;
    int answer;


    public void createNominationJDBC(){
        System.out.println("Please enter the nomination work : ");
        String responce = sc.nextLine();

        System.out.println("Please enter the obtained shares: ");
        double shares = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose the award categories in the list below: ");
        aui.showTheAwardListJDBC();
        String yourAwnser = sc.nextLine();

        awardDAO_db.findAwardByName(yourAwnser);

        Nomination n = new Nomination(2, today,shares, responce, new ArrayList<>(),awardDAO_db.findAwardByName(yourAwnser));

        System.out.println(nominate(awardDAO_db.findAwardByName(yourAwnser), n ));

        nominationDAO_DB.createNomination(n);
    }

    public String nominate(Award a, Nomination n){
        return "The Nominated word is  " + n.getNominatedWork()+ " it have been nominated in the Award category " + a.getName();
    }
}
