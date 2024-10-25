package persistence;

import model.Destination;
import model.TravelBucketList;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Note: this code is adapted from the provided example JsonSerializationDemo

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            TravelBucketList tbl = new TravelBucketList("My Travel Bucket List", null);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTravelBucketList() {
        try {
            TravelBucketList tbl = new TravelBucketList("My Travel Bucket List", null);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTravelBucketList.json");
            writer.open();
            writer.write(tbl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTravelBucketList.json");
            tbl = reader.read();
            assertEquals(0, tbl.numDestinations());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTravelBucketList() {
        try {
            TravelBucketList tbl = new TravelBucketList("My Travel Bucket List");
            tbl.addDestination(new Destination("Hong Kong"));
            tbl.addDestination(new Destination("Bali"));
            tbl.addDestination(new Destination("Phuket"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTravelBucketLst.json");
            writer.open();
            writer.write(tbl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTravelBucketList.json");
            tbl = reader.read();
            assertEquals("My Travel Bucket List", tbl.getName());
            List<Destination> destinations = tbl.getDestinations();
            assertEquals(3, destinations.size());
            checkDestination("Hong Kong", destinations.get(0));
            checkDestination("Bali", destinations.get(1));
            checkDestination("Phuket", destinations.get(2));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}

