package model;

import java.util.ArrayList;
import java.util.List;

import model.exceptions.ExcessDestinationException;
import model.exceptions.IllegalDestinationException;

// A class representing a travel bucket list having a list of destinations and a maximum number of destinations
public class TravelBucketList {
    public List<Destination> destinations;            // List of destinations (location names)
    public static final int MAX_DESTINATIONS = 30;    // Constraint: maximum of 30 destinations in bucket list

    // MODIFIES: this
    // EFFECTS: constructs a travel bucket list to store a list of destinations
    public TravelBucketList() {
        // this.destinations = new ArrayList<>();
    }
    
    // REQUIRES: destinations should not be null or empty 
    //           specified destination should not already be in list
    //           list may not exceed 30 destinations
    // MODIFIES: this
    // EFFECTS: adds one new destination to list
    public void addDestination(String location) throws IllegalDestinationException, ExcessDestinationException {
        // if (location == null || location.isEmpty()) {
        //     throw new IllegalDestinationException("Destination can not be null or empty");
        // }
        // if (destinations.size() >= MAX_DESTINATIONS) {
        //     throw new ExcessDestinationException("Can not add more than " + MAX_DESTINATIONS + " destinations to the travel bucket list.");
        // }
        // destinations.add(new Destination(location));
    }


    // REQUIRES: specified destination must exist in list 
    // MODIFIES: this
    // EFFECTS: removes specified destination
    public void removeDestination(String location) throws IllegalDestinationException {
        // Destination toRemove = null;
        // for (Destination destination : destinations) {
        //     if (destination.getDestination().equals(location)){
        //         toRemove = destination;
        //     }
        // }
        // if (toRemove == null) {
        //     throw new IllegalDestinationException("Destination does not exist in the travel bucket list.");
        // }
        // destinations.remove(toRemove);   
    }

    // REQUIRES: specified destination to exist in travel bucket list
    // MODIFIES: this
    // EFFECTS: marks specified destination as visited
    public void markAsVisited(String location) throws IllegalDestinationException {
        // for (Destination destination : destinations) {
        //     if (destination.getDestination().equals(location)){
        //         destination.markAsVisited();
        //     }
        // }
        // throw new IllegalDestinationException("Destination does not exist in the travel bucket list.");
    }


    // EFFECTS: view all destinations in travel bucket list
    public List<Destination> getDestinations() {
        // return new ArrayList<>(destinations);
    }

}
