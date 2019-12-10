package com.example.personalfinance;

public class Stock {

    private String name;
    private int quantity;
    private double price;
    private double currentPrice;
    private double balance;

    public Stock(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public void setCurrentPrice(double p) { currentPrice = p;}
    public void setBalance(double p) { balance = p; };
    public double getCurrentPrice() { return currentPrice;}
    public double getBalance() { return balance;}
}
