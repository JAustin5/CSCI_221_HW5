import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * CSCI 221, Summer 2022, Programming HW5
 * Name: <Jalena Austin>
 * 
 * <PlayerStatsPortal>.java
 * 
 * Is the main class to handle the majority of user interface interaction
 * with the progam, allowing for certain options to be choosen by the user and then 
 * perform such actions within the program through this main class.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class PlayerStatsPortal
{
    public static void main(String[] args) throws IOException {
        // Main to run the user interaction portion of the program
        Scanner numInput = new Scanner(System.in);
        Scanner playerInput = new Scanner(System.in);
        
        int numPlayers;
        String userPlayer;
        
        Players fileRun = new Players("Pitching.csv", "Batting.csv", "Master.csv");
        
        int choice = 0;
        Scanner scnr = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println("Please enter a number between 1 and 6");
            System.out.println("1. Get the top batters sorted");
            System.out.println("2. Get the top pitchers sorted");
            System.out.println("3. Get the entered information for a certain player");
            System.out.println("4. Get the top Homerun hitters sorted");
            System.out.println("5. Get the lowest ERA sorted");
            System.out.println("6. Exit program");
            System.out.println("Enter your choice: ");
            System.out.println();
            
            try {
            
                choice = scnr.nextInt();
                System.out.println();
            
            switch(choice) {
                case 1:
                    try {
                        System.out.println("Enter the number of the top batters you want to sort");
                        numPlayers = numInput.nextInt();
                        
                        System.out.println();
                        System.out.println(fileRun.getTopBattersSorted(numPlayers));
                    }
                    catch (Exception firstChoice) {
                        System.out.println(firstChoice);
                    }
                    
                    break;
                    
                    
                case 2:
                    try {
                        System.out.println("Enter the number of top pitchers you want to sort");
                        numPlayers = numInput.nextInt();
                        
                        System.out.println();
                        System.out.println(fileRun.getTopPitchersSorted(numPlayers).toString());
                    }
                    catch (Exception secondChoice) {
                        System.out.println(secondChoice);                    
                    }
                    
                    break;
                    
                    
                case 3:
                    try {
                        System.out.println("Enter player ID to output their information");
                        userPlayer = playerInput.next();
                        
                        System.out.println();
                        System.out.println(fileRun.getPlayer(userPlayer));
                    }
                    catch (Exception thirdChoice) {
                        System.out.println(thirdChoice);
                    }
                    break;
                    
                    
                case 4:
                    try {
                        System.out.println("Enter the number of the highest homerun batters sorted");
                        numPlayers = numInput.nextInt();
                        
                        System.out.println();
                        System.out.println(fileRun.getTopHomerunHittersSorted(numPlayers).toString());
                    }
                    catch (Exception fourthChoice) {
                        System.out.println(fourthChoice);
                    }
                    break;
                    
                    
                case 5:
                    try {
                        System.out.println("Enter the number of the lowest ERA for pitchers sorted");
                        numPlayers = numInput.nextInt();
                        
                        System.out.println();
                        System.out.println(fileRun.getLowestERASorted(numPlayers).toString());
                    }
                    catch (Exception fifthChoice) {
                        System.out.println(fifthChoice);
                    }
                    break;
                    
                    
                case 6:
                    System.out.println("Goodbye");
                    break;
                    
                default:
                    System.out.println("Must enter an integer between 1 and 6");
            }    
            }
            catch (InputMismatchException msg) {
                System.out.println(msg + ": enter an integer between 1 and 6");
            }
        } while (choice != 6);
    }
}
