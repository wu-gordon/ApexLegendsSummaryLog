package model;

// game values of an apex match
public class ApexMatch {
    private String rank;
    private int rp;
    private int kp;
    private int placement;

    public ApexMatch(String rankDiv, int place, int killPart, int rankPoints) {
        rank = rankDiv;
        placement = place;
        kp = killPart;
        rp = rankPoints;
    }

    // EFFECTS: sets division to rank
    public void storeRankedDivision(String division) {
        rank = division;
    }

    // EFFECTS: sets points to rp
    public void storeRankedPoints(int points) {
        rp = points;
    }

    // EFFECTS: sets kills and assists to kp
    public void storeKillParticipation(int killsAssists) {
        kp = killsAssists;
    }

    // EFFECTS: sets place to placement
    public void storePlacement(int place) {
        placement = place;
    }

    public String getRank() {
        return rank;
    }

    public int getRp() {
        return rp;
    }

    public int getKp() {
        return kp;
    }

    public int getPlacement() {
        return placement;
    }

    // REQUIRES: setters above
    // MODIFIES: this
    // EFFECTS: prints out a summary of ranked division, placement, kill participation and ranked points as a
    //          single entry for each apex match
    @Override
    public String toString() {
        return "Division: " + rank + "\n" + "Placement: " + placement + "\n" + "Kill Participation (KP): " + kp + "\n"
                + "Ranked Points (RP): " + rp + "\n";
    }
}
