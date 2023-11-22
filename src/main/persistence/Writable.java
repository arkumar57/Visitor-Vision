package persistence;

import org.json.JSONObject;

// Referencing for JSON Realisation from JSON SERIALISATION DEMO;
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
