package model;

import java.util.ArrayList;
import java.util.List;

// A class representing a travel bucket list having a title, list of destinations and a maximum number of destinations
public class TravelBucketList {
    public String title;                              // Travel bucket list title 
    public List<Destination> destinations;            // List of destinations (location names)
    public static final int MAX_DESTINATIONS = 30;    // Constraint: maximum of 30 destinations in bucket list

    // MODIFIES: this
    // EFFECTS: constructs a travel bucket list to store a list of destinations
    public TravelBucketList(String title, Destination initialDestination) {
        this.title = title;
        this.destinations = new ArrayList<>();
    }
    
    // REQUIRES: destinations should not be null or empty 
    //           specified destination should not already be in list
    //           list may not exceed 30 destinations
    // MODIFIES: this
    // EFFECTS: adds one new destination to list
    public void addDestination(String location) {
        destinations.add(new Destination(location));
    }


    // REQUIRES: specified destination must exist in list 
    // MODIFIES: this
    // EFFECTS: removes specified destination
    public void removeDestination(String location) {
        Destination toRemove = null;
        for (Destination destination : destinations) {
            if (destination.getDestination().equals(location)){
                toRemove = destination;
            }
        }
        destinations.remove(toRemove);   
    }

    // REQUIRES: specified destination to exist in travel bucket list
    // MODIFIES: this
    // EFFECTS: marks specified destination as visited
    public void markAsVisited(String location) {
        for (Destination destination : destinations) {
            if (destination.getDestination().equals(location)){
                destination.markAsVisited();
            }
        }
    }


    // EFFECTS: view all destinations in travel bucket list
    public List<Destination> getDestinations() {
        return new ArrayList<>(destinations);
    }

    public String getTitle() {
        return title;
    }

}
