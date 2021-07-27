//testing for push because github isn't seeing my most recent pushes
package model;

// a match log that is created per ranked session where all apex match data will be stored
import java.util.ArrayList;

public class MatchLog {
    private final ArrayList<ApexMatch> matches;

    public MatchLog() {
        matches = new ArrayList<>();
    }

    // EFFECTS: adds the match to a list of apex matches
    public void addToList(ApexMatch match) {
        matches.add(match);
    }

    public ArrayList<ApexMatch> getMatches() {
        return matches;
    }

    // EFFECTS: for each apex match in the list of matches, the data will be printed in a single log for the
    //          player to visualize their ranked session progress
    public void printSummaryLog() {
        for (ApexMatch match : matches) {
            System.out.println(match);
        }
    }
}
