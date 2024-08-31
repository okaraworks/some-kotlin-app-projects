package com.example.panafrica.Users.Staff.Driver.Model;

public class AssignModal {

    private String bookingID;
    private String clientName;
    private String dateToDeliver;
    private String location;
    private String bookingStatus;
    private String county;
    private String town;

    public AssignModal(String bookingID, String clientName, String dateToDeliver,
                       String location, String bookingStatus, String county, String town) {
        this.bookingID = bookingID;
        this.clientName = clientName;
        this.dateToDeliver = dateToDeliver;
        this.location = location;
        this.bookingStatus = bookingStatus;
        this.county = county;
        this.town = town;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getDateToDeliver() {
        return dateToDeliver;
    }

    public String getLocation() {
        return location;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getCounty() {
        return county;
    }

    public String getTown() {
        return town;
    }
}
