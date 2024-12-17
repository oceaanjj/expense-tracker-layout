package user;

import display.clearScreen;
import java.io.*;
import java.util.Scanner;

        /*
            This class is used to display the dashboard of the user
            (where they can see their expenses and the existing tables in their
            savings, needs and wants
            (nag re-read ng files to display the contents)
        */
public class Dashboard{
    private String email;
    clearScreen clr = new clearScreen();
    Scanner s = new Scanner(System.in);

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void displayDashboard () {
        clr.clearScreen();
        String baseDir = System.getProperty("user.dir") + "/src/database";

        String savingsPath = baseDir + "/savings/" + getEmail() + ".txt";
        String wantsPath = baseDir + "/wants/" + getEmail() + ".txt";
        String needsPath = baseDir + "/needs/" + getEmail() + ".txt";

        displayFileContents(new File(savingsPath), "SAVINGS");
        displayFileContents(new File(wantsPath), "WANTS");
        displayFileContents(new File(needsPath), "NEEDS");
    }


    private void displayFileContents(File file, String type) {
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.println(type + ":");
                int lineCount = 0;
                String line;
                boolean hasData = false;

                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    System.out.println(line);

                    if (lineCount > 3 && !line.trim().isEmpty()) {
                        hasData = true;
                    }
                }
                if (lineCount <= 3 || !hasData) {
                    System.out.println("  No expense added yet.");
                }

                System.out.println(); 

                System.out.println("-------------------------------------------------");
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
                
            } catch (IOException e) {
                System.err.println("Error reading file " + file.getAbsolutePath() + ": " + e.getMessage());
            }
        } else {
            System.out.println(type + " file not found: " + file.getAbsolutePath());
        }
    }
}