package com.amarokasia.insurance_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadCalculator(View view){
        Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }

    public  void  loadGuide(View view){
        Intent intent = new Intent(MainActivity.this, GuideActivity.class);
        startActivity(intent);
    }

    public  void  loadHistory(View view){
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}
