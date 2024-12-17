package display;

import display.clearScreen;


public class userMainMenu {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN_TEXT = "\u001B[32m"; 

    clearScreen clr = new clearScreen();
    

    public void header() {

        clr.clearScreen();
        System.out.println(YELLOW + "\t\t\t\t\t\t\t  _____                                 " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t | ____|_  ___ __   ___ _ __  ___  ___  " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t |  _| \\ \\/ / '_ \\ / _ \\ '_ \\/ __|/ _ \\ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t | |___ >  <| |_) |  __/ | | \\__ \\  __/ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t |_____/_/\\_\\ .__/ \\___|_| |_|___/\\___| " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t\t             |_|                         " + RESET);
        
        
        System.out.println(YELLOW + "\t\t\t\t\t\t  _____               _               __  __                  " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t |_   _| __ __ _  ___| | _____ _ __  |  \\/  | ___ _ __  _   _ " + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t   | || '__/ _` |/ __| |/ / _ \\ '__| | |\\/| |/ _ \\ '_ \\| | | |" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t   | || | | (_| | (__|   <  __/ |    | |  | |  __/ | | | |_| |" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t   |_||_|  \\__,_|\\___|_|\\_\\___|_|    |_|  |_|\\___|_| |_|\\__,_|" + RESET);
        System.out.println(YELLOW + "\t\t\t\t\t\t                                              " + RESET);
    }
    



    public void menu() {
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t╔═══════════════════════════════════╗"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║              CHOICES              ║"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t╠═══════════════════════════════════╣"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [1] NEEDS                         ║"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [2] WANTS                         ║"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [3] SAVINGS                       ║"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t║ [4] EXIT                          ║"+ RESET);
                System.out.println(GREEN_TEXT+"\t\t\t\t\t\t\t\t╚═══════════════════════════════════╝" + RESET);
                
                
                
                

        }
    }
    

