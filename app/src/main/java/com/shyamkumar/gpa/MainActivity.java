package com.shyamkumar.gpa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;


public class MainActivity extends AppCompatActivity {

//    private TextInputLayout paperLayout1;
	private TextInputEditText paper1;
//    private TextInputLayout paperLayout2;
	private TextInputEditText paper2;
//    private TextInputLayout paperLayout3;
	private TextInputEditText paper3;
//    private TextInputLayout paperLayout4;
	private TextInputEditText paper4;
//    private TextInputLayout paperLayout5;
	private TextInputEditText paper5;
//    private TextInputLayout paperLayout6;
	private TextInputEditText paper6;
//    private TextInputLayout paperLayout7;
	private TextInputEditText paper7;
//    private TextInputLayout paperLayout8;
	private TextInputEditText paper8;
//    private TextInputLayout paperLayout9;
	private TextInputEditText paper9;
//    private TextInputLayout paperLayout10;
	private TextInputEditText paper10;

	private Button btnCalculate;


	// List
	Integer[] marksList = new Integer[10];
	public int sum = 0;
	Integer[] gpaList = new Integer[10];
	public float gpa = 0;
   protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity_main);

	   paper1 = findViewById(R.id.paper1);
	   paper2 = findViewById(R.id.paper2);
	   paper3 = findViewById(R.id.paper3);
	   paper4 = findViewById(R.id.paper4);
	   paper5 = findViewById(R.id.paper5);
	   paper6 = findViewById(R.id.paper6);
	   paper7 = findViewById(R.id.paper7);
	   paper8 = findViewById(R.id.paper8);
	   paper9 = findViewById(R.id.paper9);
	   paper10 = findViewById(R.id.paper10);
	   btnCalculate = findViewById(R.id.button);

	   paper1.addTextChangedListener(rangeCheck);
       paper2.addTextChangedListener(rangeCheck);
       paper3.addTextChangedListener(rangeCheck);
       paper4.addTextChangedListener(rangeCheck);
       paper5.addTextChangedListener(rangeCheck);
       paper6.addTextChangedListener(rangeCheck);
       paper7.addTextChangedListener(rangeCheck);
       paper8.addTextChangedListener(rangeCheck);
       paper9.addTextChangedListener(rangeCheck);
       paper10.addTextChangedListener(rangeCheck);

	   if (getIntent().getBooleanExtra("EXIT", false)) {
		   finish();
	   }

	   paper10.setOnEditorActionListener(new TextView.OnEditorActionListener() {
		   @Override
		   public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		   		if (actionId == IME_ACTION_DONE){
		   			calculateGPA();
				}
			   return false;
		   }
	   });

	   btnCalculate.setOnClickListener(new View.OnClickListener() {
		   @Override
		   public void onClick(View v) {
		   	calculateGPA();
		   }
	   });
   }

   private void calculateGPA(){
   		try {
	   if (Objects.requireNonNull(paper8.getText()).toString().isEmpty()) {
		   if (Objects.requireNonNull(paper1.getText()).toString().isEmpty() && Objects.requireNonNull(paper2.getText()).toString().isEmpty() && Objects.requireNonNull(paper3.getText()).toString().isEmpty() && Objects.requireNonNull(paper4.getText()).toString().isEmpty() && Objects.requireNonNull(paper5.getText()).toString().isEmpty() && Objects.requireNonNull(paper6.getText()).toString().isEmpty() && Objects.requireNonNull(paper7.getText()).toString().isEmpty() && Objects.requireNonNull(paper9.getText()).toString().isEmpty() && Objects.requireNonNull(paper10.getText()).toString().isEmpty()) {
			   Toast.makeText(getApplicationContext(), "All Filed 0.", Toast.LENGTH_LONG).show();
		   }
	   } else {
		   marksList[0] = Integer.valueOf(Objects.requireNonNull(paper1.getText()).toString());
		   marksList[1] = Integer.valueOf(Objects.requireNonNull(paper2.getText()).toString());
		   marksList[2] = Integer.valueOf(Objects.requireNonNull(paper3.getText()).toString());
		   marksList[3] = Integer.valueOf(Objects.requireNonNull(paper4.getText()).toString());
		   marksList[4] = Integer.valueOf(Objects.requireNonNull(paper5.getText()).toString());
		   marksList[5] = Integer.valueOf(Objects.requireNonNull(paper6.getText()).toString());
		   marksList[6] = Integer.valueOf(Objects.requireNonNull(paper7.getText()).toString());
		   marksList[7] = Integer.valueOf(Objects.requireNonNull(paper8.getText()).toString());
		   marksList[8] = Integer.valueOf(Objects.requireNonNull(paper9.getText()).toString());
		   marksList[9] = Integer.valueOf(Objects.requireNonNull(paper10.getText()).toString());
		   for (Integer integer : marksList) {
			   sum = sum + integer;
		   }
		   for (int i = 0; i < marksList.length; i++) {
			   if (marksList[i] < 40) {
				   gpaList[i] = 0;
			   } else if (marksList[i] >= 40 && marksList[i] < 45) {
				   gpaList[i] = 4*2;
			   } else if (marksList[i] >= 45 && marksList[i] < 50) {
				   gpaList[i] = 5*2;
			   } else if (marksList[i] >= 50 && marksList[i] < 55) {
				   gpaList[i] = 6*2;
			   } else if (marksList[i] >= 55 && marksList[i] < 60) {
				   gpaList[i] = 7*2;
			   } else if (marksList[i] >= 60 && marksList[i] < 70) {
				   gpaList[i] = 8*2;
			   } else if (marksList[i] >= 70 && marksList[i] < 80) {
				   gpaList[i] = 9*2;
			   } else if (marksList[i] >= 80) {
				   gpaList[i] = 10*2;
			   }
			   gpa = gpa + gpaList[i];
		   }

//					Toast.makeText(getApplicationContext(), "Sum: " + sum + "\tGPA: " + gpa / 10, Toast.LENGTH_LONG).show();
		   btnCalculate.setClickable(false);
		   Intent intent = new Intent(MainActivity.this, Result.class);
		   intent.putExtra("sum", sum);
		   intent.putExtra("gpa", gpa/2);
		   startActivity(intent);
		   sum = 0;
		   gpa = 0;
	   }
   }catch (Exception e){
	   Toast.makeText(getApplicationContext(), "Some Filed are 0", Toast.LENGTH_LONG).show();
   }
   }

   private TextWatcher rangeCheck = new TextWatcher() {
	   @Override
	   public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	   }

	   @Override
	   public void onTextChanged(CharSequence s, int start, int before, int count) {

	   }
	   @Override
	   public void afterTextChanged(Editable s) {
		   try {
			   int val = Integer.parseInt(s.toString());
			   btnCalculate.setClickable(true);
			   if (val > 100) {
				   s.replace(0, s.length(), "100", 0, 3);
				   Toast.makeText(getApplicationContext(), "you are not able to Enter more than " +
								   "100 !!!",
						   Toast.LENGTH_LONG).show();

			   }
		   } catch (NumberFormatException ex) {
			   Toast.makeText(getApplicationContext(), "Sorry !!!", Toast.LENGTH_LONG).show();
		   }

	   }
   };
}