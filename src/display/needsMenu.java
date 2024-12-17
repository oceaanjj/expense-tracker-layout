package display;
import display.clearScreen;

public class needsMenu {
    clearScreen clr = new clearScreen();
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m"; 


    public void header() {
        clr.clearScreen();
        System.out.println(YELLOW + "\t\t\t\t\t\t  _   _               _     " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t | \\ | | ___  ___  __| |___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |  \\| |/ _ \\/ _ \\/ _` / __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t | |\\  |  __/  __/ (_| \\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |_| \\_|\\___|\\___|\\__,_|___/" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                            " + RESET);
    }

    public void menu() {
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t╔═══════════════════════════════════╗"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║              CHOICES              ║"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t╠═══════════════════════════════════╣"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [1] FOODS                         ║"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [2] TRANSPORTATION                ║"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [3] BILLS                         ║"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [4] EXIT                          ║"+ RESET);
        System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t╚═══════════════════════════════════╝" + RESET);
        
    }
}