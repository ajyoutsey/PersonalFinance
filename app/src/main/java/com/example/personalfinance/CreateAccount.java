package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Button addAccount = findViewById(R.id.addAccount);
        addAccount.setVisibility(View.VISIBLE);
        addAccount.setOnClickListener(unchecked -> addAccount());
        Button cancelAccount = findViewById(R.id.cancelAccount);
        cancelAccount.setVisibility(View.VISIBLE);
        cancelAccount.setOnClickListener(unchecked -> cancelAccount());
    }

    public void addAccount() {
        EditText accountName = findViewById(R.id.createAccountName);
        EditText accountBalance = findViewById(R.id.accountBalance);
        String name = accountName.getText().toString();
        String bal = accountBalance.getText().toString();
        double balance = Double.parseDouble(bal);
        Account newAccount = new Account(name, balance);
        LaunchActivity.addAccount(newAccount);
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
        finish();
    }

    public void cancelAccount() {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
        finish();
    }
}
