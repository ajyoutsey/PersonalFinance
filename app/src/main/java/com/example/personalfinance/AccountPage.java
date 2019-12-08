package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AccountPage extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        int accountIndex = LaunchActivity.getCurrentAccount();
        TextView pageName = findViewById(R.id.pageName);
        TextView pageBalance = findViewById(R.id.pageBalance);
        String name = LaunchActivity.getAccountList().get(accountIndex).getAccountName();
        double bal = LaunchActivity.getAccountList().get(accountIndex).getAccountTotal();
        pageName.setText(name);
        String balance = " " + bal;
        pageBalance.setText(balance);
        Button createEvent = findViewById(R.id.createEvent);
        Button deleteAccount = findViewById(R.id.deleteAccount);
        createEvent.setOnClickListener(unchecked -> createEvent());
        deleteAccount.setOnClickListener(unchecked -> deleteAccount());
        for ()
    }

    public void createEvent() {
        Intent intent = new Intent(this, CreateEvent.class);
        startActivity(intent);
        finish();
    }

    public void deleteAccount() {
        ArrayList<Account> temp = LaunchActivity.getAccountList();
        temp.remove(LaunchActivity.getCurrentAccount());
        LaunchActivity.setAccountList(temp);
    }
}
