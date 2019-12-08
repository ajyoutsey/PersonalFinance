package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.ArrayList;



public class LaunchActivity extends AppCompatActivity {

    private static ArrayList<Account> accountList;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Button createAccount = findViewById(R.id.createAccount);
        createAccount.setVisibility(View.VISIBLE);
        createAccount.setOnClickListener(unchecked -> createAccount());
        accountList = new ArrayList<Account>();
    }

    public void createAccount() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }

    public static void addAccount(Account a) {
        accountList.add(a);
    }
}
