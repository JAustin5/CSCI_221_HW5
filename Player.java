import java.util.*;
/**
 * CSCI 221, Summer 2022, Programming HW5
 * 
 * Name: <Jalena Austin>
 * <Player>.java
 * 
 * This class holds to be the main inheritance branch for all classes
 * for this program to gather the information for a player and output such
 * information in a standard format. While also being extended by the Batter &
 * Pitcher classes.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class Player
{
    // instance variables
    private String playerID;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String birthLocation;
    private int height;
    private int weight;
    public Player(String playerID, String firstName, String lastName, String birthDate,
        String birthLocation, int height, int weight) {
            // This is the constructor to build the class Player to initialize variables
            this.playerID = playerID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.birthLocation = birthLocation;
            this.height = height;
            this.weight = weight;
        }
        
    public String getPlayerID(){
        // Getter to return playerID from Player
        return playerID;
    }
    
    public String getFirstName() {
        // Getter to return firstName from Player
        return firstName;
    }
    
    public String getLastName() {
        // Getter to return lastName from Player
        return lastName;
    }
    
    public String getBirthDate() {
        // Getter to return birthDate from Player
        return birthDate;
    }
    
    public String getBirthLocaiton() {
        // Getter to return birthLocation from Player
        return birthLocation;
    }
    
    public int getHeight() {
        // Getter to return height from Player
        return height;
    }
    
    public int getWeight() {
        // Getter to return weight from Player
        return weight;
    }
    
    public String toString() {
        // toString builds output format for information for player
        String rtnString = "Player ID: " + playerID +
            "\nFirst Name: " + firstName + 
            "\nLast Name: " + lastName + 
            "\nBirth Date: " + birthDate + 
            "\nBirth Location: " + birthLocation + 
            "\nHeight: " + height + 
            "\nWeight: " + weight;
        
        return rtnString;
    }
}
