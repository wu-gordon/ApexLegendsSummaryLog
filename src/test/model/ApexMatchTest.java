package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for ApexMatch Class
public class ApexMatchTest {
    private ApexMatch testMatch1;
    private ApexMatch testMatch2;
    private ApexMatch testMatch3;
    private ApexMatch testMatch4;


    @BeforeEach
    void runBefore() {
        testMatch1 = new ApexMatch("Bronze", 0,0,0);
        testMatch2 = new ApexMatch("Bronze", 20, 0, 0);
        testMatch3 = new ApexMatch("Diamond", 1, 6, 202);
        testMatch4 = new ApexMatch("Masters/Predator",1, 6, 190);
    }

    @Test
    void testToStringValid() {
        assertTrue(testMatch1.toString().contains("Division: " + "Bronze" + "\n" + "Placement: " + 0 + "\n"
                + "Kill Participation (KP): " + 0 + "\n" + "Ranked Points (RP): " + 0 + "\n"));
        assertTrue(testMatch2.toString().contains("Division: " + "Bronze" + "\n" + "Placement: " + 20 + "\n"
                + "Kill Participation (KP): " + 0 + "\n" + "Ranked Points (RP): " + 0 + "\n"));
        assertTrue(testMatch3.toString().contains("Division: " + "Diamond" + "\n" + "Placement: " + 1 + "\n"
                + "Kill Participation (KP): " + 6 + "\n" + "Ranked Points (RP): " + 202 + "\n"));
        assertTrue(testMatch4.toString().contains("Division: " + "Masters/Predator" + "\n" + "Placement: " + 1 + "\n"
                + "Kill Participation (KP): " + 6 + "\n" + "Ranked Points (RP): " + 190 + "\n"));
    }

    @Test
    void testToStringInvalid() {
        assertFalse(testMatch1.toString().contains("Division: " + "Bronze" + "\n" + "Placement: " + 21 + "\n"
                + "Kill Participation (KP): " + 0 + "\n" + "Ranked Points (RP): " + 0 + "\n"));
        assertFalse(testMatch1.toString().contains("Division: " + "Bronze" + "\n" + "Placement: " + 20 + "\n"
                + "Kill Participation (KP): " + 7 + "\n" + "Ranked Points (RP): " + 0 + "\n"));
        assertFalse(testMatch1.toString().contains("Division: " + "Bronze" + "\n" + "Placement: " + 20 + "\n"
                + "Kill Participation (KP): " + 0 + "\n" + "Ranked Points (RP): " + 251 + "\n"));
        assertFalse(testMatch1.toString().contains("Division: " + "Bronze" + "\n" + "Placement: " + 20 + "\n"
                + "Kill Participation (KP): " + -1 + "\n" + "Ranked Points (RP): " + 0 + "\n"));
    }
}


