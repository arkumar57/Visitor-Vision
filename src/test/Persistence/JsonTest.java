package Persistence;

import model.TouristPlace;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkTouristPlace(String name, String city, String country, String location, int rating, int price,
                                     TouristPlace touristPlace) {
        assertEquals(name, touristPlace.getName());
        assertEquals(city, touristPlace.getCity());
        assertEquals(country, touristPlace.getCountry());
        assertEquals(location, touristPlace.getLocation());
        assertEquals(rating, touristPlace.getRating());
        assertEquals(price, touristPlace.getPrice());
    }
}
