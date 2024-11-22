package ui;

import model.Destination;
import model.TravelBucketList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import java.awt.*;
import javax.swing.*;


// Note: this code is adapted from the ListDemo examples recommended to the class and oracle tutorials: 
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java

// Splash image credits: https://unsplash.com/photos/white-plane-flying-over-gray-clouds-FwdZYz0yc9g
// Image is open source photographed by Leio McLaren

public class GUI {
    private static final String JSON_STORE = "./data/travelbucketlist.json";
    private TravelBucketList travelBucketList;
    private DefaultListModel<String> listModel;
    private JList<String> destinationList;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    // EFFECTS: constructs the GUI, initializes the travel bucket list and sets up persistence
    public GUI() {
        travelBucketList = new TravelBucketList("My Travel Bucket List", null);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        listModel = new DefaultListModel<>();
        createAndShowGUI();
    }

    // MODIFIES: this
    // EFFECTS: initializes and displays main application GUI
    @SuppressWarnings("methodlength")
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Travel Bucket List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);

        destinationList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(destinationList);

        JButton addButton = new JButton("Add Destination");
        JButton removeButton = new JButton("Remove Destination");
        JButton markVisitedButton = new JButton("Mark as Visited");
        JButton filterVisitedButton = new JButton("Filter Visited");
        JButton filterNotVisitedButton = new JButton("Filter Not Visited");
        JButton showAllButton = new JButton("Show All Destinations");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,3));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(markVisitedButton);
        buttonPanel.add(filterVisitedButton);
        buttonPanel.add(filterNotVisitedButton);
        buttonPanel.add(showAllButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(e -> addDestination());
        removeButton.addActionListener(e -> removeDestination());
        markVisitedButton.addActionListener(e -> markAsVisited());
        filterVisitedButton.addActionListener(e -> filterVisitedDestinations());
        filterNotVisitedButton.addActionListener(e -> filterNotVisitedDestinations());
        showAllButton.addActionListener(e -> showAllDestinations());
        saveButton.addActionListener(e -> saveTravelBucketList());
        loadButton.addActionListener(e -> loadTravelBucketList());
    }

    // REQUIRES: destination input is not null or empty
    // MODIFIES: this
    // EFFECTS: prompts user to input a destination, adds it to the travel bucket list and updates the display
    private void addDestination() {
        String destination = JOptionPane.showInputDialog("Enter Destination:");
        if (destination != null && !destination.isEmpty()) {
            travelBucketList.addDestination(destination);
            listModel.addElement(destination + " (Not Visited)");
        }
    }

    // REQUIRES: destinationList is not empty
    // MODIFIES: this
    // EFFECTS: removes selected destination from the travel bucket list and updates the display
    private void removeDestination() {
        int selectedIndex = destinationList.getSelectedIndex();
        if (selectedIndex != -1) {
            String destinationName = listModel.get(selectedIndex).split(" \\(")[0];
            travelBucketList.removeDestination(destinationName);
            listModel.remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "Destination has been removed.");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a destination to remove.");
        }
    }

    // REQUIRES: destinationList is not empty
    // MODIFIES: this
    // EFFECTS: marks the selected destination as visited and updates the display
    private void markAsVisited() {
        int selectedIndex = destinationList.getSelectedIndex();
        if (selectedIndex != -1) {
            String destinationName = listModel.get(selectedIndex).split(" \\(")[0];
            boolean success = travelBucketList.markAsVisited(destinationName);
            if (success) {
                listModel.set(selectedIndex, destinationName + " (Visited)");
                JOptionPane.showMessageDialog(null, destinationName + " marked as visited.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Unable to marked as visited.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a destination to marked as visited.");
        }
    }

    // MODIFIES: this
    // EFFECTS: filters the list to show only destinations that have been visited
    private void filterVisitedDestinations() {
        listModel.clear();
        for (Destination d : travelBucketList.getDestinations()) {
            if (d.visitStatus()) {
                listModel.addElement(d.getDestination() + " (Visited)");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: filters the list to show only destinations that are not yet visited
    private void filterNotVisitedDestinations() {
        listModel.clear();
        for (Destination d : travelBucketList.getDestinations()) {
            if (!d.visitStatus()) {
                listModel.addElement(d.getDestination() + " (Not Visited)");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds all destinations back to the list display after filtering
    private void showAllDestinations() {
        listModel.clear();
        for (Destination d : travelBucketList.getDestinations()) {
            listModel.addElement(d.getDestination() + (d.visitStatus() ? " (Visited)" : " (Not Visited)"));
        }
    }

    // REQUIRES: valid file path and writable file
    // MODIFIES: external file
    // EFFECTS: saves the travel bucket list to a JSON file and shows confirmation or error messages
    private void saveTravelBucketList() {
        try {
            jsonWriter.open();
            jsonWriter.write(travelBucketList);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Travel Bucket List saved.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Failed to save data.");
        }
    }

    // REQUIRES: valid file path and readable file
    // MODIFIES: this
    // EFFECTS: loads the travel bucket list from a JSON file and updates the display
    private void loadTravelBucketList() {
        try {
            travelBucketList = jsonReader.read();
            listModel.clear();
            for (Destination d : travelBucketList.getDestinations()) {
                listModel.addElement(d.getDestination() + (d.visitStatus() ? " (Visted)" : " (Not Visited)"));
            }
            JOptionPane.showMessageDialog(null, "Travel Bucket List loaded.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Failed to load data.");
        }
    }

    // MODIFIES: this
    // EFFECTS: displays a splash screen at application startup
    private static void showSplashScreen() {
        JWindow splash = new JWindow();
        String imagePath = "./image/travelsplash_image.png";
        ImageIcon splashImage = new ImageIcon(imagePath);

        JLabel splashLabel = new JLabel(splashImage);
        splash.getContentPane().add(splashLabel, BorderLayout.CENTER);
        splash.setSize(splashImage.getIconWidth(), splashImage.getIconHeight());
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.setVisible(false);
        splash.dispose();       
    }

    // EFFECTS: starts the GUI application and shows the splash screen
    public static void main(String[] args) {
        Thread splashThread = new Thread(() -> {
            showSplashScreen();
            SwingUtilities.invokeLater(GUI::new);
        });
        splashThread.start();
    }

}
