package account;

import display.MyAccount;
import display.clearScreen;
import java.io.File;

public class AccountDeleter extends AccountEditor {
    public static final String GREEN_TEXT = "\u001B[32m"; 
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";
    private final Verification verifier = new Verification();
    private final Confirmation confirm = new Confirmation();
    clearScreen clr = new clearScreen();
    MyAccount myAccount = new MyAccount();

    public void deleteAccount() {
        while (true) {
            
            try {
                clr.clearScreen();
                myAccount.header();
                if (verifier.verifyEmail(this) && verifier.verifyPassword(this)) {
                    clr.clearScreen();
                    myAccount.header();
                    if (confirm.confirmAction(ORANGE_TEXT + "\t\t\t\t\t\t\t\t Are you sure you want to delete your account? (y/n): " + RESET)) {
                        deleteAllFiles();
                        return;
                    } else {
                        clr.clearScreen();
                        myAccount.header();
                        System.out.println(ORANGE_TEXT + "\t\t\t\t\t\t\t\t* Account deletion cancelled." + RESET);
                    }
                } else {
                    clr.clearScreen();
                    myAccount.header();
                    System.out.println(ORANGE_TEXT + "\t\t\t\t\t\t\t\t* Verification failed. Account deletion aborted." + RESET);
                }
            } catch (Exception e) {
                clr.clearScreen();
                myAccount.header();
                System.out.println(" An error occurred during account deletion. "  + RESET);
            }
        }
    }

    //path to the files to be deleted (accounts, needs, savings, wants)
    private void deleteAllFiles() {
        String baseDir = System.getProperty("user.dir");
        deleteSingleFile(baseDir + "/src/database/accounts/" + getEmail() + ".txt");
        deleteSingleFile(baseDir + "/src/database/needs/" + getEmail() + ".txt");
        deleteSingleFile(baseDir + "/src/database/savings/" + getEmail() + ".txt");
        deleteSingleFile(baseDir + "/src/database/wants/" + getEmail() + ".txt");

        System.out.println("ACCOUNT SUCCESSFULLY DELETED.");
    }

    private void deleteSingleFile(String filePath) {
        File fileToDelete = new File(filePath);

        try {
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    System.out.println("Deleted file: " + filePath);
                } else {
                    System.out.println("Failed to delete file: " + filePath);
                }
            } else {
                System.out.println("File not found: " + filePath);
            }
        }  catch (Exception e) {
            System.out.println("An error occurred while deleting the file: " + filePath); 
        }
    }
}
