package ui;

import model.Tour;
import model.TouristPlace;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Visitor Vision Application

public class VisitorVision {

    private static final String JSON_STORE = "./data/tour.json";
    private Scanner input;
    private TouristPlace touristPlace;
    private Tour tour;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public VisitorVision() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runVision();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runVision() {
        boolean keepGoing = true;
        String command = null;
        init();
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addTouristDestination();
        } else if (command.equals("l")) {
            listOfTouristPlaces();
        } else if (command.equals("c")) {
            averagePrice();
        } else if (command.equals("r")) {
            averageOpinion();
        } else if (command.equals("s")) {
            saveTour();
        }  else if (command.equals("w")) {
            loadTour();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes input and the tour
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        tour = new Tour();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tA -> add Tourist Destination");
        System.out.println("\tL -> Current List Of Tourist Places");
        System.out.println("\tC -> Average Cost In A City");
        System.out.println("\tR -> Average Rating Of Tourist Places In THE LIST");
        System.out.println("\ts -> save work room to file");
        System.out.println("\tw -> load work room from file");

    }


    // MODIFIES: this
    // EFFECTS:add tourist places to the list
    private void addTouristDestination() {
        // print to ask something
        // ask for input from user
        // string command = userinput

        System.out.println("\tAdd the name of the place");
        String n = input.next();

        System.out.println("\tAdd the City of the place");
        String c = input.next();

        System.out.println("\tAdd the Country of the place");
        String co = input.next();

        System.out.println("\tAdd the Location of the place");
        String l = input.next();

        System.out.println("\tAdd the Rating of the place");
        int r = input.nextInt();
        checkRating(r);


        System.out.println("\tAdd the Price of the place");
        int p = input.nextInt();

        touristPlace = new TouristPlace(n,c,co,l,r,p);
        tour.addTouristPlace(touristPlace);

    }

    // MODIFIES: this
    // EFFECTS:check whether rating is at most 5
    private void checkRating(int r) {
        if (r > 5) {
            System.out.println("\tinvalid");
            int x = input.nextInt();
        }
    }

    // MODIFIES: this
    // EFFECTS:gets the list of all the tourist places added by user.
    private void listOfTouristPlaces() {

        int y = 0;

        for (TouristPlace x : tour.getTouristPlacesList()) {

            y += 1;
            System.out.println("Tourist Place No: " + y);
            System.out.println("Name: " + x.getName());
            System.out.println("City: " + x.getCity());
            System.out.println("Country: " + x.getCountry());
            System.out.println("Location: " + x.getLocation());
            System.out.println("Price: " + x.getPrice());
            System.out.println("Rating: " + x.getRating());


        }
    }


    // MODIFIES: this
    // EFFECTS:gets the average price of visiting all the tourist places added by user.
    private void averagePrice() {

        System.out.println(tour.averageCost());
    }

    // MODIFIES: this
    // EFFECTS:gets the average rating of all the tourist place added by user.
    private void averageOpinion() {

        System.out.println(tour.averageRating());
    }

    // EFFECTS: saves the Tour to file
    private void saveTour() {
        try {
            jsonWriter.open();
            jsonWriter.write(tour);
            jsonWriter.close();
            System.out.println("Saved " + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads Tour from file
    private void loadTour() {
        try {
            tour = jsonReader.read();
            System.out.println("Loaded " + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
