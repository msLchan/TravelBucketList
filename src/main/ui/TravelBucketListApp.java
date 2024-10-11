package ui;

import model.TravelBucketList;
import model.Destination;

import java.util.List;
// Note: this code is adapted from the TellerApp example provided to the class 
import java.util.Scanner;

// Travel Bucket List Application
public class TravelBucketListApp {
    private TravelBucketList travelBucketList;
    private Scanner input;

    // EFFECTS: runs the travel bucket list application
    public TravelBucketListApp() {
        travelBucketList = new TravelBucketList("My Travel Bucket List", null);
        input = new Scanner(System.in);
        runTravelBucketList();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTravelBucketList() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye. Thanks for using Travel Bucket List!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addDestination();
        } else if (command.equals("r")) {
            removeDestination();
        } else if (command.equals("v")) {
            markAsVisited();
        } else if (command.equals("g")) {
            getDestinations();
        } else {
            System.out.println("Selection not valid. Please try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes travel bucket list
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add destination");
        System.out.println("\tr -> remove destination");
        System.out.println("\tv -> mark as visited");
        System.out.println("\tg -> get list of destinations");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds a destination to the travel bucket list
    private void addDestination() {
        System.out.print("Enter destination name: ");
        String location = input.next();

        travelBucketList.addDestination(location);
        System.out.println(location + " added to travel bucket list.");
    }

    // MODIFIES: this
    // EFFECTS: removes a destination from the travel bucket list
    private void removeDestination() {
        System.out.print("Enter destination name to remove: ");
        String location = input.next();

        if (travelBucketList.removeDestination(location)) {
            System.out.println(location + " removed from travel bucket list.");
        } else {
            System.out.println(location + " was not found in travel bucket list.");
        }
    }

    // MODIFIES: this
    // EFFECTS: marks a destination as visited
    private void markAsVisited() {
        System.out.print("Enter destination name to mark as visited: ");
        String location = input.next(); 

        if (travelBucketList.markAsVisited(location)) {
            System.out.println(location + " marked as visited.");
        } else {
            System.out.println(location + " was not found in travel bucket list.");
        }
    }


    // EFFECTS: displays list of destinations on travel bucket list on the screen
    private void getDestinations() {
        System.out.println("Travel Bucket List: ");
        List<Destination> currentDestinations = travelBucketList.getDestinations();

        if (currentDestinations.isEmpty()) {
            System.out.println("No destinations are currently in travel bucket list."); 
        } else {
            for (Destination destination : currentDestinations) {
                String status = destination.visitStatus() ? "Visited" : "Not Visited";
                System.out.println("- " + destination.getDestination() + " [" + status + "]");
            }
        }
    }
}