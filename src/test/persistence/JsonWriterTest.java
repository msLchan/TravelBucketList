package persistence;

import model.Destination;
import model.TravelBucketList;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Note: this code is adapted from the provided example JsonSerializationDemo

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (FileNotFoundException e) {
            // pass - exception is expected
            assertTrue(e instanceof FileNotFoundException);
        }
    }

    @Test
    void testWriterEmptyTravelBucketList() {
        try {
            TravelBucketList tbl = new TravelBucketList("My Empty Travel Bucket List", null);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTravelBucketList.json");
            writer.open();
            writer.write(tbl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTravelBucketList.json");
            tbl = reader.read();
            assertEquals("My Empty Travel Bucket List", tbl.getTitle());
            assertEquals(0, tbl.numDestinations());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTravelBucketList() {
        try {
            TravelBucketList tbl = new TravelBucketList("My General Travel Bucket List", null);
            tbl.addDestination("Hong Kong");
            tbl.addDestination("Bali");
            tbl.addDestination("Phuket");
            
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTravelBucketLst.json");
            writer.open();
            writer.write(tbl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTravelBucketList.json");
            tbl = reader.read();
            List<Destination> destinations = tbl.getDestinations();

            assertEquals(3, tbl.numDestinations());
            // assertEquals("Hong Kong", tbl.getDestinations().get(0).getDestination());
            // assertEquals("Bali", tbl.getDestinations().get(1).getDestination());
            // assertEquals("Phuketg", tbl.getDestinations().get(2).getDestination());

            checkDestination(destinations.get(0), "Hong Kong", false);
            checkDestination(destinations.get(1), "Bali", false);
            checkDestination(destinations.get(2), "Phuket", true);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}

