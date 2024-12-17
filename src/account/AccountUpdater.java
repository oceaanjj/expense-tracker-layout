package account;

import display.MyAccount;
import display.clearScreen;
import java.util.InputMismatchException;
import java.util.Scanner;



    /* 
       this is the class that will be used to update the account details 
       ( called in our main ) it is connected to Editor ( the one that had access to txt files)
    */
public class AccountUpdater extends AccountEditor {
    
    private final Verification verifier = new Verification();
    private final Scanner s = new Scanner(System.in);
    private final Confirmation confirm = new Confirmation();
    clearScreen clr = new clearScreen();
    MyAccount myAccount = new MyAccount();

    
    public void changeEmail() {
        clr.clearScreen();
        myAccount.header();

        while(true){
            //System.out.println(YELLOW_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\tChange your email" +     RESET); ;
            System.out.print(GREEN_TEXT + "\n\n\t\t\t\t\t\t\t\tEnter your new email : " + RESET);
            String newEmail = s.nextLine();
            clr.clearScreen();
        
            if(!newEmail.contains("@") || !newEmail.contains(".")) {
                myAccount.header();
                System.out.print(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t* REMINDER : Email should contain '@' and '.'" + RESET);
                continue;
            }
            else{
                    if (isEmailInUse(newEmail)) {
                        clr.clearScreen();
                        myAccount.header();
                        System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t  * The new email is already in use. Please try another email." + RESET);
                        changed = false;
                        continue;
                    }
                    else{
                    
                        setNewEmail(newEmail);
                        clr.clearScreen();
                        myAccount.header();
                        if (!verifier.verifyEmail(this) || !verifier.verifyPassword(this)) {
                            //clr.clearScreen();
                            //myAccount.header();
                            System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t\t* Verification failed. Cancelling email change." + RESET);
                            return;
                        }

                        if (confirm.confirmAction("\t\t\t\t\t\t\t\tAre you sure you want to change your email? (y/n): ")) {
                            updateEmail();
                            return;
                        }
                        else {
                            clr.clearScreen();
                            myAccount.header();
                            System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\tChanging account email cancelled." + RESET);
                            System.out.println("\n\n\t\t\t\t\t\t\t\tpress enter to continue...");
                            s.nextLine();
                            
                            return;
                        }
                    }
            }   
        }
    }

    public void changePassword() {
        clr.clearScreen();
        myAccount.header();
        //System.out.println(YELLOW_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\tChange your password" +     RESET); ;
        while(true){
        System.out.print(GREEN_TEXT + "\n\n\t\t\t\t\t\t\t\t\tEnter your new password:" + RESET);
        String newPassword = s.nextLine();
        setNewPassword(newPassword);

        clr.clearScreen();
        myAccount.header();
        if (!verifier.verifyEmail(this) || !verifier.verifyPassword(this)) {
            System.out.println(ORANGE_TEXT + "\t\t\t\t\t\t\t\t\t* Verification failed. Cancelling password change." + RESET);
            System.out.println("\n\n\t\t\t\t\t\t\t\tpress enter to continue...");
            s.nextLine();
            return;
        }

        if (confirm.confirmAction("\t\t\t\t\t\t\t\tAre you sure you want to change your email? (y/n): ")) {
            updatePassword();
            return;
        }
        else {
            clr.clearScreen();
            myAccount.header();
            System.out.println("\t\t\t\t\t\t\t\t\tChanging account password cancelled.");

            System.out.println("\n\n\t\t\t\t\t\t\t\tpress enter to continue...");
            s.nextLine();
            return;
        }
        }
    }

    public void changeIncome() {
        clr.clearScreen();
        myAccount.header();

        while(true){
            try {
                
                    // System.out.println(YELLOW_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\tChange your income" + RESET);
                    System.out.print(GREEN_TEXT + "\n\n\t\t\t\t\t\t\t\t\tEnter your new monthly income : " + RESET);
                    double newIncome = s.nextDouble();
                    setMonthlyIncome(newIncome);

                    clr.clearScreen();
                    myAccount.header();

                    if (!verifier.verifyEmail(this) || !verifier.verifyPassword(this)) {
                        System.out.println(ORANGE_TEXT + "* Verification failed. Cancelling income change." + RESET);
                        System.out.println("\n\n\t\t\t\t\t\t\t\tpress enter to continue...");
                        s.nextLine();
                        return;
                    }

                    if (confirm.confirmAction("\t\t\t\t\t\t\t\tAre you sure you want to change your income? (y/n): ")) {
                        updateIncome();
                        return;
                    } else {
                        clr.clearScreen();
                        myAccount.header();
                        System.out.println(ORANGE_TEXT + "\t\t\t\t\t\t\t\t\t* Changing monthly income cancelled." + RESET);
                        System.out.println("\n\n\t\t\t\t\t\t\t\tpress enter to continue...");
                        s.nextLine(); 
                        return;
                    }
                
            } catch (InputMismatchException e) {
                clr.clearScreen();
                myAccount.header();
                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t    * Invalid input. Please enter a numeric value for income." + RESET);
                s.nextLine(); 
                continue;
            }
        }
        
    }

}

    
