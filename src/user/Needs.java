package user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import display.needsMenu;

public class Needs {
    /**
     * KULANG :
     * if it is the first day of the month the text file of the user will be updated
     * to all false again.
     * all their bills will be set to unpaid again, and also their income,after
     * logged in dapat may mag aask lagi ng
     * 'DO YOU WANT TO ENTER YOUR INCOME FOR THIS MONTH ? if ' will add again the
     * remaining the balance
     */
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";
    private String email;
    private double food;
    private double transportation;
    private double bills;
    needsMenu menu = new needsMenu();
    // boolean status;

    public void setFood(double food) {
        this.food = food;
    }

    public double getFood() {
        return food;
    }

    public void setTransportation(double transportation) {
        this.transportation = transportation;
    }

    public double getTransportation() {
        return transportation;
    }

    public void setBills(double bills) {
        this.bills = bills;
    }

    public double getBills() {
        return bills;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void needs() {

        while (true) {
            Scanner s = new Scanner(System.in);
            menu.header();
            menu.menu();
            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter your choice : " + RESET);
            int choice = s.nextInt();


            // Check if the user income is zero
            double currentIncome = userIncome();
            if (currentIncome <= 0) {
                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Your income for this month has been fully spent." + RESET);
                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   You cannot add any more expenses." + RESET);
                System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Press enter to exit." + RESET);
                s.nextLine();
                s.nextLine(); 
                return;
            }

            switch (choice) {
                case 1:
                    menu.foods();
                    while (true) {
                        try {
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on food : " + RESET);
                            double food = s.nextDouble();
                            setFood(food);
                            s.nextLine();
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter name (e.g. fries, burger etc.) : " + RESET);
                            String name = s.nextLine();
                            updateUserFile("Food", food, name);
                            updateUserIncome(userIncome() - getFood());
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                            s.nextLine(); 
                        }
                    }
                    break;
                
                case 2:
                    menu.transportation();
                    while (true) {
                        try {
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on transportation : " + RESET);
                            double transportation = s.nextDouble();
                            setTransportation(transportation);
                            s.nextLine(); 
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter name (e.g. bus, taxi etc.) : " + RESET);
                            String name1 = s.nextLine();
                            updateUserIncome(userIncome() - getTransportation());
                            updateUserFile("Transportation", transportation, name1);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                            s.nextLine(); 
                        }
                    }
                    break;
                case 3:
                    // paid = false;
                    menu.bills();
                    System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter your choice : " + RESET);
                    int choice1 = s.nextInt();

                    switch (choice1) {
                        case 1:
                            menu.electricity();
                            while (true) {
                                try {
                                    System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on electricity : " + RESET);
                                    double bills = s.nextDouble();
                                    setBills(bills);
                                    updateUserIncome(userIncome() - getBills());
                                    updateBillStatus("ElectricityPaid", true);
                                    updateUserFile("Electricity", bills, "N/A");
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                                    s.nextLine();
                                }
                            }
                        case 2:
                        menu.water();
                        while (true) {
                            try {
                                System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on water : " + RESET);
                                double bills = s.nextDouble();
                                setBills(bills);
                                updateUserIncome(userIncome() - getBills());
                                updateBillStatus("WaterPaid", true);
                                updateUserFile("Water", bills, "N/A");
                                break; 
                            } catch (InputMismatchException e) {
                                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                                s.nextLine(); 
                            }
                        }
                        break;
                        case 3:
                        while (true) {
                            try {
                                System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on internet : " + RESET);
                                double bills = s.nextDouble();
                                setBills(bills);
                                updateUserIncome(userIncome() - getBills());
                                updateBillStatus("InternetPaid", true);
                                updateUserFile("Internet", bills, "N/A");
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                                s.nextLine(); 
                            }
                        }
                        break;
                        case 4:
                            menu.rent();
                            while (true) {
                                try {
                                    System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on rent : " + RESET);
                                    double bills = s.nextDouble();
                                    setBills(bills);
                                    updateUserIncome(userIncome() - getBills());
                                    updateBillStatus("RentPaid", true);
                                    updateUserFile("Rent", bills, "N/A");
                                    break; 
                                } catch (InputMismatchException e) {
                                    System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                                    s.nextLine(); 
                                }
                            }
                        case 5:
                            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   EXIT" + RESET);
                            break;
                    }
                    break;
                case 4:
                    System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   EXIT" + RESET);
                    return;
                default:
                    System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid choice! Please try again." + RESET);
                    break;
            }

        } // end of loop

    }

    /*
     * boolean isPaid(){
     * return paid;
     * }
     */

    public double userIncome() {
        String directory = System.getProperty("user.dir") + "/src/database/accounts";
        File file = new File(directory, getEmail() + ".txt");

        if (!file.exists()) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Login failed: Account does not exist." + RESET);
            return -1;
        }

        ArrayList<String> userTxtFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                userTxtFile.add(line.trim());
            }
        } catch (IOException ex) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error reading file." + RESET);
            return -1;
        }

        if (userTxtFile.size() < 4) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error: File does not contain enough lines." + RESET);
            return -1;
        }

        String incomeLine = userTxtFile.get(3);

        try {

            return Double.parseDouble(incomeLine);
        } catch (NumberFormatException e) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error: The income value is not a valid number." + RESET);
            return -1;
        }
    }

    public boolean updateUserIncome(double newIncome) {
        String directory = System.getProperty("user.dir") + "/src/database/accounts";
        File file = new File(directory, getEmail() + ".txt");

        if (!file.exists()) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Account does not exist." + RESET);
            return false;
        }

        ArrayList<String> userTxtFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                userTxtFile.add(line.trim());
            }
        } catch (IOException ex) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error reading file." + RESET);
            return false;
        }

        if (userTxtFile.size() < 4) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error: File does not contain enough lines." + RESET);
            return false;
        }

        userTxtFile.set(3, String.valueOf(newIncome));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : userTxtFile) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error writing to file." + RESET);
            return false;
        }

        System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Income updated successfully!" + RESET);

        return true;
    }

    private void updateBillStatus(String billType, boolean status) {
        String directory = System.getProperty("user.dir") + "/src/database/accounts";
        File file = new File(directory, getEmail() + ".txt");

        if (!file.exists()) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Account does not exist." + RESET);
            return;
        }

        ArrayList<String> userTxtFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userTxtFile.add(line.trim());
            }
        } catch (IOException ex) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error reading file." + RESET);
            return;
        }

        int statusIndex = -1;
        switch (billType) {
            case "ElectricityPaid":
                statusIndex = 8;
                break;
            case "WaterPaid":
                statusIndex = 9;
                break;
            case "InternetPaid":
                statusIndex = 10;
                break;
            case "RentPaid":
                statusIndex = 11;
                break;
        }

        if (statusIndex >= 0 && statusIndex < userTxtFile.size()) {
            userTxtFile.set(statusIndex, String.valueOf(status));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : userTxtFile) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error writing to file." + RESET);
        }
    }

    private void updateUserFile(String detailType, double amount, String additionalInfo) {
        String directory = System.getProperty("user.dir") + "/src/database/needs";
        File file = new File(directory, getEmail() + ".txt");

        if (!file.exists()) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Account does not exist." + RESET);
            return;
        }

        ArrayList<String> userTxtFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userTxtFile.add(line.trim());
            }
        } catch (IOException ex) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error reading file." + RESET);
            return;
        }

        // Append the new row
        String newRow = String.format("| %-20s | %-15.2f | %-30s |", detailType, amount, additionalInfo);
        userTxtFile.add(newRow);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : userTxtFile) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Error writing to file." + RESET);
        }

        System.out.print(
                GREEN_TEXT + detailType + "\n\t\t\t\t\t\t\t   has been successfully added to the table." + RESET);
    }

}
