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
import display.wantsMenu;

public class Wants {
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";
    private String email;
    private double shopping;
    private double stuffs;
    private double gadgets;
    private double travel;
    private double uncategorized;
    wantsMenu menu = new wantsMenu();

    public void setShopping(double shopping) {
        this.shopping = shopping;
    }

    public double getShopping() {
        return shopping;
    }

    public void setStuffs(double stuffs) {
        this.stuffs = stuffs;
    }

    public double getStuffs() {
        return stuffs;
    }

    public void setGadgets(double gadgets) {
        this.gadgets = gadgets;
    }

    public double getGadgets() {
        return gadgets;
    }

    public void setTravel(double travel) {
        this.travel = travel;
    }

    public double getTravel() {
        return travel;
    }

    public void setUncategorized(double uncategorized) {
        this.uncategorized = uncategorized;
    }

    public double getUncategorized() {
        return uncategorized;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void wants() {
        Scanner s = new Scanner(System.in);

        wantsLoop: while (true) {
            menu.header();
            menu.menu();
            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter your choice: " + RESET);
            int choice = s.nextInt();

            // Check if the user income is zero
            double currentIncome = userIncome();
            if (currentIncome <= 0) {
                System.out.println(
                        ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Your income for this month has been fully spent." + RESET);
                System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   You cannot add any more expenses." + RESET);
                System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Press enter to exit." + RESET);
                s.nextLine();
                s.nextLine();
                return;
            }

            switch (choice) {
                case 1:
                    menu.shopping();
                    while (true) {
                        try {
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on shopping: " + RESET);
                            double shopping = s.nextDouble();
                            setShopping(shopping);
                            s.nextLine();
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter details (e.g. clothes, accessories): " + RESET);
                            String shoppingDetails = s.nextLine();

                            updateUserIncome(userIncome() - getShopping());
                            updateUserFile("Shopping", shopping, shoppingDetails);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println(ORANGE_TEXT+ "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                            s.nextLine();
                        }
                    }
                    break;

                case 2:
                    menu.stuffs();
                    while (true) {
                        try {
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on stuffs: " + RESET);
                            double stuffs = s.nextDouble();
                            setStuffs(stuffs);

                            s.nextLine();
                            System.out.print( GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter details (e.g. furniture, toys): " + RESET);
                            String stuffsDetails = s.nextLine();

                            updateUserIncome(userIncome() - getStuffs());
                            updateUserFile("Stuffs", stuffs, stuffsDetails);
                            break;
                        } catch (InputMismatchException e) {
                        System.out.println(ORANGE_TEXT+ "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                        s.nextLine();
                    }
                }
                break;
                case 3:
                    menu.gadgets();
                    while (true) {
                        try {
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on gadgets: " + RESET);
                            double gadgets = s.nextDouble();
                            setGadgets(gadgets);
                            s.nextLine();
                            System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter details (e.g. phone, tablet): " + RESET);
                            String gadgetsDetails = s.nextLine();

                            updateUserIncome(userIncome() - getGadgets());
                            updateUserFile("Gadgets", gadgets, gadgetsDetails);
                            break;
                        } catch (InputMismatchException e) {
                        System.out.println(ORANGE_TEXT+ "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                        s.nextLine();
                    }
                }
                break;


                case 4:
                menu.travel();
                while (true) {
                    try {
                        System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter the amount you spent on travel: " + RESET);
                        double travel = s.nextDouble();
                        setTravel(travel);
                        s.nextLine();
                        System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter details (e.g. vacation, road trip): " + RESET);
                        String travelDetails = s.nextLine();
            
                        updateUserIncome(userIncome() - getTravel());
                        updateUserFile("Travel", travel, travelDetails);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                        s.nextLine();
                    }
                }
                break;
            

            case 5:
            while (true) {
                try {
                    menu.uncategorized();
                    System.out.print(GREEN_TEXT+ "\n\t\t\t\t\t\t\t   Enter the amount you spent on uncategorized wants: " + RESET);
                    double uncategorized = s.nextDouble();
                    setUncategorized(uncategorized);
                    s.nextLine();
                    System.out.print(GREEN_TEXT + "\n\t\t\t\t\t\t\t   Enter details: " + RESET);
                    String uncategorizedDetails = s.nextLine();

                    updateUserIncome(userIncome() - getUncategorized());
                    updateUserFile("Uncategorized", uncategorized, uncategorizedDetails);
                    break;
                } catch (InputMismatchException e) {
                        System.out.println(ORANGE_TEXT+ "\n\t\t\t\t\t\t\t   Invalid input! Please enter a valid number." + RESET);
                        s.nextLine();
                    }
                }
                break;

                case 6:
                    break wantsLoop;

                default:
                    System.out.print(ORANGE_TEXT + "\n\t\t\t\t\t\t\t   Invalid choice. Please try again." + RESET);
            }
        }
    }

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

    private void updateUserFile(String detailType, double amount, String additionalInfo) {
        String directory = System.getProperty("user.dir") + "/src/database/wants";
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
