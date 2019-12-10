package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Account> accountList = new ArrayList<Account>();

    private static ArrayList<Stock> stockList = new ArrayList<Stock>();

    private double balance;

    private static int currentAccount;

    private static int currentStock;

    private static double currentPrice;


    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createAccount = findViewById(R.id.createAccount);
        createAccount.setVisibility(View.VISIBLE);
        createAccount.setOnClickListener(unchecked -> createAccount());
        LinearLayout accList = findViewById(R.id.accountList);
        for (Account a : accountList) {
            View accountChunk = getLayoutInflater().inflate(R.layout.chunk_new_account, accList, false);
            TextView accName = accountChunk.findViewById(R.id.accountName);
            TextView accTotal = accountChunk.findViewById(R.id.accTotal);
            accName.setText(a.getAccountName());
            String total = Double.toString(a.getAccountTotal());
            balance += a.getAccountTotal();
            accTotal.setText(total);
            accList.addView(accountChunk);
            Button enter = accountChunk.findViewById(R.id.enterAccount);
            enter.setOnClickListener(unchecked -> setIndex(a.getAccountName(), a.getAccountTotal()));
        }
        LinearLayout stocks = findViewById(R.id.stockList);
        for (Stock s : stockList) {
            View stockChunk = getLayoutInflater().inflate(R.layout.chunk_new_stock, stocks, false);
            TextView stockName = stockChunk.findViewById(R.id.chunkStockName);
            TextView stockTotal = stockChunk.findViewById(R.id.chunkStockTotal);
            stockName.setText(s.getName());
            int quantity = s.getQuantity();
            loadStockPrice(s.getName());
            double currentPrice = getCurrentPrice();
            s.setCurrentPrice(currentPrice);
            double stockCurrentTotal = quantity * currentPrice;
            s.setBalance(stockCurrentTotal);
            System.out.println("Stock current total " + stockCurrentTotal);
            String total = Double.toString(stockCurrentTotal);
            balance += s.getBalance();
            stockTotal.setText(total);
            stocks.addView(stockChunk);
            Button enter = stockChunk.findViewById(R.id.chunkEnterStock);
            enter.setOnClickListener(unchecked -> setStockIndex(s.getName()));
        }
        TextView totalBalance = findViewById(R.id.totalBalance);
        String bal = Double.toString(balance);
        totalBalance.setText(bal);
        Button createStock = findViewById(R.id.createStockAccount);
        createStock.setOnClickListener(unchecked -> createStock());
    }

    public void createAccount() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }

    public void createStock() {
        Intent intent = new Intent(this, CreateStock.class);
        startActivity(intent);
        finish();
    }

    public static void addAccount(Account a) {
        accountList.add(a);
    }

    public static void addStock(Stock s) { stockList.add(s); }

    public void setIndex(String name, double bal) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountName().equals(name)
                    && accountList.get(i).getAccountTotal() == bal) {
                currentAccount = i;
            }
        }
        enterAccount();
    }

    public void setStockIndex(String name) {
        for (int i = 0; i < stockList.size(); i++) {
            if (stockList.get(i).getName().equals(name)) {
                currentStock = i;
            }
        }
        enterStock();
    }

    public void enterAccount() {
        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);
        finish();
    }

    public void enterStock() {
        loadStockPrice(stockList.get(currentStock).getName());
        Intent intent = new Intent(this, StockPage.class);
        startActivity(intent);
        finish();
    }

    public void loadStockPrice(String ticker) {
        String url = "https://financialmodelingprep.com/api/v3/stock/real-time-price/" + ticker;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JsonParser parser = new JsonParser();
                        JsonObject root = parser.parse(response).getAsJsonObject();
                        currentPrice = root.get("price").getAsDouble();
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


    public static void setAccountList(ArrayList<Account> a) {
        accountList = a;
    }
    public static ArrayList<Account> getAccountList() {
        return accountList;
    }
    public static int getCurrentAccount() {
        return currentAccount;
    }
    public static int getCurrentStock() { return currentStock; }
    public static ArrayList<Stock> getStockList() { return stockList; }
    public static void setStockList(ArrayList<Stock> s) { stockList = s; }

    public static void setCurrentPrice(double price) {
        currentPrice = price;
    }
    public static double getCurrentPrice() {
        return currentPrice;
    }
}
