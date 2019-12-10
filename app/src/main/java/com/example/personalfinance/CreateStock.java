package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateStock extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_stock);
        Button addStock = findViewById(R.id.addStock);
        addStock.setVisibility(View.VISIBLE);
        addStock.setOnClickListener(unchecked -> addStock());
        Button cancelStock = findViewById(R.id.cancelStock);
        cancelStock.setVisibility(View.VISIBLE);
        cancelStock.setOnClickListener(unchecked -> cancelStock());
    }

    public void addStock() {
        EditText stockName = findViewById(R.id.createStockName);
        EditText stockQuantity = findViewById(R.id.stockQuantity);
        EditText stockBoughtAt = findViewById(R.id.stockBoughtAt);
        String name = stockName.getText().toString();
        String quantity = stockQuantity.getText().toString();
        String boughtAt = stockBoughtAt.getText().toString();
        int quantityStock = Integer.parseInt(quantity);
        double price = Double.parseDouble(boughtAt);
        Stock stock = new Stock(name, quantityStock, price);
        MainActivity.addStock(stock);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void cancelStock() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
