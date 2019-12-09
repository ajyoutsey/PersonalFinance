package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class CreateEvent extends AppCompatActivity {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
        Button addEvent = findViewById(R.id.addEvent);
        addEvent.setVisibility(View.VISIBLE);
        addEvent.setOnClickListener(unchecked -> addEvent());
        Button cancelEvent = findViewById(R.id.cancelEvent);
        cancelEvent.setVisibility(View.VISIBLE);
        cancelEvent.setOnClickListener(unchecked -> cancelEvent());
    }

    public void addEvent() {
        EditText eventName = findViewById(R.id.eventName2);
        EditText eventValue = findViewById(R.id.eventCost);
        EditText eventDate = findViewById(R.id.eventDate);
        Switch eventSign = findViewById(R.id.eventSign);
        String eName = eventName.getText().toString();
        double eValue = Double.parseDouble(eventValue.getText().toString());
        if (eventSign.getTextOn().toString().equals("Negative")) {
            eValue = -eValue;
        }
        String tempEDate = eventDate.getText().toString();
        Account temp = MainActivity.getAccountList().get(MainActivity.getCurrentAccount());
        Event tempE = new Event(eValue, eName, tempEDate);
        temp.addEvent(tempE);
        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);
        finish();
    }
    public void cancelEvent() {
        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);
        finish();
    }
}
