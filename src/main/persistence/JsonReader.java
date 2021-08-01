package persistence;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import model.ApexMatch;
import model.MatchLog;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public MatchLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMatchLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses match log from JSON object and returns it
    private MatchLog parseMatchLog(JSONObject jsonObject) {
        MatchLog matchLog = new MatchLog();
        addMatches(matchLog, jsonObject);
        return matchLog;
    }

    // MODIFIES: wr
    // EFFECTS: parses matches from JSON object and adds them to workroom
    private void addMatches(MatchLog matchLog, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Apex matches");
        for (Object json : jsonArray) {
            JSONObject nextMatch = (JSONObject) json;
            addApexMatch(matchLog, nextMatch);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses matches from JSON object and adds it to workroom
    private void addApexMatch(MatchLog matchLog, JSONObject jsonObject) {
        String rank = jsonObject.getString("rank");
        int placement = jsonObject.getInt("placement");
        int kp = jsonObject.getInt("kp");
        int rp = jsonObject.getInt("rp");
        ApexMatch apexMatch = new ApexMatch(rank, placement, kp, rp);

        matchLog.addApexMatch(apexMatch);
    }
}
