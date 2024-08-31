package com.krypt.djacademy.Users.Staff.Supervisor.Model;

public class FinesModel {
    private String bookingID;
    private String clientName;
    private String penaltyID;
    private String mpesaCode;
    private String amount;
    private String remarks;
    private String penaltyStatus;

    public FinesModel(String bookingID, String clientName, String penaltyID,
                      String mpesaCode, String amount, String remarks, String penaltyStatus) {
        this.bookingID = bookingID;
        this.clientName = clientName;
        this.penaltyID = penaltyID;
        this.mpesaCode = mpesaCode;
        this.amount = amount;
        this.remarks = remarks;
        this.penaltyStatus = penaltyStatus;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPenaltyID() {
        return penaltyID;
    }

    public String getMpesaCode() {
        return mpesaCode;
    }

    public String getAmount() {
        return amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getPenaltyStatus() {
        return penaltyStatus;
    }
}
