package model;

public class TouristPlace {
    private String name;
    private String city;
    private String country;
    private String location;
    private int rating;
    private int price;

    public TouristPlace(String name, String city, String country, String location, int rating, int price) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.location = location;
        this.rating = rating;
        this.price = price;


    }

    public String getName() {
        return name;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }


    public String getLocation() {
        return location;
    }


    public int getRating() {
        return rating;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
