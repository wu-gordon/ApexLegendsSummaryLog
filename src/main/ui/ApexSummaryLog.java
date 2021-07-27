//testing for push because github isn't seeing my most recent pushes
package ui;

import model.*;

import java.util.Scanner;

// main console application
public class ApexSummaryLog {

    private static Scanner in;

    public ApexSummaryLog() {
        in = new Scanner(System.in);
        System.out.println("Are you ready to begin your ranked session?");
        consoleStart();
    }

    // EFFECTS: a new match log is created per session where all apex match data will be stored
    //
    //          while true, a new match entry will be created every time "yes" is selected by the player, until
    //          "no" is selected which will break the loop and a summary log gets printed to complete the session
    public void consoleStart() {
        MatchLog matches = new MatchLog();

        do {
            ApexMatch apexMatch = new ApexMatch();

            selectRankDivision(apexMatch);
            insertPlacement(apexMatch);
            insertKillParticipation(apexMatch);
            insertRankedPoints(apexMatch);

            matches.addToList(apexMatch);
            System.out.println("Would you like to add data for a new match?");
            System.out.println("[Yes/No]\n");
            in.nextLine();
            String response = in.nextLine();
            System.out.println("You entered " + response);

            response = response.toLowerCase();

            if (response.equals("no")) {
                break;
            }
        } while (true);
        matches.printSummaryLog();
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

            int killParticipation = in.nextInt();
            System.out.println("You entered " + killParticipation);

            boolean result = apexMatch.storeKillParticipation(killParticipation);
            if (result) {
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: a ranked points (RP) value
    // MODIFIES: this, apexMatch
    // EFFECTS: stores ranked points data for the apex match
    //
    //          while true, the inserted RP value will call upon its respective method in ApexMatch
    //          (storeRankedPoints) where it will confirm the appropriate RP range. If the result is true,
    //          the loop will break and prompt the next message, otherwise it will prompt an invalid response
    public void insertRankedPoints(ApexMatch apexMatch) {
        do {
            System.out.println("Please enter your RP gain/loss:\n");

            int rankedPoints = in.nextInt();
            System.out.println("You entered " + rankedPoints);

            boolean result = apexMatch.storeRankedPoints(rankedPoints);
            if (result) {
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }
}
