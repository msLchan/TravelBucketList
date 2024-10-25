package persistence;

import model.Destination;
import model.TravelBucketList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;
import org.junit.experimental.categories.Category;

// Note: this code is adapted from the provided example JsonSerializationDemo

// Represents a reader that reads TravelBucketList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads TravelBucketList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TravelBucketList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTravelBucketList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses TravelBucketList from JSON object and returns it
    private TravelBucketList parseTravelBucketList(JSONObject jsonObject) {
        TravelBucketList tbl = new TravelBucketList("My Travel Bucket List", null);
        addDestinations(tbl, jsonObject);
        return tbl;
    }

    // MODIFIES: tbl
    // EFFECTS: parses Destinations from JSON object and adds them to TravelBucketList
    private void addDestinations(TravelBucketList tbl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("destinations");
        for (Object json : jsonArray) {
            JSONObject nextDestination = (JSONObject) json;
            addDestination(tbl, nextDestination);
        }
    }

    // MODIFIES: tbl
    // EFFECTS: parses Destination from JSON object and adds it to workroom
    private void addDestination(TravelBucketList tbl, JSONObject jsonObject) {
        String location = jsonObject.getString("destination");
        Destination destination = new Destination(location);
        tbl.addDestination(destination);
    }

}
