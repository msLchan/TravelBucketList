package persistence;

import model.Destination;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Note: this code is adapted from the provided example JsonSerializationDemo

public class JsonTest {
    protected void checkDestination(Destination destination, String locationName) {
        assertEquals(locationName, destination.getDestination());
    }

    protected void checkDestination(Destination destination, String locationName, boolean visitStatus) {
        assertEquals(locationName, destination.getDestination());
        assertEquals(visitStatus, destination.visitStatus());
    }

}
