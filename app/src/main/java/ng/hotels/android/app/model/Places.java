package ng.hotels.android.app.model;

/**
 * Created by Nsikak on 10/1/17.
 */

public class Places {
    int place_image;
    String place_name;
    String place_descriptions;

    public Places(int place_image, String place_name, String place_descriptions) {
        this.place_image = place_image;
        this.place_name = place_name;
        this.place_descriptions = place_descriptions;
    }

    public int getPlace_image() {
        return place_image;
    }

    public void setPlace_image(int place_image) {
        this.place_image = place_image;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_descriptions() {
        return place_descriptions;
    }

    public void setPlace_descriptions(String place_descriptions) {
        this.place_descriptions = place_descriptions;
    }
}
