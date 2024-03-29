package oscar.electionServices.view;


import oscar.electionServices.control.ElectorController;
import oscar.electionServices.control.VoteForAward;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ElectorUI {

    ElectorController ec = new ElectorController();
    private VoteForAward voteFor = new VoteForAward();


    Scanner sc = new Scanner(System.in);

    public void startElectorUI() {

            System.out.println("Please type in a number between 1, 2 or 3 to navigate in the option below");
            System.out.println("option 1 : Show the elector list");
            System.out.println("option 2 : Vote");
            System.out.println("option 3 : Next Step");

           do{
                try{

                    int awnser = sc.nextInt();

                    if(awnser == 1){

                    System.out.println("InMemory");
                    ec.showElectorListMemory();

                    System.out.println("JDBC");
                    ec.showElectorListJDBC();

                    System.out.println("JPA");
                    ec.showElectorListJPA();
                        System.out.println("Do you want to vote for a nomination? (Yes/No) ");
                        String awnser3;
                        do{
                            awnser3 = sc.nextLine();
                            if(awnser3.equalsIgnoreCase("yes")){
                                try{
                                    int awnser4 ;

                                    System.out.println("Please type in a number between 1 and 3 to navigate in the option below");
                                    System.out.println("Options 1: In Memory Repository ");
                                    System.out.println("Options 2: JDBC ");
                                    System.out.println("Options 3: JPA ");

                                    awnser4 = sc.nextInt();

                                    if(awnser4 == 1){
                                        voteFor.createVoteMemory();

                                    } else if (awnser4 == 2) {
                                        voteFor.createVoteJDBC();
                                    } else if (awnser4 == 3) {
                                        voteFor.createVoteJPA();
                                    }
                                    break;

                                }catch (InputMismatchException ee){
                                    System.out.println("Please enter a valid number");
                                }
                            }else if(awnser3.equalsIgnoreCase("no")){
                                break;
                            }else{
                                System.out.println("We need yes or no");
                            }
                        }while(true);
                    break;
                }else if (awnser==2){
                        try{
                            int awnser2 ;

                            System.out.println("Please type in a number between 1 and 3 to navigate in the option below");
                            System.out.println("Options 1: In Memory Repository ");
                            System.out.println("Options 2: JDBC ");
                            System.out.println("Options 3: JPA ");

                            awnser2 = sc.nextInt();

                            if(awnser2 == 1){
                                voteFor.createVoteMemory();

                            } else if (awnser2 == 2) {
                                voteFor.createVoteJDBC();
                            } else if (awnser2 == 3) {
                                voteFor.createVoteJPA();
                            }

                            break;

                        }catch (InputMismatchException ee){
                            System.out.println("Please enter a valid number");
                        }

                } else if (awnser == 3) {
                    break;
                }else {
                    System.out.println("PLease enter a number between 1 and 3");
                }
                }catch (InputMismatchException ee){
                    System.out.println("Please enter a number: ");
                    sc.next();
                }
            }while(true);
    }
}
