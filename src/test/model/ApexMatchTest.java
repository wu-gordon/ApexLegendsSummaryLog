package model;

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

    @Test
    void testStorePlacement() {
        assertTrue(testMatch1.storePlacement(1));
        assertTrue(testMatch1.storePlacement(5));
        assertTrue(testMatch1.storePlacement(20));

        assertFalse(testMatch1.storePlacement(0));
        assertFalse(testMatch1.storePlacement(-1));
        assertFalse(testMatch1.storePlacement(21));
    }

    @Test
    void testStoreKillParticipation() {
        assertTrue(testMatch1.storeKillParticipation(0));
        assertTrue(testMatch1.storeKillParticipation(3));
        assertTrue(testMatch1.storeKillParticipation(6));

        assertFalse(testMatch1.storeKillParticipation(-1));
        assertFalse(testMatch1.storeKillParticipation(7));
    }

    @Test
    void testGetRank() {
        testMatch1.storeRankedDivision("bronze");

        assertEquals("bronze", testMatch1.getRank());
    }

    @Test
    void testGetPlacement() {
        testMatch1.storePlacement(1);

        assertEquals(1, testMatch1.getPlacement());
    }

    @Test
    void testGetKp() {
        testMatch1.storeKillParticipation(6);

        assertEquals(6, testMatch1.getKp());
    }

    @Test
    void testSetRp() {
        testMatch1.storeRankedDivision("bronze");
        testMatch1.storePlacement(1);
        testMatch1.storeKillParticipation(6);
        testMatch1.setRp(rpCalc.calculateRankEntryCost(testMatch1.getRank(), testMatch1.getPlacement(),
                testMatch1.getKp()));

        assertEquals("Division: " + "bronze" + "\n" + "Placement: " + 1 + "\n" + "Kill Participation (KP): "
                + 6 + "\n" + "Ranked Points (RP): " + 250 + "\n", testMatch1.toString());
    }

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

    @Test
    void testToString() {
        testMatch1.storeRankedDivision("gold");
        testMatch1.storePlacement(5);
        testMatch1.storeKillParticipation(3);
        testMatch1.setRp(rpCalc.calculateRankEntryCost(testMatch1.getRank(), testMatch1.getPlacement(),
                testMatch1.getKp()));

        assertEquals("Division: " + "gold" + "\n" + "Placement: " + 5 + "\n" + "Kill Participation (KP): "
                + 3 + "\n" + "Ranked Points (RP): " + 51 + "\n", testMatch1.toString());
    }
}


