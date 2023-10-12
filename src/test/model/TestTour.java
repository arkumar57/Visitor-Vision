package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTour {
    private Tour tour;
    private TouristPlace touristPlace1;
    private TouristPlace touristPlace2;


    @BeforeEach
    void runBefore() {
        tour = new Tour();
        touristPlace1 = new TouristPlace("Waterfront", "Vancouver", "Canada",
                "Waterfront Station",  4, 20);

        touristPlace2 = new TouristPlace("Wreck Beach", "Vancouver", "Canada",
                "UBC BUS LOOP", 6, 30);

    }

    @Test
    void testEmptyTouristPlaceList() {
        assertEquals(0, tour.getTouristPlacesList().size());
    }

    @Test
    void testAdd1TouristPlace() {
        tour.addTouristPlace(touristPlace1);
        assertEquals(1, tour.getTouristPlacesList().size());

    }

    @Test
    void testAdd2TouristPlace() {
        tour.addTouristPlace(touristPlace1);
        tour.addTouristPlace(touristPlace2);
        assertEquals(2, tour.getTouristPlacesList().size());

    }


    @Test
    void testEmptyTouristPlaceListAverageCost() {
        assertEquals(0, tour.getTouristPlacesList().size());
        //

    }

    @Test
    void test1TouristPlaceListAverageRating() {
        tour.addTouristPlace(touristPlace1);
        assertEquals(1, tour.getTouristPlacesList().size());
        assertEquals(4,tour.averageRating());

    }

    @Test
    void test2TouristPlaceListAverageRating() {
        tour.addTouristPlace(touristPlace1);
        tour.addTouristPlace(touristPlace2);
        assertEquals(2, tour.getTouristPlacesList().size());
        assertEquals(5,tour.averageRating());

    }

    @Test
    void test1TouristPlaceListAverageCost() {
        tour.addTouristPlace(touristPlace1);
        assertEquals(1, tour.getTouristPlacesList().size());
        assertEquals(20,tour.averageCost());

    }

    @Test
    void test2TouristPlaceListAverageCost() {
        tour.addTouristPlace(touristPlace1);
        tour.addTouristPlace(touristPlace2);
        assertEquals(2, tour.getTouristPlacesList().size());
        assertEquals(25,tour.averageCost());

    }





}
