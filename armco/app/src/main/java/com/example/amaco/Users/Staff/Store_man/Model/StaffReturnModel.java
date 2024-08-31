package com.example.amaco.Users.Staff.Store_man.Model;

public class StaffReturnModel {

    private String name;
    private String bookingNo;
    private String returnStatus;
    private String phoneNo;


    public StaffReturnModel(String name, String bookingNo,
                            String returnStatus, String phoneNo) {
        this.name = name;
        this.bookingNo = bookingNo;
        this.returnStatus = returnStatus;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
