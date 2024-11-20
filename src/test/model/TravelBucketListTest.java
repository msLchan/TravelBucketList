package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelBucketListTest {
    public TravelBucketList travelBucketList1;
    public TravelBucketList travelBucketList2;
    public TravelBucketList travelBucketList3;
    public TravelBucketList travelBucketList4;
    public Destination initialDestination;

    @BeforeEach             
    public void runBefore() {
        initialDestination = new Destination("Seoul");
        travelBucketList1 = new TravelBucketList("My First Travel Bucket List", null);
        travelBucketList2 = new TravelBucketList("My Second Travel Bucket List", null);
        travelBucketList3 = new TravelBucketList("My Third Travel Bucket List", null);
        travelBucketList4 = new TravelBucketList("My Fourth Travel Bucket List", null);
    }

    @Test                   // tests for the constructor
    public void testConstructor() {
        // Test that the title is set correctly
        assertEquals("My First Travel Bucket List", travelBucketList1.getTitle());

        // Test that the empty travel bucket list is empty
        List<Destination> emptyDestinations = travelBucketList1.getDestinations();
        assertTrue(emptyDestinations.isEmpty(), "Expected first travel bucket list to have no destinations when initialized");
    }

    @Test
    public void testAddDestination() {
        travelBucketList1.addDestination("Melbourne");
        List<Destination> destinations = travelBucketList1.getDestinations();
        assertEquals(1, destinations.size());
        assertEquals("Melbourne", destinations.get(0).getDestination());
    }

    @Test
    public void testRemoveDestination() {
        travelBucketList2.addDestination("Hong Kong");
        travelBucketList2.addDestination("London");
        travelBucketList2.removeDestination("Hong Kong");
        List<Destination> destinations = travelBucketList2.getDestinations();
        assertEquals(1, destinations.size());
    }
    
    @Test
    public void testRemoveNonExistentDestination() {
        assertFalse(travelBucketList1.removeDestination("Rome"));
    }

    @Test
    public void testMarkAsVisited() {
        travelBucketList3.addDestination("Tokyo");
        travelBucketList3.getDestinations().get(0).markAsVisited();
        assertTrue(travelBucketList3.getDestinations().get(0).visitStatus());
    }

    @Test
    public void testMarkNonExistentAsVisited() {
        assertFalse(travelBucketList2.markAsVisited("Rome"));
    }

    @Test
    public void testGetDestinations() {
        travelBucketList1.addDestination("Paris");
        travelBucketList1.addDestination("Tokyo");
        List<Destination> destinations = travelBucketList1.getDestinations();
        assertEquals(2, destinations.size());
        assertEquals("Paris", destinations.get(0).getDestination());
        assertEquals("Tokyo", destinations.get(1).getDestination());
    }

    @Test
    public void testNumDestinations() {
        assertEquals(0, travelBucketList1.numDestinations());
        travelBucketList1.addDestination("New York");
        assertEquals(1, travelBucketList1.numDestinations());
        travelBucketList1.addDestination("Chicago");
        assertEquals(2, travelBucketList1.numDestinations());
        travelBucketList1.removeDestination("New York");
        assertEquals(1, travelBucketList1.numDestinations());
    }

    @Test
    public void testToJson() {
        travelBucketList2.addDestination("Florida");
        travelBucketList2.addDestination("Yukon");
        JSONObject json = travelBucketList2.toJson();
        JSONArray destinationsJson = json.getJSONArray("destinations");
        assertEquals(2, destinationsJson.length());
        assertEquals("Florida", destinationsJson.getJSONObject(0). getString("destination"));
        assertEquals("Yukon", destinationsJson.getJSONObject(1). getString("destination"));
    }

    @Test
    public void testDestinationsToJson() {
        travelBucketList3.addDestination("Narita");
        travelBucketList3.addDestination("Haneda");
        JSONObject json = travelBucketList3.toJson();
        JSONArray destinationsJson = json.getJSONArray("destinations");
        assertEquals(2, destinationsJson.length());
        assertEquals("Narita", destinationsJson.getJSONObject(0). getString("destination"));
        assertEquals("Haneda", destinationsJson.getJSONObject(1). getString("destination"));
    }
}
