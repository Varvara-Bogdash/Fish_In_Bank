package com.example.fishinbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddPurposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purpose);
    }

    public void save(View view) {
        Intent intent = new Intent(this, PurposeActivity.class);
        startActivity(intent);
    }

    public void house(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}