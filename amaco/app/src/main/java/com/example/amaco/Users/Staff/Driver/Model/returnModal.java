package com.example.amaco.Users.Staff.Driver.Model;

public class returnModal {

    private String bookingID;
    private String clientName;
    private String dateToDeliver;
    private String location;
    private String returnStatus;
    private String county;
    private String town;

    public returnModal(String bookingID, String clientName, String dateToDeliver,
                       String location, String returnStatus, String county, String town) {
        this.bookingID = bookingID;
        this.clientName = clientName;
        this.dateToDeliver = dateToDeliver;
        this.location = location;
        this.returnStatus = returnStatus;
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

    public String getReturnStatus() {
        return returnStatus;
    }

    public String getCounty() {
        return county;
    }

    public String getTown() {
        return town;
    }
}
