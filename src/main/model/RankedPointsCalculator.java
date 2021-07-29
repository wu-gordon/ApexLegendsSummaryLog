package model;

import model.ApexMatch;

import java.util.ArrayList;
import java.util.HashMap;

// a ranked points (RP) calculator created once per ranked session that calculates your RP amount based on
// rank division, placement, and kill participation (KP)
public class RankedPointsCalculator {
    private final HashMap<String, Integer> rankEntryCost;
    private final HashMap<Integer, Integer[]> placementKpMultiplier;

    private Integer[] placementRpAndKpMultiplier;
    private Integer[] fiveAndTen;
    private Integer[] tenAndTwelve;
    private Integer[] twentyAndTwelve;

    public RankedPointsCalculator() {
        rankEntryCost = new HashMap<>();
        placementKpMultiplier = new HashMap<>();

        fiveAndTen = new Integer[]{5, 10};
        tenAndTwelve = new Integer[]{10, 12};
        twentyAndTwelve = new Integer[]{20, 12};

        rankEntryCostMap();
        placementKPMultiplierMap();
    }

    public void rankEntryCostMap() {
        // Add keys and values (Rank Division, Entry Cost)
        rankEntryCost.put("bronze", 0);
        rankEntryCost.put("silver", -12);
        rankEntryCost.put("gold", -24);
        rankEntryCost.put("platinum", -36);
        rankEntryCost.put("diamond", -48);
        rankEntryCost.put("masters/predator", -60);
    }

    public void placementKPMultiplierMap() {
        // Add keys and values (Placement, (RP from placement, KP multiplier))
        placementKpMultiplier.put(14, new Integer[]{0, 10});
        placementKpMultiplier.put(13, fiveAndTen);
        placementKpMultiplier.put(12, fiveAndTen);
        placementKpMultiplier.put(11, fiveAndTen);
        placementKpMultiplier.put(10, tenAndTwelve);
        placementKpMultiplier.put(9, tenAndTwelve);
        placementKpMultiplier.put(8, twentyAndTwelve);
        placementKpMultiplier.put(7, twentyAndTwelve);
        placementKpMultiplier.put(6, new Integer[]{30, 12});
        placementKpMultiplier.put(5, new Integer[]{30, 15});
        placementKpMultiplier.put(4, new Integer[]{40, 15});
        placementKpMultiplier.put(3, new Integer[]{40, 20});
        placementKpMultiplier.put(2, new Integer[]{60, 20});
        placementKpMultiplier.put(1, new Integer[]{100, 25});
    }

    public int calculateRankEntryCost(String rankDivision, int placement, int killsAssists) {
        int entryCost = rankEntryCost.get(rankDivision);
        placementRpAndKpMultiplier = placementKpMultiplier.get(placement);

        if (placement >= 14) {
            rankEntryCost.get("bronze");
        }
        return entryCost + placementRpAndKpMultiplier[0] + (killsAssists * placementRpAndKpMultiplier[1]);
    }
}
