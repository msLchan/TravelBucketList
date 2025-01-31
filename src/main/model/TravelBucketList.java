package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// A class representing a travel bucket list having a title and a list of destinations
public class TravelBucketList implements Writable {
    private String title;                              // Travel bucket list title 
    private List<Destination> destinations;            // List of destinations (location names)

    // MODIFIES: this
    // EFFECTS: constructs a travel bucket list to store a list of destinations
    public TravelBucketList(String title, Destination initialDestination) {
        this.title = title;
        this.destinations = new ArrayList<>();
    }
    
    // REQUIRES: destination to add should not be null or empty 
    //           specified destination should not already be in list
    // MODIFIES: this
    // EFFECTS: adds one new destination to list and logs the event
    public void addDestination(String location) {
        destinations.add(new Destination(location));
        EventLog.getInstance().logEvent(new Event("Added destination " + location + " to " + title));
    }


    // REQUIRES: specified destination must exist in list 
    // MODIFIES: this
    // EFFECTS: removes specified destination and logs the event
    public boolean removeDestination(String location) {
        for (Destination destination : destinations) {
            if (destination.getDestination().equals(location)) {
                destinations.remove(destination);
                EventLog.getInstance().logEvent(new Event("Removed destination " + location + " from " + title));
                return true;                       // Successfully removed destination
            }
        }
        return false;                              // Destination not found in travel bucket list 
    }

    // REQUIRES: specified destination to exist in travel bucket list
    // MODIFIES: this
    // EFFECTS: marks specified destination as visited
    public boolean markAsVisited(String location) {
        for (Destination destination : destinations) {
            if (destination.getDestination().equals(location)) {
                destination.markAsVisited();
                EventLog.getInstance().logEvent(new Event("Marked " + location + " as visited in " + title));
                return true;                       // Successfully marked destination as visited
            }
        }
        return false;                              // Destination not found in travel bucket list
    }

    // EFFECTS: returns a list of destinations that have been visited and logs the event
    public List<Destination> filterVisitedDestinations() {
        List<Destination> visited = new ArrayList<>();
        for (Destination d : destinations) {
            if (d.visitStatus()) {
                visited.add(d);
            }
        }
        EventLog.getInstance().logEvent(new Event("Filtered visited destinations from " + title));
        return visited;
    }

    // EFFECTS: returns a list of destinations that have not been visited and logs the event
    public List<Destination> filterNotVisitedDestinations() {
        List<Destination> notVisited = new ArrayList<>();
        for (Destination d : destinations) {
            if (!d.visitStatus()) {
                notVisited.add(d);
            }
        }
        EventLog.getInstance().logEvent(new Event("Filtered not visited destinations from " + title));
        return notVisited;
    }

    // EFFECTS: returns all destinations (after filtering) and logs the event
    public List<Destination> showAllDestinations() {
        EventLog.getInstance().logEvent(new Event("Displayed all destinations from " + title));
        return new ArrayList<>(destinations);
    }


    // EFFECTS: view all destinations in travel bucket list
    public List<Destination> getDestinations() {
        return destinations;
    }

    // EFFECTS: returns number of destinations in travel bucket list
    public int numDestinations() {
        return destinations.size();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("destinations", destinationsToJson());
        return json;
    }

    // EFFECTS: returns things in this TravelBucketList as a JSON array
    private JSONArray destinationsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Destination d : destinations) {
            jsonArray.put(d.toJson());
        }

        return jsonArray;
    }

}
