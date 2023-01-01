import java.util.*;
/**
 * CSCI 221, Summer 2022, Programming HW5
 * 
 * Name: <Jalena Austin>
 * <Batter>.java
 * 
 * Class goes to create a realization between the Comparable interface class
 * alongside an inheritance to the Player class. This class goes to add additional
 * strings to a player information and goes to compare objects RBI and if needed
 * Homerun(s) for a batter by the batter file, which is inserted through the 
 * PlayerStatsPortal main class and checked through the Players class.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class Batter extends Player implements Comparable <Batter>
{
    // instance variables
    private int yearID;
    private String teamID;
    private int homeRun;
    private int rbiAmt;

    public Batter(String playerID, String firstName, String lastName, String birthDate,
        String birthLocation, int height, int weight, int yearID, String teamID, int homeRun, int rbiAmt) {
        // initialise instance variables
        super(playerID, firstName, lastName, birthDate, birthLocation, height, weight);
        this.yearID = yearID;
        this.teamID = teamID;
        this.homeRun = homeRun;
        this.rbiAmt = rbiAmt;
    }
    
    public int getYearID() {
        // Returns the yearID for Batter
        return yearID;
    }
    
    public String getTeamID() {
        // Returns the teamID for Batter
        return teamID;
    }
    
    public int getHomeRun() {
        // Returns the homeRun amount for a Batter
        return homeRun;
    }
    
    public int getRBI() {
        // Returns the RBI for a Batter
        return rbiAmt;
    }
    
    public String toString() {
        // Returns a string of information for Player with additonal information of their Batter career
        return super.toString() + "\nYear ID: " + yearID +
                "\nTeam ID: " + teamID + 
                "\nHome Run(s): " + homeRun +
                "\nRBI (Runs Batted In): " + rbiAmt;
    }
    
    public int compareTo(Batter otherPerson) {
        // A comparable that takes to compare two objects first RBI 
        // and if equal then their homerun amounts
        if (this.rbiAmt == otherPerson.getRBI()) {
            if (this.homeRun > otherPerson.getHomeRun()) {
                return 1;
            }
            else if (this.homeRun < otherPerson.getHomeRun()) {
                return -1;
            }
            else {
                return 0;
            }
        }
        else if (this.rbiAmt > otherPerson.getRBI()) {
            return 1;
        }
        else if (this.rbiAmt < otherPerson.getRBI()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
