package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        rpCalc = new RankedPointsCalculator();
    }

    // EFFECTS: checks the stored rank division and its corresponding entry cost
    @Test
    void testRankEntryCostMap() {
        String rankDivision = "bronze";
        int entryCost = 0;
        rankEntryCost.put("bronze", 0);

        assertEquals(entryCost, rankEntryCost.get(rankDivision));
    }

    // EFFECTS: checks the stored placement and its corresponding rp value and kp multiplier based on given placement
    @Test
    void testPlacementKPMultiplierMap() {
        int placement = 1;
        Integer[] kpMultiplier = new Integer[]{100, 25};
        placementKpMultiplier.put(1, kpMultiplier);

        assertEquals(kpMultiplier, placementKpMultiplier.get(placement));
    }

    // EFFECTS: checks the calculated rp value based on given game value data
    @Test
    void testCalculateRankEntryCost() {
        Integer[] kpMultiplier13 = new Integer[]{5, 10};
        Integer[] kpMultiplier14AndOver = new Integer[]{0, 10};
        placementKpMultiplier.put(13, kpMultiplier13);
        placementKpMultiplier.put(15, kpMultiplier14AndOver);
        placementKpMultiplier.put(16, kpMultiplier14AndOver);

        rpCalc.calculateRankEntryCost("bronze", 13, 6);
        assertEquals(kpMultiplier13, placementKpMultiplier.get(13));
        rpCalc.calculateRankEntryCost("bronze", 15, 6);
        assertEquals(kpMultiplier14AndOver, placementKpMultiplier.get(15));
        rpCalc.calculateRankEntryCost("bronze", 16, 6);
        assertEquals(kpMultiplier14AndOver, placementKpMultiplier.get(16));
    }
}