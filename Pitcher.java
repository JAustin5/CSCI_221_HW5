import java.lang.*;
/**
 * CSCI 221, Summer 2022, Programming HW5
 * 
 * Name: <Jalena Austin>
 * <Pitcher>.java
 * 
 * Class goes to create a realization between the Comparable interface class
 * alongside an inheritance to the Player class. This class goes to add additional
 * strings to a player information and goes to compare objects wins/losses and if needed
 * ERA for a pitcher by the pitcher file.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class Pitcher extends Player implements Comparable <Pitcher>
{
    // instance variables
    private int yearID;
    private String teamID;
    private int wins;
    private int losses;
    private double era;
    
    public Pitcher(String playerID, String firstName, String lastName, String birthDate,
        String birthLocation, int height, int weight, int yearID, String teamID, int wins, int losses, double era) {
       super(playerID, firstName, lastName, birthDate, birthLocation, height, weight);
       this.yearID = yearID;
       this.teamID = teamID;
       this.wins = wins;
       this.losses = losses;
       this.era = era;
    }
    
    public int getYearID()
    {
         return yearID;
    }
    
    public String getTeamID() {
        return teamID;
    }
    
    public int getWins() {
        return wins;
    }
    
    public int getLoss() {
        return losses;
    }
    
    public double getERA() {
        return era;
    }

    public String toString() {
        return super.toString() + "/nYear ID: " + yearID + 
                "\nTeam ID: " + teamID + 
                "\nWins: " + wins + 
                "\nLosses: " + losses + 
                "\nERA: " + era; 
    }
    
    
    public int compareTo(Pitcher otherPerson) {
        if ((this.wins - this.losses) == (otherPerson.getWins() - otherPerson.getLoss())) {
            if (this.era < otherPerson.getERA()) {
                return 1;
            }
            else if (this.era > otherPerson.getERA()) {
                return -1;
            }
            else {
                return 0;
            }
        }
        else if ((this.wins - this.losses) > (otherPerson.getWins() - otherPerson.getLoss())) {
            return 1;
        }
        else if ((this.wins - this.losses) < (otherPerson.getWins() - otherPerson.getLoss())) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
