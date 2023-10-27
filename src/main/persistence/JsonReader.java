package persistence;

import model.Tour;
import model.TouristPlace;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads tour from JSON data stored in file
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads tour from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Tour read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTour(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses tour from JSON object and returns it
    private Tour parseTour(JSONObject jsonObject) {
        Tour tour = new Tour();
        addTouristPlaces(tour, jsonObject);
        return tour;
    }

    // MODIFIES: tour
    // EFFECTS: parses tourist places from JSON object and adds them to tour
    private void addTouristPlaces(Tour tour, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Tourist Places");
        for (Object json : jsonArray) {
            JSONObject touristPlace = (JSONObject) json;
            addTouristPlace(tour, touristPlace);
        }
    }

    // MODIFIES: tour
    // EFFECTS: parses tourist place from JSON object and adds it to tour
    private void addTouristPlace(Tour tour, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String city = jsonObject.getString("city");
        String country = jsonObject.getString("country");
        String location = jsonObject.getString("location");
        int rating = jsonObject.getInt("rating");
        int price = jsonObject.getInt("price");


        TouristPlace touristPlace = new TouristPlace(name, city, country, location, rating, price);
        tour.addTouristPlace(touristPlace);
    }



}
