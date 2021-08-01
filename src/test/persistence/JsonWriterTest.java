package persistence;

import model.MatchLog;
import model.ApexMatch;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    @Test
    void testWriterInvalidFile() {
        try {
            MatchLog matchLog = new MatchLog();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMatchLog() {
        try {
            MatchLog matchLog = new MatchLog();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMatchLog.json");
            writer.open();
            writer.write(matchLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMatchLog.json");
            matchLog = reader.read();
            assertEquals(0, matchLog.numMatches());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}