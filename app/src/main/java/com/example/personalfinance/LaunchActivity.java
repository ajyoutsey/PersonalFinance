package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LaunchActivity extends AppCompatActivity {

    private static ArrayList<Account> accountList = new ArrayList<Account>();

    private double balance;

    private static int currentAccount;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
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
        TextView totalBalance = findViewById(R.id.totalBalance);
        String bal = Double.toString(balance);
        totalBalance.setText(bal);
    }

    public void createAccount() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }

    public static void addAccount(Account a) {
        accountList.add(a);
    }

    public void setIndex(String name, double balance) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountName().equals(name)
                    && accountList.get(i).getAccountTotal() == balance) {
                currentAccount = i;
            }
        }
        enterAccount();
    }

    public void enterAccount() {
        Intent intent = new Intent(this, AccountPage.class);
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
}
