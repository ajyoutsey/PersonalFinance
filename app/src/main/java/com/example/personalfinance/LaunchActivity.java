package com.example.personalfinance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        for (Account a : accountList) {
            View accountChunk = getLayoutInflater().inflate(R.layout.chunk_new_account, null, false);
            TextView accName = accountChunk.findViewById(R.id.accName);
            TextView accTotal = accountChunk.findViewById(R.id.accTotal);
            accName.setText(a.getAccountName());
            accTotal.setText(a.getAccountTotal());
        }
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
