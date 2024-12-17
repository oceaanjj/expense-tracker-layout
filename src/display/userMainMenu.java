package display;


public class userMainMenu {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m"; 

    clearScreen clr = new clearScreen();
    

    public void header() {

        clr.clearScreen();
    
        final String TABS = "\t\t\t\t\t\t\t\t\t\t\t";

        System.out.println(YELLOW + TABS + "_______  ______  _____ _   _ ____  _____           " + RESET);
        System.out.println(YELLOW + TABS + "| ____\\ \\/ /  _ \\| ____| \\ | / ___|| ____|          " + RESET);
        System.out.println(YELLOW + TABS + "|  _|  \\  /| |_) |  _| |  \\| \\___ \\|  _|            " + RESET);
        System.out.println(YELLOW + TABS + "| |___ /  \\|  __/| |___| |\\  |___) | |___           " + RESET);
        System.out.println(YELLOW + TABS + "|_____/_/\\_\\_| __|_____|_| \\_|____/|_____|___ ____  " + RESET);
        System.out.println(YELLOW + TABS + "        |_   _|  _ \\    / \\  / ___| |/ / ____|  _ \\ " + RESET);
        System.out.println(YELLOW + TABS + "          | | | |_) |  / _ \\| |   | ' /|  _| | |_) |" + RESET);
        System.out.println(YELLOW + TABS + "          | | |  _ <  / ___ \\ |___| . \\| |___|  _ < " + RESET);
        System.out.println(YELLOW + TABS + "          |_| |_| \\_\\/_/ __\\_\\____|_|\\_\\_____|_| \\_\\" + RESET);
        System.out.println(YELLOW + TABS + "                   |  \\/  | ____| \\ | | | | |       " + RESET);
        System.out.println(YELLOW + TABS + "                   | |\\/| |  _| |  \\| | | | |       " + RESET);
        System.out.println(YELLOW + TABS + "                   | |  | | |___| |\\  | |_| |       " + RESET);
        System.out.println(YELLOW + TABS + "                   |_|  |_|_____|_| \\_|\\___/        " + RESET);        
                                                           
    }
    



    public void menu() {
        System.out.println("\n\n");
                System.out.println("\t\t\t\t\t\t\t\t╔═══════════════════════════════════════════════╗"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                     CHOICES                   ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t╠═══════════════════════════════════════════════╣"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                                               ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                 [1] NEEDS                     ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                 [2] WANTS                     ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                 [3] SAVINGS                   ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                 [4] EXIT                      ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t║                                               ║"+ RESET);
                System.out.println("\t\t\t\t\t\t\t\t╚═══════════════════════════════════════════════╝" + RESET);          

        }
    }
    

