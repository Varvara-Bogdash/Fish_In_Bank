package com.example.fishinbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddPurposeActivity extends AppCompatActivity {
public int allMoney;
public int money;
EditText allMoneyText;
EditText moneyText;
TextView allM;
TextView m;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purpose);
        allMoneyText = findViewById(R.id.allMoneyAdd);
        moneyText = findViewById(R.id.moneyAdd);

    }

    public void save(View view) {
        allM.setText(allMoneyText.getText().toString());
        allMoney = Integer.parseInt(allM.getText().toString());

        m.setText(moneyText.getText().toString());
        money = Integer.parseInt(m.getText().toString());

        Intent intent = new Intent(this, PurposeActivity.class);
        intent.putExtra("allMoney", allMoney);
        intent.putExtra("money", money);
        startActivity(intent);
    }

    public void house(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}