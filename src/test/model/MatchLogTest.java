package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for MatchLog class
class MatchLogTest {
    private String rank;
    private int placement;
    private int kp;
    private int rp;

    private ApexMatch apexMatch;
    private MatchLog matchSummary;
    private ArrayList<ApexMatch> apexMatchList;

    @BeforeEach
    void runBefore() {
        rank = "";
        placement = 0;
        kp = 0;
        rp = 0;

        apexMatch = new ApexMatch();
        matchSummary = new MatchLog();
        apexMatchList = new ArrayList<>();
    }

    // checks the added Apex match in the match log
    @Test
    void testAddToList() {
        apexMatch.storeRankedDivision("bronze");
        apexMatchList.add(apexMatch);
        matchSummary.addToList(apexMatch);
        apexMatchList = matchSummary.getMatches();

        assertEquals("bronze", apexMatchList.get(0).getRank());
    }

    // checks the matches placed in the Apex match list
    @Test
    void testGetMatches() {
        apexMatchList.add(apexMatch);
        matchSummary.addToList(apexMatch);
        apexMatchList = matchSummary.getMatches();

        assertEquals(apexMatchList, matchSummary.getMatches());
    }

    // checks the Apex match data
    @Test
    void testAddApexMatch() {
        apexMatchList.add(new ApexMatch("bronze", 1, 6, 250));
        assertEquals("bronze", apexMatchList.get(0).getRank());
        assertEquals(1, apexMatchList.get(0).getPlacement());
        assertEquals(6, apexMatchList.get(0).getKp());
    }

    // checks the size of the match log
    @Test
    void testNumMatches() {
        assertEquals(0, matchSummary.numMatches());
    }

    // checks the added Apex match data and what it prints to the console
    @Test
    void testPrintSummaryLog() {
        apexMatch.storeRankedDivision("bronze");
        apexMatch.storePlacement(1);
        apexMatch.storeKillParticipation(6);

        apexMatchList.add(apexMatch);
        matchSummary.addToList(apexMatch);

        System.out.println("expected: \n");
        System.out.println(apexMatch.toString());
        System.out.println("actual: \n");
        matchSummary.printSummaryLog();
    }

    // checks the name of the JSON file
    @Test
    void testToJson() {
        JSONObject json = new JSONObject();
        json.put("Apex matches", matchSummary);

        assertEquals(matchSummary, json.get("Apex matches"));
    }

    // checks the information inputted into the JSON file
    @Test
    void testMatchesToJson() {
        JSONArray jsonArray = new JSONArray();
        ApexMatch apexMatch = new ApexMatch(rank, placement, kp, rp);
        matchSummary.addApexMatch(apexMatch);

        JSONObject json = new JSONObject();
        jsonArray.put(apexMatch.toJson());
        json.put("rank", "bronze");
        json.put("placement", 1);
        json.put("kp", 6);
        json.put("rp", 250);
        json.put("Apex matches", jsonArray);

        assertEquals(matchSummary.toJson().getJSONArray("Apex matches").getJSONObject(0).get("rank"),
                json.getJSONArray("Apex matches").getJSONObject(0).get("rank"));
        assertEquals(matchSummary.toJson().getJSONArray("Apex matches").getJSONObject(0).get("placement"),
                json.getJSONArray("Apex matches").getJSONObject(0).get("placement"));
        assertEquals(matchSummary.toJson().getJSONArray("Apex matches").getJSONObject(0).get("kp"),
                json.getJSONArray("Apex matches").getJSONObject(0).get("kp"));
        assertEquals(matchSummary.toJson().getJSONArray("Apex matches").getJSONObject(0).get("rp"),
                json.getJSONArray("Apex matches").getJSONObject(0).get("rp"));
    }
}