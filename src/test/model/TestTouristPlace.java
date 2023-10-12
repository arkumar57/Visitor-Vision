package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTouristPlace {
    private TouristPlace touristPlace;


    @BeforeEach
    void runBefore() {
        touristPlace = new TouristPlace("Waterfront", "Vancouver", "Canada",
                "Waterfront Station", 4, 0);

    }

    @Test
    void test1() {
        assertEquals("Waterfront", touristPlace.getName());
        assertEquals("Vancouver", touristPlace.getCity());
        assertEquals("Canada", touristPlace.getCountry());
        assertEquals("Waterfront Station", touristPlace.getLocation());
        assertEquals(4, touristPlace.getRating());
        assertEquals(0, touristPlace.getPrice());

    }


}