package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        Button returnHome = findViewById(R.id.returnHome);
        createEvent.setOnClickListener(unchecked -> createEvent());
        deleteAccount.setOnClickListener(unchecked -> deleteAccount());
        returnHome.setOnClickListener(unchecked -> goHome());
        Account acc = LaunchActivity.getAccountList().get(accountIndex);
        ArrayList<Event> temp = acc.getEventList();
        for (Event e : temp) {
            View eventChunk = getLayoutInflater().inflate(R.layout.chunk_new_event, null, false);
            TextView date = eventChunk.findViewById(R.id.date);
            TextView description = eventChunk.findViewById(R.id.eventName);
            TextView amount = eventChunk.findViewById(R.id.eventAmount);
            int eventDate = e.getDate();
            String eventName = e.getEventType();
            double eventAmount = e.getAmount();
            String dateString = " " + eventDate;
            String amountString = " " + eventAmount;
            date.setText(dateString);
            description.setText(eventName);
            amount.setText(amountString);
        }
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

    public void goHome() {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
        finish();
    }
}
