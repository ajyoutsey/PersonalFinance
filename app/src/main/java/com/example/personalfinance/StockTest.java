package com.example.personalfinance;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class StockTest extends AppCompatActivity {

    private double currentPrice;
    private String name;
    private int quantity;
    private double price;
    private String url;
    private JSONObject prices;

    public StockTest(String n, int q, double p) {
        quantity = q;
        name = n;
        price = p;
        url = "https://financialmodelingprep.com/api/v3/stock/real-time-price/" + n;

        RequestQueue request = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, response -> {
            prices = response;
        }, error -> {

        });
        request.add(jsonObjectRequest);
        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(stockUrl.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }

        } catch (Exception e) {

        }*/

    }

    public void updatePrice() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, response -> {
            prices = response;
        }, error -> {

        });
        try {
            price = prices.getDouble("price");
        } catch (Exception e) {

        }

    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

}
