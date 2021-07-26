package model;

import model.EntryCostCalc;
import model.KillParticipationCalc;
import model.PlacementCalc;
import model.RankDivisionRangeCalc;

public class RankedPointsCalc {
    private int rp;

    public RankedPointsCalc() {
        RankedPointsCalc rpc = new RankedPointsCalc();
    }

    // EFFECTS: adding an RP gain/loss value into the system after each game
    public int insertRPValue(int rp) {
        return 0; // stub
    }

    // REQUIRES: a placement value and a KP quantity
    // MODIFIES: this
    // EFFECTS: RP gain/loss will be determined based on Bronze division
    public int rankedPointsInBronze(PlacementCalc a, KillParticipationCalc b) {
        return 0; // stub
    }

    // REQUIRES: a placement value and a KP quantity
    // MODIFIES: this
    // EFFECTS: RP gain/loss will be determined based on Silver division
    public int rankedPointsInSilver(PlacementCalc a, KillParticipationCalc b) {
        return 0; // stub
    }

    // REQUIRES: a placement value and a KP quantity
    // MODIFIES: this
    // EFFECTS: RP gain/loss will be determined based on Gold division
    public int rankedPointsInGold(PlacementCalc a, KillParticipationCalc b) {
        return 0; // stub
    }

    // REQUIRES: a placement value and a KP quantity
    // MODIFIES: this
    // EFFECTS: RP gain/loss will be determined based on Platinum division
    public int rankedPointsInPlatinum(PlacementCalc a, KillParticipationCalc b) {
        return 0; // stub
    }

    // REQUIRES: a placement value and a KP quantity
    // MODIFIES: this
    // EFFECTS: RP gain/loss will be determined based on Diamond division
    public int rankedPointsInDiamond(PlacementCalc a, KillParticipationCalc b) {
        return 0; // stub
    }

    // REQUIRES: a placement value and a KP quantity
    // MODIFIES: this
    // EFFECTS: RP gain/loss will be determined based on Masters/Predator division
    public int rankedPointsInMastersPredator(PlacementCalc a, KillParticipationCalc b) {
        return 0; // stub
    }
}
