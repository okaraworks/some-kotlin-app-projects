package com.example.amaco.KAEWAMODELS;

public class DriversModel {

    private String driverID;
    private String driverName;
    private String orderID;

    public DriversModel(String driverID, String driverName, String orderID) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.orderID = orderID;
    }

    public String getDriverID() {
        return driverID;
    }

    public String getDriverName() {

        return driverName;
    }

    public String getOrderID() {
        return orderID;
    }
}
