package model;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    protected List<TouristPlace> touristPlacesList;

    public Tour() {
        this.touristPlacesList = new ArrayList<>();
    }

    public List<TouristPlace> getTouristPlacesList() {
        return touristPlacesList;
    }

    public void addTouristPlace(TouristPlace touristPlace) {
        this.touristPlacesList.add(touristPlace);
    }


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

    //Average Rating
    //Average Cost of the trip
    //

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
