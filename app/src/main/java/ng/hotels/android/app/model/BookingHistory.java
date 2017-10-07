package ng.hotels.android.app.model;

/**
 * Created by abdulrahman on 10/6/17.
 */

public class BookingHistory {

    private int bookingType;
    private String partyName;
    private String departureTime;
    private String arrivalTime;
    private String dayMonth;
    private int date;
    private String booking;
    private String price;



    public BookingHistory() {
    }

    public BookingHistory(int bookingType, String partyName, String departureTime,
                          String arrivalTime, String dayMonth, int date, String booking,
                          String price) {
        this.bookingType = bookingType;
        this.partyName = partyName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.dayMonth = dayMonth;
        this.date = date;
        this.booking = booking;
        this.price = price;
    }

    public int getBookingType() {
        return bookingType;
    }

    public void setBookingType(int bookingType) {
        this.bookingType = bookingType;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
