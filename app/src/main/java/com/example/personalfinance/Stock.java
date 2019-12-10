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

public class Stock extends AppCompatActivity {

    private String name;
    private int quantity;
    private double price;
    private double currentPrice;

    public Stock(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loadStockPrice(String ticker) {
        String url = "https://financialmodelingprep.com/api/v3/stock/real-time-price/" + ticker;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JsonParser parser = new JsonParser();
                        JsonObject root = parser.parse(response).getAsJsonObject();
                        JsonObject price = root.get("price").getAsJsonObject();
                        currentPrice = price.getAsDouble();
                        setCurrentPrice(currentPrice);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
                error.printStackTrace();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

    public void setCurrentPrice(double price) {
        currentPrice = price;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
