package ui;

import model.Tour;
import model.TouristPlace;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.WindowAdapter;

public class VisitorVisionGUI extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton addTouristPlace = new JButton("AddTouristPlace");
    private JButton listOfTouristPlace = new JButton("ListOfTouristPlace");
    private JButton averageRating = new JButton("Average Rating");
    private JButton averagePrice = new JButton("Average Price");
    private JButton saveData = new JButton("Save Data");
    private JButton loadData = new JButton("load Data");
    ImageIcon icon = new ImageIcon("./data/Project.png");
    JLabel label = new JLabel(icon);

    private static final String JSON_STORE = "./data/tour.json";
    private Scanner input;
    private TouristPlace touristPlace;
    private Tour tour;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public VisitorVisionGUI() throws FileNotFoundException {
        init();
        setButton();
        frameSet();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                e.getWindow().dispose();
                System.out.println("JFrame Closed!");
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: initializes input and the tour
    private void init() {
        tour = new Tour();
    }



    public void setButton() {
        addTouristPlace.setBounds(100,160,200,40);
        addTouristPlace.setFocusable(false);
        addTouristPlace.addActionListener(this);
        listOfTouristPlace.setBounds(100,220,200,40);
        listOfTouristPlace.setFocusable(false);
        listOfTouristPlace.addActionListener(this);
        averageRating.setBounds(100,280,200,40);
        averageRating.setFocusable(false);
        averageRating.addActionListener(this);
        averagePrice.setBounds(100,340,200,40);
        averagePrice.setFocusable(false);
        averagePrice.addActionListener(this);
        saveData.setBounds(100,460,200,40);
        saveData.setFocusable(false);
        saveData.addActionListener(this);
        loadData.setBounds(100,520,200,40);
        loadData.setFocusable(false);
        loadData.addActionListener(this);
    }

    public void frameSet() {
        frame.setContentPane(label);
        frame.add(addTouristPlace);
        frame.add(listOfTouristPlace);
        frame.add(averageRating);
        frame.add(averagePrice);
        frame.add(saveData);
        frame.add(loadData);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,700);
        frame.setVisible(true);
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveData) {
            saveTour();
        }
        if (e.getSource() == loadData) {
            loadTour();
        }
        if (e.getSource() == addTouristPlace) {
            addTouristDestination();
        }

        if (e.getSource() == listOfTouristPlace) {
            listOfTouristPlaces();
        }

        if (e.getSource() == averageRating) {
            averageOpinion();
        }

        if (e.getSource() == averagePrice) {
            averagePrice();
        }

    }


    private void saveTour() {
        try {
            jsonWriter.open();
            jsonWriter.write(tour);
            jsonWriter.close();
            System.out.println("Saved " + " to " + JSON_STORE);
            JOptionPane.showMessageDialog(this,"saved " + this.tour + " to ./data/tour.json");
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
            JOptionPane.showMessageDialog(this,"Loaded " + this.tour + " from ./data/tour.json");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    private void addTouristDestination() {
        // print to ask something
        // ask for input from user
        // string command = userinput

        String n = JOptionPane.showInputDialog(this, "\tAdd the name of the place ");


        String c = JOptionPane.showInputDialog(this, "\tAdd the City of the place ");


        String co = JOptionPane.showInputDialog(this, "\tAdd the Country of the place ");


        String l = JOptionPane.showInputDialog(this, "\tAdd the Location of the place ");


        int r = Integer.parseInt(JOptionPane.showInputDialog(this,
                "\tAdd the Rating of the place "));
        checkRating(r);


        int p = Integer.parseInt(JOptionPane.showInputDialog(this,
                "\tAdd the Price of the place "));

        touristPlace = new TouristPlace(n,c,co,l,r,p);
        tour.addTouristPlace(touristPlace);

    }


    private void checkRating(int r) {
        if (r > 5) {
            System.out.println("\tinvalid");
            int x = input.nextInt();
        }
    }


    private void listOfTouristPlaces() {

        int y = 0;

        for (TouristPlace x : tour.getTouristPlacesList()) {

            y += 1;
            JOptionPane.showMessageDialog(this, "tourist Place: " + y + ": " + "\n" + " Name: "
                    + x.getName()
                    + "\n" + "\t City: " + x.getCity() + "\n" + "\t Country: " + x.getCountry() + "\n" + "\t Location: "
                    + x.getLocation() + "\n" + "\t Price: " + x.getPrice() + "\n" + "\t Rating: " + x.getRating());

        }
    }

    private void averagePrice() {

        JOptionPane.showInputDialog(this, tour.averageCost());
    }

    // MODIFIES: this
    // EFFECTS:gets the average rating of all the tourist place added by user.
    private void averageOpinion() {

        JOptionPane.showInputDialog(this, tour.averageRating());
    }








}
