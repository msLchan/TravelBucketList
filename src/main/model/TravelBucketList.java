package model;

import java.util.ArrayList;
import java.util.List;

import model.exceptions.IllegalDestinationException;

// A class representing a travel bucket list having a list of destinations (max: 30 destinations) and visit status
public class TravelBucketList {
    public List<String> destinations;                 // Destination - location name
    public boolean visitStatus;                       // Visited or not yet visited
    public static final int MAX_DESTINATIONS = 30;    // Constraint: maximum of 30 destinations in bucket list

    public List<String> destinations() {
        return destinations;
    }

    public boolean visitStatus() {
        return visitStatus;
    }
    
    // EFFECTS: constructs a travel bucket list to store destinations
    public TravelBucketList() {
        this.destinations = new ArrayList<>();
    }
    
    // REQUIRES: destinations should not be null or empty and list may not exceed 30 destinations
    // MODIFIES: this
    // EFFECTS: adds new destination to list
    public void addDestination(String destinations) {
        if (destinations == null || destinations.isEmpty()) {
            throw new IllegalDestinationException("Destination can not be null or empty");
        }
        if (destinations.size() >= MAX_DESTINATIONS) {
            throw new ExcessDestinationException("Can not add more than " + MAX_DESTINATIONS + " destinations to the travel bucket list.");
        }
        destinations.add(destinations);
    }


    // REQUIRES: specified destination must exist in list 
    // MODIFIES: this
    // EFFECTS: removes specified destination
    public void removeDestination(String destinations) {
        if (!destinations.contains(destinations)) {
            throw new IllegalDestinationException("Destination does not exist in the travel bucket list.");
        }
        destinations.remove(destinations);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: view all destinations in travel bucket list
    public List<String> getDestinations() {
        return new ArrayList<>(destinations);
    }

}
