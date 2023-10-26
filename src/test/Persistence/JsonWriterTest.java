package Persistence;

import model.Tour;
import model.TouristPlace;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{


    @Test
    void testWriterInvalidFile() {
        try {
            Tour tour = new Tour();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Tour tour = new Tour();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTour.json");
            writer.open();
            writer.write(tour);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterEmptyTour.json");
            tour = reader.read();
            assertEquals(0, tour.getTouristPlacesList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Tour tour = new Tour();
            tour.addTouristPlace(new TouristPlace("Waterfront", "Vancouver", "Canada",
                    "Waterfront Station", 4, 0));
            tour.addTouristPlace(new TouristPlace("Wreck Beach", "Vancouver", "Canada",
                    "UBC BUS LOOP", 5, 30));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTour.json");
            writer.open();
            writer.write(tour);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTour.json");
            tour = reader.read();
            List<TouristPlace> touristPlaces = tour.getTouristPlacesList();
            assertEquals(2, touristPlaces.size());
            checkTouristPlace("Waterfront", "Vancouver", "Canada",
                    "Waterfront Station", 4, 0, touristPlaces.get(0));

            checkTouristPlace("Wreck Beach", "Vancouver", "Canada",
                    "UBC BUS LOOP", 5, 30, touristPlaces.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}
