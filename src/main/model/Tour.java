package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a list of tourist places and calculate average price and average rating for all tourist places in the list

public class Tour implements Writable {
    protected List<TouristPlace> touristPlacesList;
    private double averageRat;
    private double averageCos;

    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Initiate the constructors with a new Arraylist of touristPlaces
    public Tour() {
        this.touristPlacesList = new ArrayList<>();
        averageRat = 0;
        averageCos = 0;
    }


    //MODIFIES:this
    //EFFECTS:returns a list of tourist places
    public List<TouristPlace> getTouristPlacesList() {
        EventLog.getInstance().logEvent(new Event("Tourist Place list Published."));
        return touristPlacesList;
    }


    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Adds a tourist place to a list of tourist places
    public void addTouristPlace(TouristPlace touristPlace) {
        this.touristPlacesList.add(touristPlace);
        EventLog.getInstance().logEvent(new Event("Tourist Place Added to list."));
    }


    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Checks if tourists place list is empty and returns average rating of all the tourist places in the list
    public double averageRating() {

        double totalRating = 0;
        double totalPlaces = 0;

        EventLog.getInstance().logEvent(new Event("Average Rating of tour Displayed"));
        if (touristPlacesList.isEmpty()) {
            return 0;
        } else {
            for (TouristPlace x:touristPlacesList) {
                totalRating += x.getRating();
                totalPlaces += 1;
            }
        }

        averageRat = totalRating / totalPlaces;
        return  averageRat;

    }


    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Checks if tourists place list is empty and returns average cost of all the tourist places in the list.
    public double averageCost() {
        double totalCost = 0.0;
        double totalPlaces = 0.0;

        EventLog.getInstance().logEvent(new Event("Average Cost of tour Displayed"));
        if (touristPlacesList.isEmpty()) {
            return 0;
        } else {
            for (TouristPlace x:touristPlacesList) {
                totalCost += x.getPrice();
                totalPlaces += 1;
            }
        }

        averageCos = totalCost / totalPlaces;
        return  averageCos;


    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Average Cost", averageCost());
        json.put("Average Rating", averageRating());
        json.put("Tourist Places", touristPlacesToJson());
        return json;
    }

    // EFFECTS: returns tourist places in this tour as a JSON array
    private JSONArray touristPlacesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (TouristPlace t:touristPlacesList) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

}
