package com.shyamkumar.gpa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
    private Integer Sum;
    private float GPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
try {
    Sum = getIntent().getExtras().getInt("sum", 0);
    GPA = getIntent().getExtras().getFloat("gpa", 0);
    TextView textSum = findViewById(R.id.textSum);
    TextView textPercent = findViewById(R.id.textPercent);
    TextView textGPA = findViewById(R.id.textGPA);
//
    textSum.setText(": " + Sum);
        double percent = Sum / 10.0;
        textPercent.setText(": " + percent + "%");
        textGPA.setText(": " + GPA / 10.0);
}catch (Exception e){
    Toast.makeText(getApplicationContext(), "Sorry !!!", Toast.LENGTH_LONG).show();
}
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
