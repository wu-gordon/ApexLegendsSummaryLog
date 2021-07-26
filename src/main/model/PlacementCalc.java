package model;

import model.EntryCostCalc;

public class PlacementCalc {
    private static final int FOURTEENTH_AND_ABOVE = 0; // no RP gain
    private static final int THIRTEENTH_TO_ELEVENTH = 5; // +5 RP
    private static final int TENTH_TO_NINTH = 10; // +10 RP
    private static final int EIGHTH_TO_SEVENTH = 20; // +20 RP
    private static final int SIXTH_TO_FIFTH = 30; // +30 RP
    private static final int FOURTH_TO_THIRD = 40; // +40 RP
    private static final int SECOND = 60; // +60 RP
    private static final int FIRST = 100; // +100 RP

    public PlacementCalc() {
        PlacementCalc pc = new PlacementCalc();
    }

    // REQUIRES: a placement value denoted by int i, and an entry cost value for the appropriate rank division
    // MODIFIES: this
    // EFFECTS: calculate placement RP gain/loss
    public int placementPoints(int i, EntryCostCalc ecc) {
        return 0; // stub
    }

    // EFFECTS: returns RP value based on placement
    public int getPlacementRP() {
        return 0; // stub
    }
}
