package persistence;

import model.Destination;
import model.TravelBucketList;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Note: this code is adapted from the provided example JsonSerializationDemo

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass: exception is expected
            assertTrue(e instanceof FileNotFoundException);
        }
    }

    @Test
    void testReaderEmptyTravelBucketList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTravelBucketList.json");
        try {
            TravelBucketList tbl = reader.read();
            assertEquals(0, tbl.numDestinations());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTravelBucketList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTravelBucketList.json");
        try {
            TravelBucketList tbl = reader.read();
            //assertEquals("My General Travel Bucket List", tbl.getTitle());
            List<Destination> destinations = tbl.getDestinations();
            assertEquals(3, destinations.size());

            assertEquals("Paris", destinations.get(0).getDestination());
            assertFalse(destinations.get(0).visitStatus());

            assertEquals("Melbourne", destinations.get(1).getDestination());
            assertTrue(destinations.get(1).visitStatus());

            assertEquals("Seoul", destinations.get(2).getDestination());
            assertFalse(destinations.get(2).visitStatus());

            // checkDestination(destinations.get(0), "Paris");
            // checkDestination(destinations.get(1), "Melbourne");
            // checkDestination(destinations.get(2), "Seoul");

            // assertFalse(destinations.get(0).visitStatus());
            // assertTrue(destinations.get(1).visitStatus());
            // assertFalse(destinations.get(2).visitStatus());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
