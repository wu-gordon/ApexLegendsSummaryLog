package model;

public class EntryCostCalc {
    private static final int BRONZE_ENTRY = 0; // 0 RP upon entry
    private static final int SILVER_ENTRY = 12; // -12 RP upon entry
    private static final int GOLD_ENTRY = 24; // -24 RP upon entry
    private static final int PLATINUM_ENTRY = 36; // -36 RP upon entry
    private static final int DIAMOND_ENTRY = 48; // -48 RP upon entry
    private static final int MASTERS_PREDATOR_ENTRY = 60; // -60 RP upon entry

    public EntryCostCalc() {
        EntryCostCalc ec = new EntryCostCalc();
    }

    // REQUIRES: the player's current RP acquired in Bronze
    // MODIFIES: this
    // EFFECTS: applies the appropriate entry cost
    public int applyEntryCostBronze(int rp) {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Silver
    // MODIFIES: this
    // EFFECTS: applies the appropriate entry cost
    public int applyEntryCostSilver(int rp) {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Gold
    // MODIFIES: this
    // EFFECTS: applies the appropriate entry cost
    public int applyEntryCostGold(int rp) {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Platinum
    // MODIFIES: this
    // EFFECTS: applies the appropriate entry cost
    public int applyEntryCostPlatinum(int rp) {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Diamond
    // MODIFIES: this
    // EFFECTS: applies the appropriate entry cost
    public int applyEntryCostDiamond(int rp) {
        return 0; // stub
    }

    // REQUIRES: the player's current RP acquired in Masters/Predator
    // MODIFIES: this
    // EFFECTS: applies the appropriate entry cost
    public int applyEntryCostMastersPredator(int rp) {
        return 0; // stub
    }

    // EFFECTS: returns entry cost value
    public int getEntryCost() {
        return 0; // stub
    }
}
