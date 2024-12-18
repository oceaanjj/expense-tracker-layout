import account.AccountDeleter;
import account.AccountUpdater;
import account.Login;
import account.Registration;
import display.LoadingMenu;
import display.MyAccount;
import display.UserMenu;
import display.asciiArt;
import display.clearScreen;
import display.intro;
import display.mainmenu;
import java.util.*;
import user.Dashboard;
import user.Needs;
import user.Savings;
import user.Wants;
import user.userMain;

public class Main {
    public static final String GREEN_TEXT = "\u001B[32m"; 
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";
    /***
     * KULANG :
     * TRY AND CATCH SA IBANG PARTS NG CODE NAG EERROR DAPAT KAPAG INVALID INPUT TAS BABALIK, MAGAASK AGAIN
     * 
     * */
    public static void main (String[] args) {
        
        Scanner s = new Scanner(System.in);
        int choice;
        

        //TermsAndConditions terms = new TermsAndConditions();
        mainmenu mainmenu = new mainmenu();
        LoadingMenu load = new LoadingMenu();
        clearScreen clr = new clearScreen();
        Registration register = new Registration();
        Login login = new Login();
        asciiArt art = new asciiArt();
        intro intro = new intro();
        UserMenu userMenu = new UserMenu();
        MyAccount myAccount = new MyAccount();
        AccountDeleter delete = new AccountDeleter();
        AccountUpdater updater = new AccountUpdater();
        userMain user = new userMain();
        Savings savings = new Savings();
        Needs needs = new Needs();
        Wants wants = new Wants();
        Dashboard dashboard = new Dashboard();

        

        
        //start
        //clr.clearScreen();
        //art.display();
        //load.loading();
        //clr.clearScreen();

        //displaying intro title
        //intro.display(); 

        
       mainloop : while (true) {
            clr.clearScreen();
            //while (true) { 
                mainmenu.display();

                System.out.print("\n\t\t\t\t\t\t\t   Enter choice : ");
                
                try {
                    choice = s.nextInt();
                    s.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t* Invalid choice. Please enter a valid number." + RESET);
                    clr.clearScreen();
                    s.nextLine(); 
                    continue;
                }

                        switch (choice) {
                            //registration
                            case 1: 
                                clr.clearScreen();
                                register.startRegistration();
                                break;

                            case 2: 
                            //login
                                //clr.clearScreen();
                                
                                //System.out.println("Login");
                                
                                                                                           
                                if (login.userLogin()) {
                                        savings.setEmail(login.getEmail());
                                        needs.setEmail(login.getEmail());
                                        wants.setEmail(login.getEmail());
                                        dashboard.setEmail(login.getEmail());

                                        login.displayUserName(login.getEmail());
                                        user.setEmail(login.getEmail());
                                        
                                        
                                                    
                                                                                 
                                            UserMainMenu : while (true) {
                                                clr.clearScreen();
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                login.displayUserName(login.getEmail());
                                                
                                                userMenu.display();
                                                System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t     Enter choice : " + RESET);
                                                int userChoice = s.nextInt();

                                                switch(userChoice){
                                                    case 1:
                                                        /*myAccountmenu :*/ while (true) {
                                                            clr.clearScreen();
                                                            myAccount.header();
                                                            System.out.println("\n\n");
                                                            myAccount.display();
                                                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter choice : " + RESET );
                                                            int accountChoice = s.nextInt();
                                                            switch(accountChoice){

                                                                case 1:
                                                                clr.clearScreen();
                                                                    //change email (medyo done)                                
                                                                    updater.changeEmail();
                                                                    break;    

                                                                case 2:
                                                                clr.clearScreen();
                                                                    //change password (medyo done)
                                                                    updater.changePassword();
                                                                    break;
                
                                                                case 3:
                                                                clr.clearScreen();
                                                                    //change monthly income (medyo done)
                                                                    updater.changeIncome();
                                                                    break;

                                                                case 4:
                                                                
                                                                    //deletion ng account (sure na ata pag di nag bug letse)
                                                                    delete.deleteAccount();
                                                                    continue mainloop;
                                                                        


                                                                case 5:
                                                                /**
                                                                * 
                                                                * 
                                                                * 
                                                                * 
                                                                * RAIN - PRINTING OF DATA SHARING AGREEMENT
                                                                * 
                                                                * 
                                                                * 
                                                                * 
                                                                * 
                                                                */
                                                                //*ipapagawa kay rain */
                                                                    //read data sharing agreement
                                                                    break;

                                                                case 6:
                                                                /**
                                                                * 
                                                                * 
                                                                * 
                                                                * 
                                                                * RAIN - PRINTING HOW TO USE THE SYSTEM
                                                                * 
                                                                * 
                                                                * 
                                                                *                                         
                                                                */
                                                                //*ipapagawa kay rain */
                                                                    //help
                                                                    break;

                                                                case 7:
                                                                
                                                                    continue UserMainMenu;
                                                                default:
                                                                    System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t* Invalid choice. Please select a valid option."  + RESET);
                                                                    break;
                                                            }//switch case of my accountAccount
                                                        } //my account end loop
                                                        
                                                        

                                                                                            
                                                    case 2:
                                                    //start expense tracker
                                                    user.startExpenseTracker(savings, needs, wants);
                                                    break;


                                                    case 3:
                                                    //dashboard
                                                    //clr.clearScreen();
                                                    dashboard.displayDashboard();
                                                    System.out.println("do you want to go back to the main menu? (yes/no) : ");
                                                        if (s.nextLine().equalsIgnoreCase("yes")) {
                    return;
                }
                else if (s.nextLine().equalsIgnoreCase("no")) {
                    System.out.println("Invalid input. Please try again.");
                }
                else{
                    System.out.println("Invalid input. Please try again.");
                }
                                                    break;

                                                    case 4:
                                                    //logout
                                                    continue mainloop;

                                                    default:
                                                        System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t* Invalid choice. Please select a valid option." + RESET);
                                                        break;
                                                    }
                                                
                                                } //end of user main menu loop

                                            }//login status
                                    else
                                    {
                                        break;
                                        
                                    }
                            

                                            
                            
                            

                            case 3: 
                                System.out.println("\n\tThank you for using our system !");
                                break mainloop;

                            default:
                                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t* Invalid choice. Please select a valid option." + RESET );
                                break;
                        }
                    //}
        }//end ng main loop
    }
}