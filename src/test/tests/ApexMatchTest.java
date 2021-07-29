package tests;

import model.ApexMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for ApexMatch Class
public class ApexMatchTest {
    private ApexMatch testMatch1;

    @BeforeEach
    void runBefore() {
        testMatch1 = new ApexMatch();
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
        assertTrue(testMatch1.storePlacement(0));
        assertTrue(testMatch1.storePlacement(5));
        assertTrue(testMatch1.storePlacement(20));

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
    void testToString() {
        testMatch1.storeRankedDivision("Gold");
        testMatch1.storePlacement(5);
        testMatch1.storeKillParticipation(3);

//        assertEquals("Division: " + "gold" + "\n" + "Placement: " + 5 + "\n" + "Kill Participation (KP): "
//                + 3 + "\n" + "Ranked Points (RP): " + 75 + "\n", testMatch1.toString());
    }
}


