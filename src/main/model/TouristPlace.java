package model;

// Represents a tourist place having a name, city, country, location, rating, and price

public class TouristPlace {
    private String name;
    private String city;
    private String country;
    private String location;
    private int rating;
    private int price;

    // EFFECTS: Initialise a tourist place
    public TouristPlace(String name, String city, String country, String location, int rating, int price) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.location = location;
        this.rating = rating;
        this.price = price;


    }

    //MODIFIES:this
    //EFFECTS: gets the name of the tourist place
    public String getName() {
        return name;
    }



    //MODIFIES:this
    //EFFECTS: gets the city of the tourist place
    public String getCity() {
        return city;
    }



    //MODIFIES:this
    //EFFECTS: gets the country of the tourist place
    public String getCountry() {
        return country;
    }



    //MODIFIES:this
    //EFFECTS: gets the location of the tourist place
    public String getLocation() {
        return location;
    }



    //MODIFIES:this
    //EFFECTS: gets the rating of the tourist place
    public int getRating() {
        return rating;
    }



    //MODIFIES:this
    //EFFECTS: gets the price of visiting the tourist place
    public int getPrice() {
        return price;
    }

}
