package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
// import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import model.exceptions.IllegalDestinationException;

public class TravelBucketListTest {
    public TravelBucketList travelBucketList1;
    public TravelBucketList travelBucketList2;
    public TravelBucketList travelBucketList3;
    //public TravelBucketList travelBucketListWithInitialDestination;
    public Destination initialDestination;

    @BeforeEach             
    public void runBefore() {
        initialDestination = new Destination("Seoul");
        travelBucketList1 = new TravelBucketList("My First Travel Bucket List", null);
        travelBucketList2 = new TravelBucketList("My Second Travel Bucket List", null);
        travelBucketList3 = new TravelBucketList("My Third Travel Bucket List", null);
        //travelBucketListWithInitialDestination = new TravelBucketList("My Travel Bucket List", initialDestination);
    }

    @Test                   // tests for the constructor
    public void testConstructor() {
        // Test that the title is set correctly
        assertEquals("My First Travel Bucket List", travelBucketList1.getTitle());

        // Test that the empty travel bucket list is empty
        List<Destination> emptyDestinations = travelBucketList1.getDestinations();
        assertTrue(emptyDestinations.isEmpty(), "Expected first travel bucket list to have no destinations when initialized");

        // Test that the initial destination is added
        //List<Destination> destinations = travelBucketListWithInitialDestination.getDestinations();
        //assertEquals(1, destinations.size());
        //assertEquals("Seoul", destinations.get(0).getDestination());
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
    public void testMarkAsVisited() {
        travelBucketList3.addDestination("Tokyo");
        travelBucketList3.getDestinations().get(0).markAsVisited();
        assertTrue(travelBucketList3.getDestinations().get(0).visitStatus());
    }

    // @Test(expected = IllegalDestinationException.class)
    // public void testRemoveNonExistentDestination() throws IllegalDestinationException {
    //     travelBucketListWithInitialDestination.removeDestination("Nonexistent");
    // }
}
