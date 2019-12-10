package com.example.personalfinance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
