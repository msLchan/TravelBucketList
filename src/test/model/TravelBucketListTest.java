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
    public TravelBucketList travelBucketListEmpty;
    public TravelBucketList travelBucketListWithInitialDestination;
    public Destination initialDestination;

    @BeforeEach             
    public void runBefore() {
        initialDestination = new Destination("Seoul");
        travelBucketListEmpty = new TravelBucketList("My Empty Travel Bucket List", null);
        travelBucketListWithInitialDestination = new TravelBucketList("My Travel Bucket List", initialDestination);
    }

    @Test                   // tests for the constructor
    public void testConstructor() {
        // Test that the title is set correctly
        assertEquals("My Travel Bucket List", travelBucketListWithInitialDestination.getTitle());

        // Test that the empty travel bucket list is empty
        List<Destination> emptyDestinations = travelBucketListEmpty.getDestinations();
        assertTrue(emptyDestinations.isEmpty(), "Expected empty travel bucket list to have no destinations");

        // Test that the initial destination is added
        List<Destination> destinations = travelBucketListWithInitialDestination.getDestinations();
        assertEquals(1, destinations.size());
        assertEquals("Seoul", destinations.get(0).getDestination());
    }

    @Test
    public void testAddDestination() {
        travelBucketListWithInitialDestination.addDestination("Melbourne");
        List<Destination> destinations = travelBucketListWithInitialDestination.getDestinations();
        assertEquals(2, destinations.size());
        assertEquals("Melbourne", destinations.get(1).getDestination());
    }

    @Test
    public void testRemoveDestination() {
        travelBucketListWithInitialDestination.addDestination("Hong Kong");
        travelBucketListWithInitialDestination.removeDestination("Hong Kong");
        List<Destination> destinations = travelBucketListWithInitialDestination.getDestinations();
        assertEquals(1, destinations.size());
    }
    
    @Test
    public void testMarkAsVisited() {
        travelBucketListWithInitialDestination.addDestination("Tokyo");
        travelBucketListWithInitialDestination.getDestinations().get(1).markAsVisited();
        assertTrue(travelBucketListWithInitialDestination.getDestinations().get(1).visitStatus());
    }

    // @Test(expected = IllegalDestinationException.class)
    // public void testRemoveNonExistentDestination() throws IllegalDestinationException {
    //     travelBucketListWithInitialDestination.removeDestination("Nonexistent");
    // }
}
