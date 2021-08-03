package persistence;

import model.ApexMatch;
import model.MatchLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    // checks the non existent file
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            MatchLog matchLog = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // checks the empty match log file
    @Test
    void testReaderEmptyMatchLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMatchLog.json");
        try {
            MatchLog matchLog = reader.read();
            assertEquals(0, matchLog.numMatches());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // checks the working match log file
    @Test
    void testReaderGeneralMatchLog() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMatchLog.json");
        try {
            MatchLog matchLog = reader.read();
            List<ApexMatch> apexMatches = matchLog.getMatches();
            assertEquals(1, apexMatches.size());
            checkMatchData(6, "diamond", 1, 202, apexMatches.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}