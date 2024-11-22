package persistence;

import model.TravelBucketList;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

// Note: this code is adapted from the provided example JsonSerializationDemo

// Represents a writer that writes JSON representation of TravelBucketList to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;
    private boolean isOpen;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
        this.isOpen = false;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws IOException if destination file cannot
    // be opened for writing
    public void open() throws IOException {
        writer = new PrintWriter(new File(destination));
        isOpen = true;
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of TravelBucketList to file
    public void write(TravelBucketList tbl) {
        if (!isOpen) {
            throw new IllegalStateException("Writer must be opened before writing.");
        }
        JSONObject json = tbl.toJson();
        writer.print(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        if (isOpen) {
            writer.close();
            isOpen = false;
        }
    }

    // // MODIFIES: this
    // // EFFECTS: writes string to file
    // private void saveToFile(String json) {
    //     writer.print(json);
    // }

}
