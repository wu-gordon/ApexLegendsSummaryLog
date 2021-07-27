package model;

public class RankDivisionRangeCalc {
    private static final int BRONZE_MIN = 0; // Bronze 4; 0 RP
    private static final int BRONZE_MAX = 1199; // Bronze 1; 1 RP from Silver 4

    private static final int SILVER_MIN = 1200; // Silver 4; 1200 RP
    private static final int SILVER_MAX = 2799; // Silver 1; 1 RP from Gold 4

    private static final int GOLD_MIN = 2800; // Gold 4; 2800 RP
    private static final int GOLD_MAX = 4799; // Gold 1; 1 RP from Platinum 4

    private static final int PLATINUM_MIN = 4800; // Platinum 4; 4800 RP
    private static final int PLATINUM_MAX = 7199; // Platinum 1; 1 RP from Diamond 4

    private static final int DIAMOND_MIN = 7200; // Diamond 4; 7200 RP
    private static final int DIAMOND_MAX = 9999; // Diamond 1; 1 RP from Masters/Predator

    private static final int MASTERS_PREDATOR_MIN = 10000; // Masters/Predator only requires min; no max

    public RankDivisionRangeCalc() {
        RankDivisionRangeCalc rdc = new RankDivisionRangeCalc();
    }

    // REQUIRES: the player's current RP acquired in Bronze
    // MODIFIES: this
    // EFFECTS: promotes player to Silver
    public int rankPromotionFromBronze() {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Silver
    // MODIFIES: this
    // EFFECTS: promotes player to Gold
    public int rankPromotionFromSilver() {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Gold
    // MODIFIES: this
    // EFFECTS: promotes player to Platinum
    public int rankPromotionFromGold() {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Platinum
    // MODIFIES: this
    // EFFECTS: promotes player to Diamond
    public int rankPromotionFromPlatinum() {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Diamond
    // MODIFIES: this
    // EFFECTS: promotes player to Masters/Predator
    public int rankPromotionFromDiamond() {
        return 0; // stub
    }
}
