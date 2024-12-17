package display;

public class wantsMenu {
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String ORANGE_TEXT = "\u001B[38;5;214m";

    public void header() {
        System.out.println(YELLOW + "\t\t\t\t\t\t __        __             _        " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t \\ \\      / /__ _  _ __  | |_  ___ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t  \\ \\ /\\ / // _` || '_ \\ | __|/ __|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t   \\ V  V /| (_| || | | || |_ \\__ \\" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t    \\_/\\_/  \\__,_||_| |_| \\__||___/ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                            " + RESET);
    }

    public void menu() {
        
    }






}
