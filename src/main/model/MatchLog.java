package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// An Apex match history log of where all Apex matches and its corresponding game data will be stored
public class MatchLog implements Writable {
    private final ArrayList<ApexMatch> matches;

    // EFFECTS: creates an array list instance
    public MatchLog() {
        matches = new ArrayList<>();
    }

    // EFFECTS: adds the Apex match to the match log
    public void addToList(ApexMatch match) {
        matches.add(match);
    }

    // EFFECTS: returns the list of Apex matches
    public ArrayList<ApexMatch> getMatches() {
        return matches;
    }

    // EFFECTS: adds an Apex match to the list of matches
    public void addApexMatch(ApexMatch apexMatch) {
        matches.add(apexMatch);
    }

    // EFFECTS: returns the size of the list
    public int numMatches() {
        return matches.size();
    }

    // REQUIRES: response option 4 in display menu
    // EFFECTS: for each apex match in the list of matches, the data will be printed in a single log for the
    //          player to visualize their ranked session progress
    public void printSummaryLog() {
        for (ApexMatch match : matches) {
            System.out.println(match);
        }
    }

    // EFFECTS: creates a json object with a name for the file
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Apex matches", matchesToJson());
        return json;
    }

    // EFFECTS: returns things in this match log as a JSON array
    public JSONArray matchesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (ApexMatch apexMatch : matches) {
            jsonArray.put(apexMatch.toJson());
        }

        return jsonArray;
    }
}
