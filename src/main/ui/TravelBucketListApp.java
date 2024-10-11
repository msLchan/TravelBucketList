package ui;

import model.TravelBucketList;
import model.Destination;

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

        System.out.println("\nGoodbye!");
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
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes travel bucket list
    private void init() {
        cheq = new Account("Joe", 145.00);
        sav = new Account("Joe", 256.50);
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
        //Account selected = selectAccount();
        System.out.print("Enter destination name: ");
        String location = input.nextLine();

        if (location != null) {
            travelBucketList.addDestination(location);
            System.out.println(location + " added to travel bucket list.");
        } else {
            System.out.println("Destination not valid...\n");
        }

        //printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: removes a destination from the travel bucket list
    private void removeDestination() {
        //Account selected = selectAccount();
        System.out.print("Enter destination name to remove: ");
        String location = input.nextLine();

        System.out.println(location + " removed from travel bucket list.");

        // if (amount < 0.0) {
        //     System.out.println("Cannot withdraw negative amount...\n");
        // } else if (selected.getBalance() < amount) {
        //     System.out.println("Insufficient balance on account...\n");
        // } else {
        //     selected.withdraw(amount);
        // }

        // printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: marks a destination as visited
    private void markAsVisited() {
        System.out.print("Enter destination name to mark as visited: ");
        String location = input.nextLine(); 
            travelBucketList.markAsVisited(location);
            System.out.println(location + " marked as visited.");

        // System.out.println("\nTransfer from?");
        // Account source = selectAccount();
        // System.out.println("Transfer to?");
        // Account destination = selectAccount();

        // System.out.print("Enter amount to transfer: $");
        // double amount = input.nextDouble();

        // if (amount < 0.0) {
        //     System.out.println("Cannot transfer negative amount...\n");
        // } else if (source.getBalance() < amount) {
        //     System.out.println("Insufficient balance on source account...\n");
        // } else {
        //     source.withdraw(amount);
        //     destination.deposit(amount);
        // }

        // System.out.print("Source ");
        // printBalance(source);
        // System.out.print("Destination ");
        // printBalance(destination);
    }

    // // EFFECTS: prompts user to select chequing or savings account and returns it
    // private Account selectAccount() {
    //     String selection = "";  // force entry into loop

    //     while (!(selection.equals("c") || selection.equals("s"))) {
    //         System.out.println("c for chequing");
    //         System.out.println("s for savings");
    //         selection = input.next();
    //         selection = selection.toLowerCase();
    //     }

    //     if (selection.equals("c")) {
    //         return cheq;
    //     } else {
    //         return sav;
    //     }
    // }

    // EFFECTS: displays list of destinations on travel bucket list on the screen
    private void getDestinations() {
        System.out.println("Travel Bucket List: ");
        for (Destination destination : travelBucketList.getDestinations()) {
            String status = destination.isVisited() ? "Visited" : "Not Visited";
            System.out.println("- ") + destination.getLocation() + " [" + status + "]");
        }
        //System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}