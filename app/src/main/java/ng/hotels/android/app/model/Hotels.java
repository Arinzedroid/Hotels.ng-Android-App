package ng.hotels.android.app.model;

/**
 * Created by Nsikak on 10/1/17.
 */

public class Hotels {
    String hotel_name;
    String hotel_location;
    String hotel_price;
    int hotel_rating;
    int hotel_image;

    public int getHotel_image() {
        return hotel_image;
    }

    public void setHotel_image(int hotel_image) {
        this.hotel_image = hotel_image;
    }

    public Hotels(){

    }

    public Hotels(String hotel_name, String hotel_location, String hotel_price, int hotel_rating, int hotel_image) {
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.hotel_price = hotel_price;
        this.hotel_rating = hotel_rating;
        this.hotel_image = hotel_image;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(String hotel_price) {
        this.hotel_price = hotel_price;
    }

    public int getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(int hotel_rating) {
        this.hotel_rating = hotel_rating;
    }
}
