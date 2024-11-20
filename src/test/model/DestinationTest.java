package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import org.json.*;

public class DestinationTest {

    @Test
    public void testConstructor() {
        Destination destination = new Destination("Hong Kong");
        assertEquals("Hong Kong", destination.getDestination());
        assertFalse(destination.visitStatus());
    }

    @Test
    public void testMarkAsVisited() {
        Destination destination = new Destination("Hong Kong");
        assertFalse(destination.visitStatus());
        destination.markAsVisited();
        assertTrue(destination.visitStatus());
    }

    @Test
    public void testToString() {
        Destination destination = new Destination("Hong Kong");
        assertEquals("Hong Kong (Not yet visited)", destination.toString());
        destination.markAsVisited();
        assertEquals("Hong Kong (Visited)", destination.toString());
    }

    @Test
    public void testToJson() {
        Destination destination = new Destination("Hong Kong");

        JSONObject json = destination.toJson();
        assertEquals("Hong Kong", json.getString("destination"));
        assertFalse(json.getBoolean("visitStatus"));

        destination.markAsVisited();
        json = destination.toJson();
        assertEquals("Hong Kong", json.getString("destination"));
        assertTrue(json.getBoolean("visitStatus"));     
    }


}
