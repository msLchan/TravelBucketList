package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelBucketListTest {
    public TravelBucketList travelBucketList;
    public Destination initialDestination;

    @BeforeEach             // examples of travel bucket lists
    public void runBefore() {
        initialDestination = new Destination("Seoul");
        travelBucketList = new TravelBucketList("My Travel Bucket List", initialDestination);
    }

    @Test                   // tests for the constructor
    public void testConstructor() {
        // Test that the title is set correctly
        assertEquals("My Travel Bucket List", travelBucketList.getTitle());

        // Test that the initial destination is added
        List<Destination> destinations = travelBucketList.getDestinations();
        assertEquals(1, destinations.size());
        assertEquals("Seoul", destinations.get(0).getName());



        TravelBucketList travelBucketList = new TravelBucketList();
        List<Destination> location = travelBucketList.getLocation();

        if (location.isEmpty()) {
            System.out.println("Constructor test passed: travel bucket list is initialized empty"); 
        } else {
            System.out.println("Constructor test failed: travel bucket list should be empty");
        }
        
    }

    @Test
    void sampleTest() {
        assertTrue(true);
    }
}
