package persistence;

import org.json.JSONObject;

// Note: this code is adapted from the provided example JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
