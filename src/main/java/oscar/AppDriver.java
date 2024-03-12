/******************************************************---HELLO WORLD---*************************************************************/
/***************************************************---THE MUSKETEERS IS---**********************************************************/
/****************************************************---ABOUT TO PROGRAM---**********************************************************/
/*****************************************************---YOU'RE NEW APP---***********************************************************/
package oscar;

import oscar.awardService.view.AwardUI;
import oscar.awardService.view.NominationUI;
import oscar.electionServices.control.VoteForAward;
import oscar.electionServices.view.ElectorUI;
/**
 *Test the App
 */

public class AppDriver {
    public static void main(String[] args) {
        System.out.println("Projet Oscar in progress");

       //Testing the UI of all the awards
        AwardUI aUI = new AwardUI();
        aUI.startTheAwardUI();

        System.out.println("---------------------------------------------");

        //Test The Elector UI
        ElectorUI  eui = new ElectorUI();
        eui.startElectorUI();

        System.out.println("---------------------------------------------");

        //Testing the UI of all the nomination
        NominationUI nUI = new NominationUI();
        nUI.startNominationUI();

        System.out.println("Project look fine so far...");
    }
}



