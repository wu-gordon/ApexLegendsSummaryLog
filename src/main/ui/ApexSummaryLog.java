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
    //          while true in the do-while loop, a new match entry will be created every time "yes" is selected
    //          by the player, until "no" is selected which will break the loop and a summary log gets printed to
    //          complete the session
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

    // REQUIRES: the apex match that was instantiated in consoleStart()
    // MODIFIES: this
    // EFFECTS: stores ranked division data for the apex match
    //          while true in the do-while loop, if any of the answers submitted match the appropriate ranks
    //          (non-case sensitive), the data will be stored, otherwise a typo will break the loop and
    //          prompt an invalid response message
    public void selectRankDivision(ApexMatch apexMatch) {
        do {
            System.out.println("Please select your appropriate ranked division:");
            System.out.println("[Bronze, Silver, Gold, Platinum, Diamond, Masters/Predator]\n");

            String rank = in.nextLine();
            rank = rank.toLowerCase();
            System.out.println("You entered " + rank);

            if (rank.equals("bronze") || rank.equals("silver") || rank.equals("gold") || rank.equals("platinum")
                    || rank.equals("diamond") || rank.equals("masters/predator")) {
                apexMatch.storeRankedDivision(rank);
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: the apex match that was instantiated in consoleStart()
    // MODIFIES: this
    // EFFECTS: stores placement data for the apex match
    //          while true in the do-while loop, if any of the answers submitted match the appropriate placement
    //          range (symbolizing 20 teams of 3), the data will be stored, otherwise a value outside of the range
    //          will break the loop and prompt an invalid response message
    public void insertPlacement(ApexMatch apexMatch) {
        do {
            System.out.println("Please enter your placement:\n");

            int placement = in.nextInt();
            System.out.println("You entered " + placement);

            if (placement <= 20) {
                apexMatch.storePlacement(placement);
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: the apex match that was instantiated in consoleStart()
    // MODIFIES: this
    // EFFECTS: stores kill participation data for the apex match
    //          while true in the do-while loop, if any of the answers submitted match the appropriate kp
    //          range (symbolizing max kp = 6), the data will be stored, otherwise a value outside of the range
    //          will break the loop and prompt an invalid response message
    public void insertKillParticipation(ApexMatch apexMatch) {
        do {
            System.out.println("Please enter your kill participation (KP):\n");

            int killParticipation = in.nextInt();
            System.out.println("You entered " + killParticipation);

            if (killParticipation <= 6) {
                apexMatch.storeKillParticipation(killParticipation);
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }

    // REQUIRES: the apex match that was instantiated in consoleStart()
    // MODIFIES: this
    // EFFECTS: stores ranked points data for the apex match
    //          while true in the do-while loop, if any of the answers submitted match the appropriate rp
    //          range (symbolizing the max amount of rp possible in the game), the data will be stored, otherwise
    //          a value outside of the range will break the loop and prompt an invalid response message
    public void insertRankedPoints(ApexMatch apexMatch) {
        do {
            System.out.println("Please enter your RP gain/loss:\n");

            int rankedPoints = in.nextInt();
            System.out.println("You entered " + rankedPoints);

            if (rankedPoints <= 250) {
                apexMatch.storeRankedPoints(rankedPoints);
                break;
            }
            System.out.println("Invalid response");
        } while (true);
    }
}
