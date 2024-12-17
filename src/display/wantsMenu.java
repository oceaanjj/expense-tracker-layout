package display;

public class wantsMenu {
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";
    clearScreen clr = new clearScreen();
    public void header() {
        clr.clearScreen();
        System.out.println(YELLOW + "\t\t\t\t\t\t __        __             _        " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t \\ \\      / /__ _  _ __  | |_  ___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  \\ \\ /\\ / // _` || '_ \\ | __|/ __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t   \\ V  V /| (_| || | | || |_ \\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t    \\_/\\_/  \\__,_||_| |_| \\__||___/ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                            " + RESET);
    }

    public void menu() {

        System.out.println("\t\t\t\t\t\t\t\t╔═══════════════════════════════════╗");
        System.out.println("\t\t\t\t\t\t\t\t║              MENU                 ║");
        System.out.println("\t\t\t\t\t\t\t\t╠═══════════════════════════════════╣");
        System.out.println("\t\t\t\t\t\t\t\t║ [1] SHOPPING                      ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [2] STUFFS                        ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [3] GADGETS                       ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [4] TRAVEL                        ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [5] UNCATEGORIZED                 ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [6] BACK                          ║");
        System.out.println("\t\t\t\t\t\t\t\t╚═══════════════════════════════════╝");
    }

    public void shopping() {
        clr.clearScreen();
        System.out.println(YELLOW + "\t\t\t\t\t\t  ____   _                           _                                       " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t / ___| | |__    ___   _ __   _ __  (_) _ __    __ _                         " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t \\___ \\ | '_ \\  / _ \\ | '_ \\ | '_ \\ | || '_ \\  / _` |                        " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  ___) || | | || (_) || |_) || |_) || || | | || (_| |                        " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |____/ |_| |_| \\___/ | .__/ | .__/ |_||_| |_| \\__, |                        " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                      |_|    |_|               |___/                         " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                                                               " + RESET);
    }

public void stuffs() {
    clr.clearScreen();
    
    System.out.println(YELLOW + "\t\t\t\t\t\t  ____   _            __   __                                                 " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t / ___| | |_  _   _  / _| / _| ___                                           " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t \\___ \\ | __|| | | || |_ | |_ / __|                                          " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t  ___) || |_ | |_| ||  _||  _|\\__ \\                                          " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t |____/  \\__| \\__,_||_|  |_|  |___/                                          " + RESET);
                                           

}

public void gadgets() {
    clr.clearScreen();
    System.out.println(YELLOW + "\t\t\t\t\t\t   ____             _               _                               " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t  / ___|  __ _   __| |  __ _   ___ | |_  ___                        " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t | |  _  / _` | / _` | / _` | / _ \\| __|/ __|                       " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t | |_| || (_| || (_| || (_| ||  __/| |_ \\__ \\                       " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t  \\____| \\__,_| \\__,_| \\__, | \\___| \\__||___/                       " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t                       |___/                                       " + RESET);
     
}

public void travel() {
    clr.clearScreen();
    System.out.println(YELLOW + "\t\t\t\t\t\t  _____                         _                                   " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t |_   _|_ __  __ _ __   __ ___ | |                                  " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t   | | | '__|/ _` |\\ \\ / // _ \\| |                                  " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t   | | | |  | (_| | \\ V /|  __/| |                                  " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t   |_| |_|   \\__,_|  \\_/  \\___||_|                                  " + RESET);
    System.out.println(YELLOW + "\t\t\t\t\t\t                                                               " + RESET);
    

}

public void uncategorized() {
    clr.clearScreen();
    System.out.println(YELLOW + "\t\t\t  _   _                     _                             _                _ " + RESET);
        System.out.println(YELLOW + "\t\t\t | | | | _ __    ___  __ _ | |_  ___   __ _   ___   _ __ (_) ____ ___   __| |" + RESET);
        System.out.println(YELLOW + "\t\t\t | | | || '_ \\  / __|/ _` || __|/ _ \\ / _` | / _ \\ | '__|| ||_  // _ \\ / _` |" + RESET);
        System.out.println(YELLOW + "\t\t\t | |_| || | | || (__| (_| || |_|  __/| (_| || (_) || |   | | / /|  __/| (_| |" + RESET);
        System.out.println(YELLOW + "\t\t\t  \\___/ |_| |_| \\___|\\__,_| \\__|\\___| \\__, | \\___/ |_|   |_|/___|\\___| \\__,_|" + RESET);
        System.out.println(YELLOW + "\t\t\t                                      |___/                                   " + RESET);
    
}






}
