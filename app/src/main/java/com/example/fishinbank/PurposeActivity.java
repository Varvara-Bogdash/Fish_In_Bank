package com.example.fishinbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class PurposeActivity extends AppCompatActivity {
TextView allCountText;
TextView countText;
String allMoney;
String money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);

        allCountText = findViewById(R.id.allCountText);
        countText = findViewById(R.id.cointText);


    }

    public void wallet(View view) {
    }

    public void addCount(View view) {
        Intent intent = new Intent(this, AddPurposeActivity.class);
        startActivity(intent);
        money = getIntent().getStringExtra("money");
        allMoney = getIntent().getStringExtra("allMoney");

        allCountText.append(allMoney);
       countText.append(money);
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void author(View view) {
        Intent intent = new Intent(this, AuthorClass.class);
        startActivity(intent);
    }
}