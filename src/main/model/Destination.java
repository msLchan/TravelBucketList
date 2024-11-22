package model;

import org.json.JSONObject;
import persistence.Writable;

// A class representing a destination and visit status
public class Destination implements Writable {
    private String destination;         // destination - location user wishes to travel to
    private boolean visitStatus;        // visited or not yet visited

    // MODIFIES: this
    // EFFECTS: constructs a destination location with a visit status (initializes as not yet visited)
    public Destination(String destination) {
        this.destination = destination;
        this.visitStatus = false;
    }

    public String getDestination() {
        return destination;
    }

    public boolean visitStatus() {
        return visitStatus;
    }

    // REQUIRES: destination should not be null or empty
    // MODIFIES: this
    // EFFECTS: marks destination as visited 
    public void markAsVisited() {
        this.visitStatus = true;
    }

    // REQUIRES: destination should not be null or empty
    // MODIFIES: this
    // EFFECTS: returns a specified destination with status visited or not yet visited
    public String toString() {
        return destination + (visitStatus ? " (Visited)" : " (Not yet visited)");
    }

    // EFFECTS: converts destination object into JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("destination", destination);
        json.put("visitStatus", visitStatus);
        return json;
    }
}
