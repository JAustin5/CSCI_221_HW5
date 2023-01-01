import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * CSCI 221, Summer 2022, Programming HW5
 * 
 * Name: <Jalena Austin>
 * <Players>.java
 * 
 * This class goes to create the assocation between it and the
 * Player class for this program to be run through the main, which is 
 * this class's dependecy to run.
 * 
 * Certification of Authentication:
 * I certify that this assignment is entirely my own work.
 */
public class Players 
{
    private ArrayList<Player> Roster;

    public Players(String PitData, String BatData, String MasterData) throws FileNotFoundException {
        /*
         *  Takes three files as a parameter to then read and inserts
         *  certain indexes of the ArrayList to be accessed throughout
         *  the program.
         */
        File batFile = new File(BatData);
        Scanner batFileScan = new Scanner(batFile);
        
        File pitFile = new File(PitData);
        Scanner pitFileScan = new Scanner(pitFile);
        
        File masterFile = new File(MasterData);
        Scanner masterFileScan = new Scanner(masterFile);
        
        
        int count = 0;
        
        List<String[]> masterLine = new ArrayList<String[]>();
        while (masterFileScan.nextLine() != null) {
            String mLine = "";
            String[] spot = mLine.split(",");
            String playerID = spot[0];
            String firstName = spot[13];
            String lastName = spot[14];
            String birthDate = (spot[2] + "/" + spot[3] + "/" + spot[1]);
            String birthLocation = (spot[6] + ", " + spot[5] + ", " + spot[4]);
            String height = spot[17];
            String weight = spot[16];
            
            masterLine.add(new String [] {playerID, firstName, lastName, birthDate, birthLocation, height, weight});
            count++;
        }
        
        String[][] array = new String[masterLine.size()][0];
        masterLine.toArray(array);
        
        Roster = new ArrayList<Player>();
        while (batFileScan.nextLine() != null) {
            String bLine = "";
            String[] spot = bLine.split(",");
            String batterPlayerID = spot[0];
            int yearID = Integer.parseInt(spot[1]);
            String teamID = spot[3];
            int homeRun = Integer.parseInt(spot[11]);
            int rbiAmt = Integer.parseInt(spot[12]);
            
            int i = 0;
            while (i < masterLine.size()) {
                if (batterPlayerID.compareTo(masterLine.get(i)[0]) == 0) {
                    String firstName = masterLine.get(i)[1];
                    String lastName = masterLine.get(i)[2];
                    String birthDate = masterLine.get(i)[3];
                    String birthLocation = masterLine.get(i)[4];
                    int height = Integer.parseInt(masterLine.get(i)[5]);
                    int weight = Integer.parseInt(masterLine.get(i)[6]);
                    
                    Roster.add(new Batter (batterPlayerID, firstName, lastName, birthDate, birthLocation, 
                        height, weight, yearID, teamID, homeRun, rbiAmt));
                    break;
                }
                else {
                    i++;
                }
            }
        }
        
        
        while (pitFileScan.nextLine() != null) {
            String pLine = "";
            String[] spot = pLine.split(",");
            String pitcherPlayerID = spot[0];
            int yearID = Integer.parseInt(spot[1]);
            String teamID = spot[3];
            int wins = Integer.parseInt(spot[5]);
            int losses = Integer.parseInt(spot[6]);
            double eraAmt = Double.parseDouble(spot[19]);
            
            int j = 0;
            while (j < masterLine.size()) {
                if (pitcherPlayerID.compareTo(masterLine.get(j)[0]) == 0) {
                    String firstName = masterLine.get(j)[1];
                    String lastName = masterLine.get(j)[2];
                    String birthDate = masterLine.get(j)[3];
                    String birthLocation = masterLine.get(j)[4];
                    int height = Integer.parseInt(masterLine.get(j)[5]);
                    int weight = Integer.parseInt(masterLine.get(j)[6]);
                    
                    Roster.add(new Pitcher (pitcherPlayerID, firstName, lastName, birthDate, birthLocation,
                        height, weight, yearID, teamID, wins, losses, eraAmt));
                    
                    break;
                }
                else {
                    j++;
                }
            }
        }
    }

    public String toString() {
        // Return the format of the Players class output
        String outputString = "";
        for (Player person : Roster) {
            outputString += person;
        }
        return outputString;
    }
    
    public ArrayList<Batter> getTopBattersSorted (int n) throws Exception {
         /*
         * Takes an input of the number of pitchers wanted to be
         * sorted from the most to least top pitchers from the 
         * pitcher file and recognizing them through the master file
         * to then return them to the user.
         */

        int topBatters = 0;
        String batters = null;
        
        ArrayList <Batter> batPlayer = new ArrayList <Batter>();
        try {
            for (Player batPlayRoster : Roster) {
                batPlayer.add((Batter)batPlayRoster);
            }
            
        }
        catch (Exception excpt) {
            
        }
        
        Collections.sort(batPlayer);
        
        try {
            while (topBatters < n) {
                for (int i = 0; i < batPlayer.size(); i++) {
                        if (batPlayer.get(i).compareTo(batPlayer.get(batPlayer.size() - 1)) == 1) {
                            batters += batPlayer.get(i).toString();
                            i++;
                        }
                }
                topBatters++;
                return batPlayer;
            }
        }
        catch (Exception msgs) {
            
        }
        return null;
    }
    
    public ArrayList<Pitcher> getTopPitchersSorted (int n) throws Exception {
        /*
         * Takes an input of the number of pitchers wanted to be
         * sorted from the most to least top pitchers from the 
         * pitcher file and recognizing them through the master file
         * to then return them to the user.
         */

        int topPitchers = 0;
        String pitcher = "";
        
        ArrayList <Pitcher> pitPlayer = new ArrayList <Pitcher>();
        try {
            for (Player pitPlayRoster : Roster) {
                pitPlayer.add((Pitcher)pitPlayRoster);
            }
            
        }
        catch (Exception excpt) {
            
        }
        
        Collections.sort(pitPlayer);
        
        try {
            while (topPitchers < n) {
                for (int i = 0; i < pitPlayer.size(); i++) {
                        if (pitPlayer.get(i).compareTo(pitPlayer.get(pitPlayer.size() - 1)) == 1) {
                            pitcher += pitPlayer.get(i).toString();
                            i++;
                        }
                }
                topPitchers++;
                return pitPlayer;
            }
        }
        catch (Exception msgs) {
            
        }
        return null;
    }
    
    public Player getPlayer (String PlayerID) throws Exception {
        /*
         * Takes a player ID as a parameter to then go through the new
         * ArrayList to identify the same player ID within the master
         * file of the and outputting the information of that player
         * to the user.
         */
        String foundPlayer = null;
        for (Player getPlayer : Roster) {
            for (int i = 0; i < Roster.size(); i++) {
                if (PlayerID.equals(getPlayer.getPlayerID()) == true) {
                    return getPlayer;
                }
            }
        }
        return null;
    }
    
    public ArrayList<Batter> getTopHomerunHittersSorted(int n) throws Exception {
        /*
         * Takes an input of the number of home run hitters wanted to
         * be sorted from the most to least amount of home runs from
         * the batter file and recognizing them through the master file to
         * then return them to the user.
         */
        
        ArrayList<Batter> batterHomeRun = new ArrayList <Batter>();
        
        int batterCount = 0;
        String batters = null;
        
        try {
            for (Player batPlayRoster : Roster) {
                batterHomeRun.add((Batter)batPlayRoster);
            }
            
        }
        catch (Exception excpt) {
            
        }
        
        Collections.sort(batterHomeRun, Collections.reverseOrder());
        
        try {
            while (batterCount < n) {
                for (int i = 0; i < batterHomeRun.size(); i++) {
                        if (batterHomeRun.get(i).compareTo(batterHomeRun.get(batterHomeRun.size() - 1)) == -1) {
                            batters += batterHomeRun.get(i).toString();
                            i++;
                        }
                }
                batterCount++;
                return batterHomeRun;
            }
        }
        catch (Exception msgs) {
            
        }
        return null;
    }
    
    public ArrayList<Pitcher> getLowestERASorted (int n) throws Exception {
        /*
         * Takes an input of the number of ERAs wanted to be sorted
         * to get the lowest ERAs from that particular amount of 
         * players inputted by the user, to which the player(s)
         * information is outputted.
         */
        
        ArrayList<Pitcher> pitchERA = new ArrayList <Pitcher>();
        int pitcherCount = 0;
        String pitcher = "";
        
        try {
            for (Player pitPlayRoster : Roster) {
                pitchERA.add((Pitcher)pitPlayRoster);
            }
            
        }
        catch (Exception excpt) {
            
        }
        
        Collections.sort(pitchERA, Collections.reverseOrder());
        
        try {
            while (pitcherCount < n) {
                for (int i = 0; i < pitchERA.size(); i++) {
                        if (pitchERA.get(i).compareTo(pitchERA.get(pitchERA.size() - 1)) == 1) {
                            pitcher += pitchERA.get(i).toString();
                            i++;
                        }
                }
                pitcherCount++;
                return pitchERA;
            }
        }
        catch (Exception msgs) {
            
        }
        return null;
    }
}
