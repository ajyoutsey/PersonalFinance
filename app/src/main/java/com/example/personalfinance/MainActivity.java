package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Account> accountList = new ArrayList<Account>();

    private static ArrayList<Stock> stockList = new ArrayList<Stock>();

    private double balance;

    private static int currentAccount;

    private static int currentStock;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createAccount = findViewById(R.id.createAccount);
        createAccount.setVisibility(View.VISIBLE);
        createAccount.setOnClickListener(unchecked -> createAccount());
        LinearLayout accList = findViewById(R.id.accountList);
        for (Account a : accountList) {
            View accountChunk = getLayoutInflater().inflate(R.layout.chunk_new_account, null, false);
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
            View stockChunk = getLayoutInflater().inflate(R.layout.chunk_new_stock, null, false);
            TextView stockName = stockChunk.findViewById(R.id.chunkStockName);
            TextView stockTotal = stockChunk.findViewById(R.id.chunkStockTotal);
            stockName.setText(s.getName());
            int quantity = s.getQuantity();
            s.setStockPrice(s.getName());
            double currentPrice = s.getCurrentPrice();
            double stockCurrentTotal = quantity * currentPrice;
            String total = Double.toString(stockCurrentTotal);
            balance += stockCurrentTotal;
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
        Intent intent = new Intent(this, StockPage.class);
        startActivity(intent);
        finish();
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
}
