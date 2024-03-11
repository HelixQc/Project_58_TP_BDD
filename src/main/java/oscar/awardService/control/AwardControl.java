package oscar.awardService.control;

import oscar.awardService.data.AwardRepository;
import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.JDBC.AwardDAO_DB_JDBC;
import oscar.awardService.persistence.Memory.AwardDAO_Memory;
import oscar.awardService.persistence.Memory.NominationDAO_Memory;
import oscar.awardService.persistence.JDBC.NominationDAO_DB_JDBC;
import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        showTheAwardList();
        String yourAwnser = sc.nextLine();

        awardDAO.findAwardByName(yourAwnser);

        Nomination n = new Nomination(3, today.getYear(),shares, responce, new ArrayList<>(),new ArrayList<>());

        System.out.println(nominate(awardDAO.findAwardByName(yourAwnser), n ));
    }

    public String nominate(Award a, Nomination n){
        return "The Nominated word is  " + n.getNominatedWork()+ " it have been nominated in the Award category " + a.getName();
    }

    public void showTheAwardList() {

        //Getting award repo
        List<Award> awards = AwardRepository.getInstance().getAllAwards();

        //Print the Data
        for (int i = 0; i < AwardRepository.getInstance().getAllAwards().size(); i++) {
            System.out.println(awards.get(i).getName());
        }

    }



}
