package persistence;

import model.Destination;
import model.TravelBucketList;

import org.json.JSONObject;
import java.io.*;

// Note: this code is adapted from the provided example JsonSerializationDemo

// Represents a writer that writes JSON representation of TravelBucketList to file
public class JsonWriter {

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter() {

    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
    
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of TravelBucketList to file
    public void write() {

    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
    
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile() {
        
    }

}
