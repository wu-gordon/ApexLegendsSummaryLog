package ui;

import model.ApexMatch;
import model.MatchLog;
import model.RankedPointsCalculator;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// main console Apex summary log application
public class ApexSummaryLog {

    private MatchLog matches;
    private RankedPointsCalculator rpCalc;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/matchLog.json";

    public ApexSummaryLog() {
        matches = new MatchLog();
        rpCalc = new RankedPointsCalculator();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        System.out.println("Your ranked session has begun!");
        consoleStart();
    }

    // EFFECTS: starts the application; main hub for the application
    //          while true, options will be displayed followed by a player response.
    //          depending on the response, the player will be asked to input the appropriate game data values.
    //          if anything other than the given response options is inputted, an "Invalid response" message
    //          will be prompted, allowing the player to re-enter their response
    //
    //          *response option 5 of the display menu breaks out of the loop and quits the application*
    public void consoleStart() {
        do {
            displayMenu();
            Scanner in = new Scanner(System.in);
            int response = in.nextInt();
            System.out.println("You entered " + response);

            if (response == 1) {
                addRankedGameData();
            } else if (response == 2) {
                saveApexMatchesLog();
            } else if (response == 3) {
                loadMatchHistoryData();
            } else if (response == 4) {
                matches.printSummaryLog();
            } else if (response == 5) {
                break;
            } else {
                System.out.println("Invalid response");
            }
        } while (true);
    }

    // EFFECTS: displays menu of options to the player
    public void displayMenu() {
        System.out.println("\nPlease select from the following options:");
        System.out.println("\t1 -> ADD ranked game data");
        System.out.println("\t2 -> SAVE Apex matches to file");
        System.out.println("\t3 -> LOAD match history data");
        System.out.println("\t4 -> PRINT match history data");
        System.out.println("\t5 -> QUIT");
    }

    // REQUIRES: response option 1 from display menu
    // MODIFIES: this
    // EFFECTS: a new Apex match will be created requesting for the following game data values.
    //          the player will then be asked to select their rank, placement, and kill participation values.
    //          once inputted, a ranked points (RP) value will be produced, and the match will then be added/saved
    //          to the list of Apex matches
    public void addRankedGameData() {
        ApexMatch apexMatch = new ApexMatch();

        selectRankDivision(apexMatch);
        insertPlacement(apexMatch);
        insertKillParticipation(apexMatch);

        apexMatch.setRp(rpCalc.calculateRankEntryCost(apexMatch.getRank(),
                apexMatch.getPlacement(), apexMatch.getKp()));

        matches.addToList(apexMatch);
    }

    // REQUIRES: a ranked division
    // MODIFIES: this, apexMatch
    // EFFECTS: stores ranked division data for the apex match
    //
    //          while true, the submitted rank division will call upon its respective method in ApexMatch
    //          (storeRankedDivision) where it will confirm the selection and spelling. If the result is true,
    //          the loop will break and prompt the next message, otherwise it will prompt an invalid response
    public void selectRankDivision(ApexMatch apexMatch) {
        do {
            System.out.println("Please select your appropriate ranked division:");
            System.out.println("[Bronze, Silver, Gold, Platinum, Diamond, Masters/Predator]\n");

            Scanner in = new Scanner(System.in);
            String rank = in.nextLine();
            System.out.println("You entered " + rank);

            boolean result = apexMatch.storeRankedDivision(rank);
            if (result) {
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: a placement value
    // MODIFIES: this, apexMatch
    // EFFECTS: stores placement data for the apex match
    //
    //          while true, the submitted placement value will call upon its respective method in ApexMatch
    //          (storePlacement) where it will confirm the the appropriate placement range. If the result is true,
    //          the loop will break and prompt the next message, otherwise it will prompt an invalid response
    public void insertPlacement(ApexMatch apexMatch) {
        do {
            System.out.println("Please enter your placement:\n");

            Scanner in = new Scanner(System.in);
            int placement = in.nextInt();
            System.out.println("You entered " + placement);

            boolean result = apexMatch.storePlacement(placement);
            if (result) {
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: a kill participation (KP) value
    // MODIFIES: this, apexMatch
    // EFFECTS: stores kill participation data for the apex match
    //
    //          while true, the inserted KP value will call upon its respective method in ApexMatch
    //          (storeKillParticipation) where it will confirm the appropriate KP range. If the result is true,
    //          the loop will break and prompt the next message, otherwise it will prompt an invalid response
    public void insertKillParticipation(ApexMatch apexMatch) {
        do {
            System.out.println("Please enter your kill participation (KP):\n");

            Scanner in = new Scanner(System.in);
            int killParticipation = in.nextInt();
            System.out.println("You entered " + killParticipation);

            boolean result = apexMatch.storeKillParticipation(killParticipation);
            if (result) {
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: response option 2 from display menu
    // EFFECTS: saves the list of Apex matches to file
    public void saveApexMatchesLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(matches);
            jsonWriter.close();

            JSONObject jsonObject = new JSONObject();
            System.out.println("Saved all Apex matches to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // REQUIRES: response option 3 from display menu
    // MODIFIES: this
    // EFFECTS: loads the list of Apex matches from file
    public void loadMatchHistoryData() {
        try {
            matches = jsonReader.read();
            System.out.println("Loaded all Apex matches from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
