package model;

// a match log created once per ranked session where all apex match data will be stored
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class MatchLog implements Writable {
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

    public void addApexMatch(ApexMatch apexMatch) {
        matches.add(apexMatch);
    }

    public int numMatches() {
        return matches.size();
    }

    // EFFECTS: for each apex match in the list of matches, the data will be printed in a single log for the
    //          player to visualize their ranked session progress
    public void printSummaryLog() {
        for (ApexMatch match : matches) {
            System.out.println(match);
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Apex matches", matchesToJson());
        return json;
    }

    public JSONArray matchesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (ApexMatch apexMatch : matches) {
            jsonArray.put(apexMatch.toJson());
        }

        return jsonArray;
    }
}
