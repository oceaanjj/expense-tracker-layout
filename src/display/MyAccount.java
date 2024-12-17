package display;

public class MyAccount extends menu {
    public void display() {
        System.out.println("\t\t\t\t\t\t\t╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("\t\t\t\t\t\t\t║                                                               ║");
        System.out.println("\t\t\t\t\t\t\t║                   [1] Change Email                            ║");
        System.out.println("\t\t\t\t\t\t\t║                   [2] Change Password                         ║");
        System.out.println("\t\t\t\t\t\t\t║                   [3] Change Monthly Income                   ║");
        System.out.println("\t\t\t\t\t\t\t║                   [4] Delete Account                          ║");
        System.out.println("\t\t\t\t\t\t\t║                   [5] Read Data Sharing Agreement             ║");
        System.out.println("\t\t\t\t\t\t\t║                   [6] Help                                    ║");
        System.out.println("\t\t\t\t\t\t\t║                   [7] Back                                    ║");
        System.out.println("\t\t\t\t\t\t\t║                                                               ║");
        System.out.println("\t\t\t\t\t\t\t╚═══════════════════════════════════════════════════════════════╝");
    }  
    public void header(){
        System.out.println("\n\n\n\n\n\n\n\n");
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";
        String tabs = "\t\t\t\t\t\t\t"; 
        System.out.println("\n\n");

        System.out.println(yellow + tabs + "      __  ____   __     _    ____ ____ ___  _   _ _   _ _____ " + reset);
        System.out.println(yellow + tabs + "     |  \\/  \\ \\ / /    / \\  / ___/ ___/ _ \\| | | | \\ | |_   _|" + reset);
        System.out.println(yellow + tabs + "     | |\\/| |\\ V /    / _ \\| |  | |  | | | | | | |  \\| | | |  " + reset);
        System.out.println(yellow + tabs + "     | |  | | | |    / ___ \\ |__| |__| |_| | |_| | |\\  | | |  " + reset);
        System.out.println(yellow + tabs + "     |_|  |_| |_|   /_/   \\_\\____\\____\\___/ \\___/|_| \\_| |_|  " + reset);
    }
    
}