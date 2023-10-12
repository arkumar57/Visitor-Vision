package model;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    protected List<TouristPlace> touristPlacesList;

    //REQUIRES:
    //MODIFIES:this
    //EFFECTS:Initiate the constructors with a new Arraylist of touristPlaces
    public Tour() {
        this.touristPlacesList = new ArrayList<>();
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
    public int averageRating() {

        int totalRating = 0;
        int totalPlaces = 0;
        int averageRat = 0;


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
    public int averageCost() {
        int totalCost = 0;
        int totalPlaces = 0;
        int averageCos = 0;

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
