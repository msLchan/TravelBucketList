package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class DestinationTest {
    @Test
    public void testDestination() {
        Destination destination = new Destination("Hong Kong");

        // Test constructor 
        assertEquals("Hong Kong", destination.getDestination());

        // Test destination visit status (initially false = not yet visited)
        assertFalse(destination.visitStatus());

        // Test that mark as visited method changes destination status to visited
        destination.markAsVisited();
        assertTrue(destination.visitStatus());

        // Test toString method
        assertEquals("Hong Kong (Visited)", destination.toString());
    }

}
