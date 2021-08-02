package persistence;

import model.ApexMatch;
import model.RankedPointsCalculator;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    private RankedPointsCalculator rpCalc;

    protected void checkMatchData(int kp, String rank, int placement, int rp, ApexMatch apexMatch) {
        rpCalc = new RankedPointsCalculator();

        assertEquals(kp, apexMatch.getKp());
        assertEquals(rank, apexMatch.getRank());
        assertEquals(placement, apexMatch.getPlacement());
        assertEquals(rp, rpCalc.calculateRankEntryCost("diamond", 1, 6));
    }
}
