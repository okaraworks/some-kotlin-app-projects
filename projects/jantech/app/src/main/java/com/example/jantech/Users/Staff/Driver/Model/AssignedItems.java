package com.example.jantech.Users.Staff.Driver.Model;

public class AssignedItems {

    private String itemName;
    private String quantity;

    public AssignedItems(String itemName, String quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public String getQuantity() {
        return quantity;
    }

}
