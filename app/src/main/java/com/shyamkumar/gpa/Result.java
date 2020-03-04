package com.shyamkumar.gpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView textSum, textGPA, textPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String Sum = getIntent().getStringExtra("Sum");
        String Percent = getIntent().getStringExtra("Percent");
        String GPA = getIntent().getStringExtra("Gpa");

        textSum = findViewById(R.id.textSum);
        textPercent = findViewById(R.id.textPercent);
        textGPA = findViewById(R.id.textGPA);

        textSum.setText(Sum);
        textPercent.setText(Percent);
        textGPA.setText(GPA);
    }

    public void gotoBack(View view) {
        finish();
    }

    public void hotExit(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
}
