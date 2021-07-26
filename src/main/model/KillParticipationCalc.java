package model;

import model.PlacementCalc;

public class KillParticipationCalc {
    private static final int MAX_KP = 6; // combined total of 6 Kills or Assists
    private static final int KILLS_ASSISTS = 1; // 1 KP = 1 Kill or Assist

    private static final int TEN_MULTIPLIER = 10; // KP * 10 RP
    private static final int TWELVE_MULTIPLIER = 12; // KP * 12 RP
    private static final int FIFTEEN_MULTIPLIER = 15; // KP * 15 RP
    private static final int TWENTY_MULTIPLIER = 20; // KP * 20 RP
    private static final int TWENTY_FIVE_MULTIPLIER = 25; // KP * 25 RP

    public KillParticipationCalc() {
        KillParticipationCalc kpc = new KillParticipationCalc();
    }

    // REQUIRES: a KP value (int a), and a placement value b
    // MODIFIES: this
    // EFFECTS: calculate total RP based on a combination of KP gained and placement
    public int kpWithPlacement(int a, PlacementCalc b) {
        return 0; // stub
    }
}
