package model;

import org.json.JSONObject;
import persistence.Writable;

// game values of an apex match
public class ApexMatch implements Writable {
    private String rank;
    private int placement;
    private int kp;
    private int rp;

    public ApexMatch() {
        this.rank = "";
        this.placement = 0;
        this.kp = 0;
        this.rp = 0;
    }

    public ApexMatch(String rank, int placement, int kp, int rp) {
        this.rank = rank;
        this.placement = placement;
        this.kp = kp;
        this.rp = rp;
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
        if (place > 0 && place <= 20) {
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

    // getters and setters
    public String getRank() {
        return rank;
    }

    public int getPlacement() {
        return placement;
    }

    public int getKp() {
        return kp;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("rank", rank);
        json.put("placement", placement);
        json.put("kp", kp);
        json.put("rp", rp);
        return json;
    }

    // EFFECTS: prints out a summary of ranked division, placement, kill participation and ranked points as a
    //          single entry for each apex match
    @Override
    public String toString() {
        return "Division: " + rank + "\n" + "Placement: " + placement + "\n" + "Kill Participation (KP): " + kp + "\n"
                + "Ranked Points (RP): " + rp + "\n";
    }
}
