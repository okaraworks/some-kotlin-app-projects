package com.krypt.djacademy.Users.Customers.Model;

public class ModalBook {
    private String names;
    private String place;
    private String bookingID;
    private String bookingCost;
    private String mpesaCode;
    private String bookingDate;
    private String bookingStatus;
    private String deliveryCost;
    private String dateToDeliver;
    private String bookingRemarks;

    public ModalBook(String names, String place, String bookingID, String bookingCost, String mpesaCode, String bookingDate, String bookingStatus, String deliveryCost, String dateToDeliver, String bookingRemarks) {
        this.names = names;
        this.place = place;
        this.bookingID = bookingID;
        this.bookingCost = bookingCost;
        this.mpesaCode = mpesaCode;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.deliveryCost = deliveryCost;
        this.dateToDeliver = dateToDeliver;
        this.bookingRemarks = bookingRemarks;
    }

    public String getNames() {
        return names;
    }

    public String getPlace() {
        return place;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getBookingCost() {
        return bookingCost;
    }

    public String getMpesaCode() {
        return mpesaCode;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public String getDateToDeliver() {
        return dateToDeliver;
    }

    public String getBookingRemarks() {
        return bookingRemarks;
    }
}
