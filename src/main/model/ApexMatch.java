package model;

// game values of an apex match
public class ApexMatch {
    private String rank;
    private int rp;
    private int kp;
    private int placement;

    public ApexMatch() {
        rank = "";
        placement = 0;
        kp = 0;
        rp = 0;
    }

    // REQUIRES: a ranked division
    // MODIFIES: this
    // EFFECTS: if the submitted rank division matches the appropriate spelling (non-case sensitive), the division
    //          will be stored as a rank and return true; otherwise false
    public boolean storeRankedDivision(String division) {
        division = division.toLowerCase();
        if (division.equals("bronze") || division.equals("silver") || division.equals("gold")
                || division.equals("platinum") || division.equals("diamond")
                || division.equals("masters/predator")) {
            rank = division;
            return true;
        } else {
            return false;
        }

    }

    // REQUIRES: a placement value
    // MODIFIES: this
    // EFFECTS: if the submitted placement value matches the appropriate placement range (symbolizing 20 teams of 3)
    //          the place will be stored as placement and return true; otherwise false
    public boolean storePlacement(int place) {
        if (place >= 0 && place <= 20) {
            placement = place;
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: a kills/assists (KP) value
    // MODIFIES: this
    // EFFECTS: if the submitted KP value matches the appropriate KP range (symbolizing max KP = 6), the killsAssists
    //          will be stored as kp and return true; otherwise false
    public boolean storeKillParticipation(int killsAssists) {
        if (killsAssists >= 0 && killsAssists <= 6) {
            kp = killsAssists;
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: a ranked points value
    // MODIFIES: this
    // EFFECTS: if the submitted ranked points value matches the appropriate RP range (symbolizing the max amount
    //          of RP gain possible in the game), the points wil be stored as rp and return true; otherwise false
    public boolean storeRankedPoints(int points) {
        if (points >= 0 && points <= 250) {
            rp = points;
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: prints out a summary of ranked division, placement, kill participation and ranked points as a
    //          single entry for each apex match
    @Override
    public String toString() {
        return "Division: " + rank + "\n" + "Placement: " + placement + "\n" + "Kill Participation (KP): " + kp + "\n"
                + "Ranked Points (RP): " + rp + "\n";
    }
}
