package persistence;

import model.Destination;
import model.TravelBucketList;

import org.junit.jupiter.api.Test;

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
            List<Destination> destinations = tbl.getDestinations();
            assertEquals(3, destinations.size());

            checkDestination(destinations.get(0), "Paris", false);
            checkDestination(destinations.get(1), "Melbourne", true);
            checkDestination(destinations.get(2), "Seoul", false);

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
