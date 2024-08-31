package com.krypt.MALO.Users.Staff.Modal;

public class BookingModal {
    private final String bookingNo;
    private final String name;
    private final String bookingCost;
    private final String mpesaCode;
    private final String bookingDate;
    private final String bookingStatus;
    private final String deliveryCost;
    private final String dateToDeliver;
    private final String county;
    private final String town;
    private final String bookingRemarks;

    public BookingModal(String bookingNo, String name, String bookingCost, String mpesaCode,
                        String bookingDate,
                        String bookingStatus, String deliveryCost, String dateToDeliver,
                        String county, String town, String bookingRemarks) {
        this.bookingNo = bookingNo;
        this.name = name;
        this.bookingCost = bookingCost;
        this.mpesaCode = mpesaCode;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.deliveryCost = deliveryCost;
        this.dateToDeliver = dateToDeliver;
        this.county = county;
        this.town = town;
        this.bookingRemarks = bookingRemarks;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public String getName() {
        return name;
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

    public String getCounty() {
        return county;
    }

    public String getTown() {
        return town;
    }

    public String getBookingRemarks() {
        return bookingRemarks;
    }
}
