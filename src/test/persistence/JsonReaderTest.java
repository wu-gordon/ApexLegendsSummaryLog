package persistence;

import model.MatchLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
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
}