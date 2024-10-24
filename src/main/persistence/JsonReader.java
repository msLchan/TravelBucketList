package persistence;

import model.Destination;
import model.TravelBucketList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Note: this code is adapted from the provided example JsonSerializationDemo

// Represents a reader that reads TravelBucketList from JSON data stored in file
public class JsonReader {

    // EFFECTS: constructs reader to read from source file
    public JsonReader() {

    }

    // EFFECTS: reads TravelBucketList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TravelBucketList read() throws IOException {

    }

    // EFFECTS: reads source file as string and returns it
    private String readFile() throws IOException; {

    }

    // EFFECTS: parses TravelBucketList from JSON object and returns it
    private TravelBucketList parseTravelBucketList() {

    }

    // MODIFIES: tbl
    // EFFECTS: parses Destinations from JSON object and adds them to TravelBucketList
    private void addDestinations() {

    }

    // MODIFIES: tbl
    // EFFECTS: parses Destination from JSON object and adds it to workroom
    private void addDestination() {

    }

}
