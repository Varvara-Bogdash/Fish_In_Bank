package com.example.fishinbank;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PurposeActivity extends AppCompatActivity {
    TextView allCountText;
    TextView countText;
    String allMoney;
    String money;
    SaveClass saveClass;
    int plusCount;
    int plusAllCount;
    int minusCount;
    int minusAllCount;


    ActivityResultLauncher<Intent> addPurposeLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();
                        allMoney = data.getStringExtra("allMoney");
                        money = data.getStringExtra("money");

                        // Обновляем TextView с нужными надписями и значениями
                        if (allMoney != null && !allMoney.isEmpty()) {
                            allCountText.setText("Желаемая сумма: " + allMoney);
                        }
                        if (money != null && !money.isEmpty()) {
                            countText.setText("Накоплено: " + money);
                        }
                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);

        allCountText = findViewById(R.id.allCountText);
        countText = findViewById(R.id.cointText);
        allCountText.setFreezesText(true);
        countText.setFreezesText(true);
        saveClass = new SaveClass();
        saveClass.saveText(countText, allCountText, allMoney, money);
    }

    public void addCount(View view) {
        Intent intent = new Intent(this, AddPurposeActivity.class);
        addPurposeLauncher.launch(intent);
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void author(View view) {
        Intent intent = new Intent(this, AuthorClass.class);
        startActivity(intent);
    }

    public void wallet(View view) {
        Intent intent = new Intent(this, ChargeActivity.class);
        startActivity(intent);
    }

    public void minusCount(View view) {
        minusCount -= 500;
        countText.append(String.valueOf(minusCount));
    }

    public void plusCount(View view) {
        plusCount += 1000;
        countText.append(String.valueOf(plusCount));
    }

    public void plusAllCount(View view) {
        plusAllCount += 1000;
        allCountText.append(String.valueOf(plusAllCount));
    }

    public void minusAllCount(View view) {
        minusAllCount -= 500;
        allCountText.append(String.valueOf(minusAllCount));
    }
}