package display;
import display.clearScreen;
public class savingsMenu {
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    clearScreen clr = new clearScreen();
    public void header() {
        clr.clearScreen();

        System.out.println(YELLOW + "\t\t\t\t\t\t  ____              _                 " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t / ___|  __ ___   _(_)_ __   __ _ ___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t \\___ \\ / _` \\ \\ / / | '_ \\ / _` / __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  ___) | (_| |\\ V /| | | | | (_| \\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |____/ \\__,_| \\_/ |_|_| |_|\\__, |___/" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                            |___/     " + RESET);

    }

   //menu pa
}
