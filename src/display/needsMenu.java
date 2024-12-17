package display;

public class needsMenu {
    clearScreen clr = new clearScreen();
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";


    public void header() {
        clr.clearScreen();
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t\t  _   _               _     " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t\t | \\ | | ___  ___  __| |___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t\t |  \\| |/ _ \\/ _ \\/ _` / __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t\t | |\\  |  __/  __/ (_| \\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t\t |_| \\_|\\___|\\___|\\__,_|___/" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t\t                            " + RESET);
    }

    public void menu() {
        System.out.println("\t\t\t\t\t\t\t\t╔═══════════════════════════════════╗");
        System.out.println("\t\t\t\t\t\t\t\t║                MENU               ║");
        System.out.println("\t\t\t\t\t\t\t\t╠═══════════════════════════════════╣");
        System.out.println("\t\t\t\t\t\t\t\t║ [1] FOODS                         ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [2] TRANSPORTATION                ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [3] BILLS                         ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [4] BACK                          ║");
        System.out.println("\t\t\t\t\t\t\t\t╚═══════════════════════════════════╝");

    }

    public void foods() {
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t  _____                  _      " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t |  ___|___    ___    __| | ___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t | |_  / _ \\  / _ \\  / _` |/ __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t |  _|| (_) || (_) || (_| |\\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t |_|   \\___/  \\___/  \\__,_||___/" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t                                 " + RESET);
    }

    public void transportation() {
        System.out.println(YELLOW + "\t\t\t\t  _____                                             _          _    _               " + RESET);
        System.out.println(YELLOW + "\t\t\t\t |_   _|_ __  __ _  _ __   ___  _ __    ___   _ __ | |_  __ _ | |_ (_)  ___   _ __  " + RESET);
        System.out.println(YELLOW + "\t\t\t\t   | | | '__|/ _` || '_ \\ / __|| '_ \\  / _ \\ | '__|| __|/ _` || __|| | / _ \\ | '_ \\ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t   | | | |  | (_| || | | |\\__ \\| |_) || (_) || |   | |_| (_| || |_ | || (_) || | | |" + RESET);
        System.out.println(YELLOW + "\t\t\t\t   |_| |_|   \\__,_||_| |_||___/| .__/  \\___/ |_|    \\__|\\__,_| \\__||_| \\___/ |_| |_|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t                               |_|                                                  " + RESET);
        
    }
    
    public void bills() {
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t  ____   _  _  _      " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t | __ ) (_)| || | ___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t |  _ \\ | || || |/ __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t | |_) || || || |\\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t |____/ |_||_||_||___/" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t\t                      " + RESET);


        System.out.println("\t\t\t\t\t\t\t\t╔═══════════════════════════════════╗");
        System.out.println("\t\t\t\t\t\t\t\t║              MENU                 ║");
        System.out.println("\t\t\t\t\t\t\t\t╠═══════════════════════════════════╣");
        System.out.println("\t\t\t\t\t\t\t\t║ [1] ELECTRICITY                   ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [2] WATER                         ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [3] INTERNET                      ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [4] RENT                          ║");
        System.out.println("\t\t\t\t\t\t\t\t║ [5] EXIT                          ║");
        System.out.println("\t\t\t\t\t\t\t\t╚═══════════════════════════════════╝");
        


    }

    public void electricity() {
        System.out.println(YELLOW + "\t\t\t\t\t\t  _____  _              _          _        _  _          " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t | ____|| |  ___   ___ | |_  _ __ (_)  ___ (_)| |_  _   _ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |  _|  | | / _ \\ / __|| __|| '__|| | / __|| || __|| | | |" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t | |___ | ||  __/| (__ | |_ | |   | || (__ | || |_ | |_| |" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |_____||_| \\___| \\___| \\__||_|   |_| \\___||_| \\__| \\__, |" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                                                    |___/ " + RESET);
        

    }

    public void internet() {
        System.out.println(YELLOW + "\t\t\t\t\t\t  ___         _                            _   " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |_ _| _ __  | |_  ___  _ __  _ __    ___ | |_ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  | | | '_ \\ | __|/ _ \\| '__|| '_ \\  / _ \\| __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  | | | | | || |_|  __/| |   | | | ||  __/| |_ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |___||_| |_| \\__|\\___||_|   |_| |_| \\___| \\__|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                                               " + RESET);
        

    }

    public void water() {
        System.out.println(YELLOW + "\t\t\t\t\t\t __        __      _              " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t \\ \\      / /__ _ | |_  ___  _ __ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  \\ \\ /\\ / // _` || __|/ _ \\| '__|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t   \\ V  V /| (_| || |_|  __/| |   " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t    \\_/\\_/  \\__,_| \\__|\\___||_|   " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                                  " + RESET);
        
    }

    public void rent() {
        System.out.println(YELLOW + "\t\t\t\t\t\t  ____               _   " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |  _ \\  ___  _ __  | |_ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t | |_) |/ _ \\| '_ \\ | __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |  _ <|  __/| | | || |_ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |_| \\_\\\\___||_| |_| \\__|" + RESET);
        
        
    }
}