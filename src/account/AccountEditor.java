package account;

import display.MyAccount;
import display.clearScreen;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AccountEditor {

    public static final String GREEN_TEXT = "\u001B[32m"; 
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";
    public static final String YELLOW_TEXT = "\u001B[33m";
    private String email;
    private String password;
    private double monthlyIncome;
    private String newEmail;
    private String newPassword;
    boolean changed = false;
    MyAccount myAccount = new MyAccount();
    clearScreen clr = new clearScreen();

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }


    //paths of the folders to be updated
    public void updateEmail() {
        String baseDirectory = System.getProperty("user.dir") + "/src/database";

        renameFile(baseDirectory + "/accounts");
        renameFile(baseDirectory + "/savings");
        renameFile(baseDirectory + "/wants");
        renameFile(baseDirectory + "/needs");

        if(changed){
            clr.clearScreen();
            myAccount.header();
            System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\tEmail changed successfully." + RESET);
            
        } else {
            clr.clearScreen();
            myAccount.header();
            System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\t* Can't change Email. Please try again." + RESET);
        }
    }

    //changing the name of text file in accounts, needs, wants, savings
    private void renameFile(String directoryPath) {
        File oldFile = new File(directoryPath, getEmail() + ".txt");

        if (oldFile.exists()) {
            try {
                if (directoryPath.endsWith("/accounts")) {
                    List<String> txtfiledata = new ArrayList<>(Files.readAllLines(oldFile.toPath()));
                    if (!txtfiledata.isEmpty()) {
                        txtfiledata.set(0, getNewEmail());
                    }
                    Files.write(oldFile.toPath(), txtfiledata);
                }

                File newFile = new File(directoryPath, getNewEmail() + ".txt");
                if (oldFile.renameTo(newFile)) {
                    changed = true;
                } 
                else {
                    changed = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    
    }


    //changing the password of the text files in accounts folder (line 2)
    public void updatePassword() {
        String directory = System.getProperty("user.dir") + "/src/database/accounts";
        File file = new File(directory, getEmail() + ".txt");

        if (file.exists()) {
            try {
                List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));
                if (lines.size() > 1) {
                    lines.set(1, getNewPassword());
                }

                Files.write(file.toPath(), lines);
                clr.clearScreen();
                myAccount.header();
                System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\tPassword changed successfully." + RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            clr.clearScreen();
            myAccount.header();
            System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\t * Can't change Password. Please try again." + RESET);
        }
    }

    //changing the monthly income of the text files in accounts folder (line 4)
    public void updateIncome() {
        String directory = System.getProperty("user.dir") + "/src/database/accounts";
        File file = new File(directory, getEmail() + ".txt");

        if (file.exists()) {
            try {
                List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));
                if (lines.size() > 3) {
                    lines.set(3, String.valueOf(getMonthlyIncome()));
                }

                Files.write(file.toPath(), lines);
                clr.clearScreen();
                myAccount.header();
                System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\tIncome changed successfully." + RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            clr.clearScreen();
            myAccount.header();
            System.out.println(ORANGE_TEXT + "\n\n\t\t\t\t\t\t\t\t\t\t* Can't change Income. Please try again." + RESET);
        }
    }

    public boolean isEmailInUse(String email) {
        String directoryPath = System.getProperty("user.dir") + "/src/database/accounts";
        File file = new File(directoryPath, email + ".txt");
        return file.exists();
    }
    
}
