package ui;

import model.Tour;
import model.TouristPlace;

import java.util.Scanner;

public class VisitorVision {

    private Scanner input;
    private TouristPlace touristPlace;
    private Tour tour;

    public VisitorVision() {
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
        System.out.println("\tA -> addTouristDestination");
        System.out.println("\tL -> CurrentListOfTouristPlaces");
        System.out.println("\tC -> AverageCostInACity");
        System.out.println("\tR -> AverageRatingOfTouristPlacesInACity");
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

        for (TouristPlace x : tour.getTouristPlacesList()) {

            System.out.println(x.getName());
            System.out.println(x.getCity());
            System.out.println(x.getCountry());
            System.out.println(x.getLocation());
            System.out.println(x.getPrice());
            System.out.println(x.getRating());

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






}
