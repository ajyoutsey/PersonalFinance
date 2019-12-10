package com.example.personalfinance;

public class Stock {

    private String name;
    private int quantity;
    private double price;

    public Stock(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
