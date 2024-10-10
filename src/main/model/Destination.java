package model;

// A class representing a destination and visit status
public class Destination {
    private String destination;         // destination - location user wishes to travel to
    private boolean visitStatus;        // visited or not yet visited

    // MODIFIES: this
    // EFFECTS: constructs a destination with a visit status (initializes as not yet visited)
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
}
