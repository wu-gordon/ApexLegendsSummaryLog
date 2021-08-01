package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for MatchLog class
class MatchLogTest {
    private ApexMatch apexMatch;
    private MatchLog matchSummary;
    private ArrayList<ApexMatch> apexMatchList;

    @BeforeEach
    void runBefore() {
        apexMatch = new ApexMatch();
        matchSummary = new MatchLog();
        apexMatchList = new ArrayList<>();
    }

    @Test
    void testAddToList() {
        apexMatch.storeRankedDivision("bronze");
        apexMatchList.add(apexMatch);
        matchSummary.addToList(apexMatch);
        apexMatchList = matchSummary.getMatches();

        assertEquals("bronze", apexMatchList.get(0).getRank());
    }

    @Test
    void testGetMatches() {
        apexMatchList.add(apexMatch);
        matchSummary.addToList(apexMatch);
        apexMatchList = matchSummary.getMatches();

        assertEquals(apexMatchList, matchSummary.getMatches());
    }

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
}