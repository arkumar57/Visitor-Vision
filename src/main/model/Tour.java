package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of tourist places and calculate average price and average rating for all tourist places in the list

public class Tour {
    protected List<TouristPlace> touristPlacesList;
    private double averageRat;

    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Initiate the constructors with a new Arraylist of touristPlaces
    public Tour() {
        this.touristPlacesList = new ArrayList<>();
        averageRat = 0;
    }


    //MODIFIES:this
    //EFFECTS:returns a list of tourist places
    public List<TouristPlace> getTouristPlacesList() {
        return touristPlacesList;
    }

    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Adds a tourist place to a list of tourist places
    public void addTouristPlace(TouristPlace touristPlace) {
        this.touristPlacesList.add(touristPlace);
    }


    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Checks if tourists place list is empty and returns average rating of all the tourist places in the list
    public double averageRating() {

        double totalRating = 0;
        double totalPlaces = 0;


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
        double averageCos = 0.0;

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


}
