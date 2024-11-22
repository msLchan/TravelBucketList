package ui;

import model.Destination;
import model.TravelBucketList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

// Note: this code is adapted from the ListDemo examples recommended to the class on oracle: 
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java

public class GUI {

    // EFFECTS: constructs the GUI, initializes the travel bucket list and sets up persistence
    public GUI() {

    }

    // MODIFIES: this
    // EFFECTS: initializes and displays main application GUI
    private void createAndShowGUI() {

    }

    // REQUIRES: destination input is not null or empty
    // MODIFIES: this
    // EFFECTS: prompts user to input a destination, adds it to the travel bucket list and updates the display
    private void addDestination() {

    }

    // REQUIRES: destinationList is not empty
    // MODIFIES: this
    // EFFECTS: removes selected destination from the travel bucket list and updates the display
    private void removeDestination() {

    }

    // MODIFIES: this
    // EFFECTS: filters the list to show only destinations that have been visited
    private void filterVisitedDestinations() {
        
    }

    // MODIFIES: this
    // EFFECTS: filters the list to show only destinations that are not yet visited
    private void filterNotVisitedDestinations() {

    }

    // REQUIRES: valid file path and writable file
    // MODIFIES: external file
    // EFFECTS: saves the travel bucket list to a JSON file and shows confirmation or error messages
    private void saveTravelBucketList() {

    }

    // REQUIRES: valid file path and readable file
    // MODIFIES: this
    // EFFECTS: loads the travel bucket list from a JSON file and updates the display
    private void loadTravelBucketList() {
        
    }

    // MODIFIES: this
    // EFFECTS: displays a splash screen at application startup
    private static void showSplashScreen() {

    }

    // EFFECTS: starts the GUI application and shows the splash screen
    public static void main(String[] args) {
        
    }

}
