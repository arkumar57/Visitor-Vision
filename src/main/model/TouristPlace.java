package model;

public class TouristPlace {
    private String name;
    private String city;
    private String country;
    private String location;
    private String typeofPlace;
    private String speciality;
    private String guidelines;
    private String writtenReview;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTypeofPlace() {
        return typeofPlace;
    }

    public void setTypeofPlace(String typeofPlace) {
        this.typeofPlace = typeofPlace;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getWrittenReview() {
        return writtenReview;
    }

    public void setWrittenReview(String writtenReview) {
        this.writtenReview = writtenReview;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
