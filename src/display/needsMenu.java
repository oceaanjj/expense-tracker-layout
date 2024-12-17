package display;

public class needsMenu {
    clearScreen clr = new clearScreen();
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";


    public void header() {
        clr.clearScreen();
        System.out.println(YELLOW + "\t\t\t\t\t\t\t  _   _               _     " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t | \\ | | ___  ___  __| |___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t |  \\| |/ _ \\/ _ \\/ _` / __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t | |\\  |  __/  __/ (_| \\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t |_| \\_|\\___|\\___|\\__,_|___/" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t                            " + RESET);
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
}