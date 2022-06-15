package com.george.wallet_desktop.model;

public class ObligatoryPayment {
    String name;
    String category;
    int price;
    String date;
    String frequency;

    public ObligatoryPayment(String name, String category, int price, String date, String frequency) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.date = date;
        this.frequency = frequency;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public int getPrice() {
        return price;
    }
    public String getDate() {
        return date;
    }
    public String getFrequency() {
        return frequency;
    }
}