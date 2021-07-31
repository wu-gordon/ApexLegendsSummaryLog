package tests;

import model.RankedPointsCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RankedPointsCalculatorTest {
    private HashMap<String, Integer> rankEntryCost;
    private HashMap<Integer, Integer[]> placementKpMultiplier;

    private RankedPointsCalculator rpCalc;

    @BeforeEach
    void runBefore() {
        rankEntryCost = new HashMap<>();
        placementKpMultiplier = new HashMap<>();
    }

    @Test
    void testRankEntryCostMap() {
        String rankDivision = "bronze";
        int entryCost = 0;
        rankEntryCost.put("bronze", 0);

        assertEquals(entryCost, rankEntryCost.get(rankDivision));
    }

    @Test
    void testPlacementKPMultiplierMap() {
        int placement = 1;
        Integer[] kpMultiplier = new Integer[]{100, 25};
        placementKpMultiplier.put(1, kpMultiplier);

        assertEquals(kpMultiplier, placementKpMultiplier.get(placement));
    }

    @Test
    void testCalculateRankEntryCost() {
        rpCalc = new RankedPointsCalculator();
    }
}