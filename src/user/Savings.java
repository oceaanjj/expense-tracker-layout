package user;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Savings {
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";




    /*
     * KULANG :
     * INPUTS TRY CATCH
     * CHECK THE SCANNERS AND PRINT
     */
    private String email;
    private Scanner s = new Scanner(System.in);
    private String name;
    private double goal;
    private String frequency;
    LocalDate today = LocalDate.now();
    LocalDate endDate;
    // double savedSoFar;
    // String parts[];

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public double getGoal() {
        return goal;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }

    public void addSavings() {
        while (true) {
            System.out.println("\t\t\t\t\t\t\t\t╔═══════════════════════════════════╗");
            System.out.println("\t\t\t\t\t\t\t\t║                MENU               ║");
            System.out.println("\t\t\t\t\t\t\t\t╠═══════════════════════════════════╣");
            System.out.println("\t\t\t\t\t\t\t\t║ [1] START NEW SAVINGS             ║");
            final String savingsFolderPath = System.getProperty("user.dir") + "/src/database/savings";
            File savingsFile = new File(savingsFolderPath, email + ".txt");

            if (savingsFile.exists() && savingsFile.length() > 0) {
                System.out.println("\t\t\t\t\t\t\t\t║ [2] ADD TO EXISTING SAVINGS       ║");
                System.out.println("\t\t\t\t\t\t\t\t║ [3] DELETE A SAVINGS              ║");
            }
            System.out.println("\t\t\t\t\t\t\t\t║ [4] BACK                          ║");
            System.out.println("\t\t\t\t\t\t\t\t╚═══════════════════════════════════╝");
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter your choice: "+ RESET);
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    startNewSavings();
                    break;
                case 2:
                    if (savingsFile.exists() && savingsFile.length() > 0) {
                        addToExistingSavings();
                    } else {
                        System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No existing savings found. Please start a new savings entry."+RESET);
                    }
                    break;
                case 3:
                    if (savingsFile.exists() && savingsFile.length() > 0) {
                        deleteSavings();
                    } else {
                        System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No savings entries found to delete."+RESET);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Invalid choice. Please try again." + RESET);
            }
        }
    }

    public void startNewSavings() {
        s.nextLine();
       System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter Savings Name (e.g. Tuition): " + RESET);
        String savingsName = s.nextLine().trim();
        setName(savingsName);

        while (true) {
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter your goal amount: "+RESET);

            try {
                if (s.hasNextDouble()) {
                    double goalAmount = s.nextDouble();
                    setGoal(goalAmount);
                    if (getGoal() > 0) {
                        break;
                    } else {
                        System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Goal amount must be greater than zero."+RESET);
                    }
                } else {
                    System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Invalid input. Please enter a valid number."+RESET);
                    s.next();
                }
            } catch (InputMismatchException e) {
               System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Invalid input. Please enter a valid number."+RESET);
                s.next(); // pangclear ng input
            }

        }

        while (true) {
            s.nextLine();
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter frequency (daily/weekly/monthly): "+RESET);
            String savingsFrequency = s.nextLine().toLowerCase().trim();
            setFrequency(savingsFrequency);
            if (getFrequency().equals("daily") || getFrequency().equals("weekly") || getFrequency().equals("monthly")) {
                break;
            } else {
                System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Invalid frequency. Please enter 'daily', 'weekly', or 'monthly'."+RESET);
            }
        }

        while (true) {
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter Date to finish (YYYY-MM-DD): "+RESET);
            String endDateStr = s.nextLine().trim();
            try {
                endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                if (endDate.isAfter(today)) {
                    break;
                } else {
                   System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   End date must be in the future."+RESET);
                }
            } catch (DateTimeParseException e) {
                System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Invalid date format. Please use YYYY-MM-DD."+RESET);
            }
        }

        saveSavings(0.0);
    }

    public void saveSavings(double savedSoFar) {
        final String savingsFolderPath = System.getProperty("user.dir") + "/src/database/savings";
        File savingsFolder = new File(savingsFolderPath);
        File savingsFile = new File(savingsFolder, email + ".txt");

        if (!savingsFolder.exists() && !savingsFolder.mkdirs()) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to create savings directory."+RESET);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savingsFile, true))) {
            // Calculate remaining balance
            double remaining = getGoal() - savedSoFar;
            String status = remaining <= 0 ? "Goal Achieved" : "On Going";

            // Save the entry with proper formatting, including the remaining balance
            writer.write(String.format("| %-20s | %-15.2f | %-16.2f | %-15s | %-15s | %-17.2f | %-12s |\n",
                    getName(), getGoal(), savedSoFar, getFrequency(), endDate, Math.max(0, remaining), status));
           System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Savings entry saved successfully!");
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to save savings entry. Please try again." + RESET);
        }
    }

    public void addToExistingSavings() {
        final String savingsFolderPath = System.getProperty("user.dir") + "/src/database/savings";
        File savingsFile = new File(savingsFolderPath, email + ".txt");

        if (!savingsFile.exists()) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No savings file found for this account." + RESET);
            return;
        }

        List<String> fileLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(savingsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to read savings file. Please try again."+RESET);
            return;
        }

        List<String> savingsNames = new ArrayList<>();
        List<String[]> savingsData = new ArrayList<>();
        for (String line : fileLines) {
            if (line.startsWith("+") || line.startsWith("| Savings Name")) {
                continue; // Skip header lines
            }
            if (line.startsWith("|")) {
                String[] parts = line.split("\\|");
                String savingsName = parts[1].trim();
                String status = parts[6].trim();

                if (!"Goal Achieved".equalsIgnoreCase(status)) {
                    savingsNames.add(savingsName);
                    savingsData.add(parts);
                }
            }
        }

        if (savingsNames.isEmpty()) {
           System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No ongoing savings goals to update. Returning to the menu."+RESET);
            return;
        }

        System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Choose a savings to add to:"+RESET);
        for (int i = 0; i < savingsNames.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + savingsNames.get(i));
        }

        System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter your choice: "+RESET);
        int choice = s.nextInt();
        if (choice < 1 || choice > savingsNames.size()) {
            System.out.println(ORANGE_TEXT+"Invalid choice."+ RESET);
            return;
        }

        String selectedSavings = savingsNames.get(choice - 1);
        String[] selectedSavingsData = savingsData.get(choice - 1);

        double goal = Double.parseDouble(selectedSavingsData[2].trim());
        double savedSoFar = Double.parseDouble(selectedSavingsData[3].trim());
        double remaining = goal - savedSoFar;

        // Check if goal is already achieved
        if (remaining <= 0) {
            System.out.print(YELLOW+"\n\t\t\t\t\t\t\t   You already completed this savings goal. Returning to the menu." + RESET);
            return;
        }

        System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter the amount to add to " + selectedSavings + ": " + RESET);
        double amountToAdd = s.nextDouble();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savingsFile))) {
            for (String line : fileLines) {
                if (line.contains(selectedSavings)) {
                    savedSoFar += amountToAdd;
                    remaining = goal - savedSoFar;

                    // Determine status
                    String newStatus = remaining <= 0 ? "Goal Achieved" : "On Going";

                    // Update the table row
                    line = String.format("| %-20s | %-15.2f | %-16.2f | %-15s | %-15s | %-17.2f | %-12s |",
                            selectedSavings, goal, savedSoFar, selectedSavingsData[4].trim(),
                            selectedSavingsData[5].trim(), Math.max(0, remaining), newStatus);

                    // Print suggestion in console
                    String endDate = selectedSavingsData[5].trim();
                    String frequency = selectedSavingsData[4].trim();
                    System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Suggestion: " + generateSuggestion(remaining, savedSoFar, frequency, endDate) + RESET);
                }
                writer.write(line + "\n");
            }
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Savings updated successfully!"+RESET );
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to update savings file. Please try again."+RESET);
        }
    }

    private String generateSuggestion(double remaining, double savedSoFar, String frequency, String endDate) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate targetDate = LocalDate.parse(endDate, formatter);
        long daysRemaining = ChronoUnit.DAYS.between(today, targetDate);

        if (remaining <= 0) {
            return "Congratulations! You've achieved your savings goal!";
        }

        if (daysRemaining <= 0) {
            return "The end date has passed. Please review your savings plan.";
        }

        double dailyTarget = remaining / Math.max(1, daysRemaining);
        double weeklyTarget = dailyTarget * 7;

        if (frequency.equalsIgnoreCase("daily")) {
            return String.format(
                    "You need to save approximately %.2f daily to reach your goal by %s. Keep pushing forward!",
                    dailyTarget, targetDate);
        } else if (frequency.equalsIgnoreCase("weekly")) {
            return String.format(
                    "You need to save approximately %.2f weekly to reach your goal by %s. Stay consistent!",
                    weeklyTarget, targetDate);
        } else if (frequency.equalsIgnoreCase("monthly")) {
            long monthsRemaining = ChronoUnit.MONTHS.between(today, targetDate);
            double monthlyTarget = remaining / Math.max(1, monthsRemaining);
            return String.format(
                    "You need to save approximately %.2f monthly to achieve your goal by %s. Keep going!",
                    monthlyTarget, targetDate);
        }

        return "You're on track! Keep saving to achieve your goal by " + targetDate + ".";
    }

    public void viewExistingSavings() {
        final String savingsFolderPath = System.getProperty("user.dir") + "/src/database/savings";
        File savingsFile = new File(savingsFolderPath, email + ".txt");

        if (!savingsFile.exists()) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No savings file found for this account."+RESET);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(savingsFile))) {
            String line;
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Your Savings:" + RESET);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to read savings file."+RESET);
        }
    }

    public void deleteSavings() {
        final String savingsFolderPath = System.getProperty("user.dir") + "/src/database/savings";
        File savingsFile = new File(savingsFolderPath, email + ".txt");

        if (!savingsFile.exists() || savingsFile.length() == 0) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No savings file found or the file is empty. Nothing to delete."+ RESET);
            return;
        }

        List<String> fileLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(savingsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to read savings file. Please try again."+RESET);
            return;
        }

        List<String> savingsNames = new ArrayList<>();
        for (String line : fileLines) {
            if (line.startsWith("+") || line.startsWith("| Savings Name")) {
                continue; // Skip header lines
            }
            if (line.startsWith("|")) {
                String[] parts = line.split("\\|");
                String savingsName = parts[1].trim();
                savingsNames.add(savingsName);
            }
        }

        if (savingsNames.isEmpty()) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   No savings entries found to delete."+ RESET);
            return;
        }

        System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Choose a savings to delete:" + RESET);
        for (int i = 0; i < savingsNames.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + savingsNames.get(i));
        }

        System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Enter your choice: "+RESET);
        int choice = s.nextInt();
        if (choice < 1 || choice > savingsNames.size()) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t      Invalid choice."+RESET);
            return;
        }

        String selectedSavings = savingsNames.get(choice - 1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savingsFile))) {
            for (String line : fileLines) {
                if (!line.contains(selectedSavings)) {
                    writer.write(line + "\n");
                }
            }
            System.out.print(GREEN_TEXT+"\n\t\t\t\t\t\t\t   Savings \"" + selectedSavings + "\" deleted successfully!" + RESET);
        } catch (IOException e) {
            System.out.print(ORANGE_TEXT+"\n\t\t\t\t\t\t\t   Failed to update savings file after deletion. Please try again."+RESET);
        }
    }

}
