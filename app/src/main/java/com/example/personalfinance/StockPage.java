package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StockPage extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_page);
        int stockIndex = MainActivity.getCurrentStock();
        TextView pageName = findViewById(R.id.stockName);
        TextView pageQuantity = findViewById(R.id.stockQuantity);
        TextView boughtAt = findViewById(R.id.stockBoughtAt);
        TextView currentPrice = findViewById(R.id.currentPrice);
        TextView currentTotal = findViewById(R.id.currentTotal);
        String name = MainActivity.getStockList().get(stockIndex).getName();
        int quantity = MainActivity.getStockList().get(stockIndex).getQuantity();
        double bought = MainActivity.getStockList().get(stockIndex).getPrice();
        Stock s = MainActivity.getStockList().get(stockIndex);
        double current = MainActivity.getCurrentPrice();
        double total = current * quantity;
        pageName.setText(name);
        String q = "" + quantity;
        pageQuantity.setText(q);
        String b = "" + bought;
        boughtAt.setText(b);
        String c = "" + current;
        currentPrice.setText(c);
        String t = "" + total;
        currentTotal.setText(t);
        Button returnHome = findViewById(R.id.stockReturnHome);
        Button delete = findViewById(R.id.deleteStock);
        returnHome.setOnClickListener(unchecked -> returnHome());
        delete.setOnClickListener(unchecked -> delete());
    }

    public void returnHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void delete() {
        ArrayList<Stock> temp = MainActivity.getStockList();
        temp.remove(MainActivity.getCurrentStock());
        MainActivity.setStockList(temp);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
