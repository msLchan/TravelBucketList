package persistence;

import model.Destination;
import model.TravelBucketList;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Note: this code is adapted from the provided example JsonSerializationDemo

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TravelBucketList tbl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTravelBucketList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTravelBucketList.json");
        try {
            TravelBucketList tbl = reader.read();
            assertEquals("My Empty Travel Bucket List", tbl.getName());
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
            assertEquals("My General Travel Bucket List", tbl.getName());
            List<Destination> destinations = tbl.getDestination();
            assertEquals(3, destinations.size());
            checkDestination("Paris", destinations.get(0));
            checkDestination("Melbourne", destinations.get(1));
            checkDestination("Seoul", destinations.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
