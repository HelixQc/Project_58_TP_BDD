/******************************************************---HELLO WORLD---*************************************************************/
/***************************************************---THE MUSKETEERS IS---**********************************************************/
/****************************************************---ABOUT TO PROGRAM---**********************************************************/
/*****************************************************---YOU'RE NEW APP---***********************************************************/
package oscar.awardService.view;


import oscar.awardService.model.Award;
import oscar.awardService.model.Nomination;
import oscar.awardService.persistence.AwardRepository;
import oscar.awardService.persistence.NominationRepository;

import java.util.ArrayList;
import java.util.List;
=======
/**
 *Documentation
 */


public class AppDriver {
    public static void main(String[] args) {

        System.out.println(" Projet Oscar in progress");

        AwardRepository awardRepository = AwardRepository.getInstance();

        // Getting all awards
        List<Award> allAwards = awardRepository.getAllAwards();
        System.out.println("All Awards :");
        for (Award award : allAwards) {
            System.out.println(award);
        }

        System.out.println(" ---------------------------------------------");

        NominationRepository nominationRepository = NominationRepository.getInstance();

        // Creating a sample nomination
        Nomination nomination = new Nomination(2024, 8.5, "The Nominee", new ArrayList<>());

        // Adding the nomination to the repository
        nominationRepository.addNomination(nomination);

        // Getting all nominations
        List<Nomination> allNominations = nominationRepository.getAllNominations();
        System.out.println("All Nominations :");
        for (Nomination n : allNominations) {
            System.out.println(n);
        }
        System.out.println("-------------------------------------------------");
        System.out.println(" Tout est ok ma poule !! ...");
    }
}



