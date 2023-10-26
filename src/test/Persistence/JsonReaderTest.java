package Persistence;

import model.Tour;
import model.TouristPlace;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Tour tour = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTour() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTour.json");
        try {
            Tour tour = reader.read();
            assertEquals(0, tour.getTouristPlacesList().size());
        } catch (IOException e) {
           // pass
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTour.json");
        try {
            Tour tour = reader.read();
            List<TouristPlace> touristPlaces = tour.getTouristPlacesList();
            assertEquals(2, touristPlaces.size());
            checkTouristPlace("Waterfront", "Vancouver", "Canada",
                    "Waterfront Station", 4, 0, touristPlaces.get(0));

            checkTouristPlace("Wreck Beach", "Vancouver", "Canada",
                    "UBC BUS LOOP", 6, 30, touristPlaces.get(1));
        } catch (IOException e) {
            // pass
        }
    }



}
