package display;

public class warning extends menu {
    public void display() {
    String red = "\u001B[31m";
        String reset = "\u001B[0m";
        String tabs = "\t\t\t\t\t\t\t\t"; // 8 tabs

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(red + tabs + "██╗" + reset);
        System.out.println(red + tabs + "██║" + reset);
        System.out.println(red + tabs + "██║" + reset);
        System.out.println(red + tabs + "╚═╝" + reset);
        System.out.println(red + tabs + "██╗" + reset);
        System.out.println(red + tabs + "╚═╝" + reset);
    }
}
