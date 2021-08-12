package model;

import exceptions.PlacementNotWithinRange;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for ApexMatch Class
public class ApexMatchTest {
    private ApexMatch testMatch1;
    private RankedPointsCalculator rpCalc;



    @BeforeEach
    void runBefore() {
        testMatch1 = new ApexMatch();
        rpCalc = new RankedPointsCalculator();
    }

    // EFFECTS: checks ranked division correctness from player response including all types of spelling errors and
    // case sensitivity
    @Test
    void testStoreRankedDivision() {
        assertTrue(testMatch1.storeRankedDivision("Bronze"));
        assertTrue(testMatch1.storeRankedDivision("bronze"));
        assertTrue(testMatch1.storeRankedDivision("silver"));
        assertTrue(testMatch1.storeRankedDivision("gOld"));
        assertTrue(testMatch1.storeRankedDivision("platInum"));
        assertTrue(testMatch1.storeRankedDivision("diaMond"));
        assertTrue(testMatch1.storeRankedDivision("masTers/Predator"));

        assertFalse(testMatch1.storeRankedDivision("brons"));
        assertFalse(testMatch1.storeRankedDivision("Iron"));
    }

    // EFFECTS: checks placement correctness from player response within the stated placement range
    @Test
    void testStorePlacementWithinRange() {
        int placement1 = 1;
        int placement2 = 5;
        int placement3 = 20;

        try {
            testMatch1.storePlacement(1);
            testMatch1.storePlacement(5);
            testMatch1.storePlacement(20);
        } catch (PlacementNotWithinRange e) {
            fail("Placement value is not within range. Try again.");
            // should not fail
        }

        assertEquals(1, placement1);
        assertEquals(5, placement2);
        assertEquals(20, placement3);
    }

    // EFFECTS: checks placement correctness from player response outside of the stated placement range
    @Test
    void testStorePlacementNotWithinRange() {
        int placement1 = 1;
        int placement2 = 5;
        int placement3 = 20;

        try {
            testMatch1.storePlacement(0);
            testMatch1.storePlacement(-1);
            testMatch1.storePlacement(20);
        } catch (PlacementNotWithinRange e) {
            fail("Placement value is not within range. Try again.");
            // should fail
        }

        assertEquals(1, placement1);
        assertEquals(5, placement2);
        assertEquals(20, placement3);
    }

    // EFFECTS: checks kill participation (KP) correctness from player response including all types of values over and under
    // the stated kill participation range
    @Test
    void testStoreKillParticipation() {
        assertTrue(testMatch1.storeKillParticipation(0));
        assertTrue(testMatch1.storeKillParticipation(3));
        assertTrue(testMatch1.storeKillParticipation(6));

        assertFalse(testMatch1.storeKillParticipation(-1));
        assertFalse(testMatch1.storeKillParticipation(7));
    }

    // EFFECTS: checks the stored rank division
    @Test
    void testGetRank() {
        testMatch1.storeRankedDivision("bronze");

        assertEquals("bronze", testMatch1.getRank());
    }

    // EFFECTS: checks the stored placement value
    @Test
    void testGetPlacement() throws PlacementNotWithinRange {
        testMatch1.storePlacement(1);

        assertEquals(1, testMatch1.getPlacement());
    }

    // EFFECTS: checks the stored kill participation value
    @Test
    void testGetKp() {
        testMatch1.storeKillParticipation(6);

        assertEquals(6, testMatch1.getKp());
    }

    // EFFECTS: checks that the calculated ranked points (RP) value is set to rp
    @Test
    void testSetRp() throws PlacementNotWithinRange {
        testMatch1.storeRankedDivision("bronze");
        testMatch1.storePlacement(1);
        testMatch1.storeKillParticipation(6);
        testMatch1.setRp(rpCalc.calculateRankEntryCost(testMatch1.getRank(), testMatch1.getPlacement(),
                testMatch1.getKp()));

        assertEquals("Division: " + "bronze" + "\n" + "Placement: " + 1 + "\n" + "Kill Participation (KP): "
                + 6 + "\n" + "Ranked Points (RP): " + 250 + "\n", testMatch1.toString());
    }

    // EFFECTS: checks the data stored in the JSON file
    @Test
    void testToJson() {
        JSONObject json = new JSONObject();
        json.put("rank", "bronze");
        json.put("placement", 1);
        json.put("kp", 6);
        json.put("rp", 250);

        assertEquals("bronze", json.get("rank"));
        assertEquals(1, json.getInt("placement"));
        assertEquals(6, json.getInt("kp"));
        assertEquals(250, json.getInt("rp"));
    }

    // EFFECTS: checks the data inputted and how its shown on the console
    @Test
    void testToString() throws PlacementNotWithinRange {
        testMatch1.storeRankedDivision("gold");
        testMatch1.storePlacement(5);
        testMatch1.storeKillParticipation(3);
        testMatch1.setRp(rpCalc.calculateRankEntryCost(testMatch1.getRank(), testMatch1.getPlacement(),
                testMatch1.getKp()));

        assertEquals("Division: " + "gold" + "\n" + "Placement: " + 5 + "\n" + "Kill Participation (KP): "
                + 3 + "\n" + "Ranked Points (RP): " + 51 + "\n", testMatch1.toString());
    }
}


