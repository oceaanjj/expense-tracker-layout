package display;


public class mainmenu extends menu {
    @Override
    public void display() {

                String yellow = "\u001B[33m";
                String reset = "\u001B[0m";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
                System.out.println(yellow + "\t\t\t\t\t                   __        _______ _     ____ ___  __  __ _____   _____ ___                 " + reset);
                System.out.println(yellow + "\t\t\t\t\t                   \\ \\      / / ____| |   / ___/ _ \\|  \\/  | ____| |_   _/ _ \\                " + reset);
                System.out.println(yellow + "\t\t\t\t\t                    \\ \\ /\\ / /|  _| | |  | |  | | | | |\\/| |  _|     | || | | |               " + reset);
                System.out.println(yellow + "\t\t\t\t\t                     \\ V  V / | |___| |__| |__| |_| | |  | | |___    | || |_| |               " + reset);
                System.out.println(yellow + "\t\t\t\t\t       _______  _  ___\\_/\\_/__|_____|_____\\____\\___/|_|_ |_|_____| _ |_|_\\___/  _______ ____  " + reset);
                System.out.println(yellow + "\t\t\t\t\t       | ____\\ \\/ /  _ \\| ____| \\ | / ___|| ____| |_   _|  _ \\    / \\  / ___| |/ / ____|  _ \\ " + reset);
                System.out.println(yellow + "\t\t\t\t\t       | _|   \\  /| |_) |  _| |  \\| \\___ \\|  _|     | | | |_) |  / _ \\| |   | ' /|  _| | |_) |" + reset);
                System.out.println(yellow + "\t\t\t\t\t       | |___ /  \\|  __/| |___| |\\  |___) | |___    | | |  _ <  / ___ \\ |___| . \\| |___|  _ < " + reset);
                System.out.println(yellow + "\t\t\t\t\t       |____/ _/\\_\\_|   |_____|_| \\_|____/|_____|__ |_|_|_| \\_\\/_/   \\_\\____|_|\\_\\_____|_| \\_\\" + reset);
                System.out.println(yellow + "\t\t\t\t\t                             / ___\\ \\ / / ___|_   _| ____|  \\/  |                             " + reset);
                System.out.println(yellow + "\t\t\t\t\t                             \\___ \\\\ V /\\___ \\ | | |  _| | |\\/| |                             " + reset);
                System.out.println(yellow + "\t\t\t\t\t                              ___) || |  ___) || | | |___| |  | |                             " + reset);
                System.out.println(yellow + "\t\t\t\t\t                             |____/ |_| |____/ |_| |_____|_|  |_|                             " + reset);
            
        
        
        
        
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t\t\t╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("\t\t\t\t\t\t\t║                                                               ║");        
        System.out.println("\t\t\t\t\t\t\t║\t\t\t  [1] Register                          ║");
        System.out.println("\t\t\t\t\t\t\t║\t\t\t  [2] Login                             ║");
        System.out.println("\t\t\t\t\t\t\t║\t\t\t  [3] Exit                              ║");
        System.out.println("\t\t\t\t\t\t\t║                                                               ║");
        System.out.println("\t\t\t\t\t\t\t╚═══════════════════════════════════════════════════════════════╝");
    }
}
