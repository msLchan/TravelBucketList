package persistence;

// Note: this code is adapted from the provided example JsonSerializationDemo
import org.json.JSONObject;

public @interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
