package com.example.jantech.Users.Customers.Model;

public class BookingItemsModal {

    private String itemName;
    private String price;
    private String quantity;
    private String days;
    private String subTotal;
    private String capacity;

    public BookingItemsModal(String itemName, String price, String quantity, String days, String subTotal, String capacity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.days = days;
        this.subTotal = subTotal;
        this.capacity = capacity;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDays() {
        return days;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public String getCapacity() {
        return capacity;
    }
}
