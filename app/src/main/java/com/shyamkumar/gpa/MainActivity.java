package com.shyamkumar.gpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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


    // Some Variable
    ArrayList<Integer> marksList = new ArrayList<Integer>();
    private int sum = 0;
    ArrayList<Integer> gpaList = new ArrayList<Integer>();
    private float gpa = 0;


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

/*
       paperLayout1 = findViewById(R.id.paperLayout1);
       paperLayout2 = findViewById(R.id.paperLayout2);
       paperLayout3 = findViewById(R.id.paperLayout3);
       paperLayout4 = findViewById(R.id.paperLayout4);
       paperLayout5 = findViewById(R.id.paperLayout5);
       paperLayout6 = findViewById(R.id.paperLayout6);
       paperLayout7 = findViewById(R.id.paperLayout7);
       paperLayout8 = findViewById(R.id.paperLayout8);
       paperLayout9 = findViewById(R.id.paperLayout9);
       paperLayout10 = findViewById(R.id.paperLayout10);
*/
       //Close The app From second Activity
       if (getIntent().getBooleanExtra("EXIT", false)) {
           finish();
       }
   }
   private TextWatcher rangeCheck = new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence s, int start, int count, int after) {

       }

       @Override
       public void onTextChanged(CharSequence s, int start, int before, int count) {
           if(!(paper1.getText().toString().isEmpty() &&
                   paper2.getText().toString().isEmpty() &&
                   paper3.getText().toString().isEmpty() &&
                   paper4.getText().toString().isEmpty() &&
                   paper5.getText().toString().isEmpty() &&
                   paper6.getText().toString().isEmpty() &&
                   paper7.getText().toString().isEmpty() &&
                   paper8.getText().toString().isEmpty() &&
                   paper9.getText().toString().isEmpty() &&
                   paper10.getText().toString().isEmpty()
           )){
               btnCalculate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_thumb_up_black_24dp, 0,0,0);
               btnCalculate.setClickable(true);
           }else{
               btnCalculate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_thumb_down_black_24dp, 0,0,0);
               btnCalculate.setClickable(false);
           }
       }
       @Override
       public void afterTextChanged(Editable s) {
           try {
               int val = Integer.parseInt(s.toString());
               if (val > 100) {
                   s.replace(0, s.length(), "100", 0, 3);
                   Toast.makeText(getApplicationContext(), "you are not able to Enter more than " +
                                   "100 !!!",
                           Toast.LENGTH_LONG).show();
               }else if (val < 0){
                   s.replace(0, s.length(), "0", 0, 1);
                   Toast.makeText(getApplicationContext(), "you are not able to Enter less than 0" +
                                   " !!!"
                           , Toast.LENGTH_LONG).show();
               }
           } catch (NumberFormatException ex) {
//               Toast.makeText(getApplicationContext(), "Some Error #$%@!$", Toast.LENGTH_LONG).show();
           }

       }
   };
   public void openMe() {
       //GPA MARKS LIST add
       marksList.add(Integer.parseInt(paper1.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper2.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper3.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper4.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper5.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper6.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper7.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper8.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper9.getText().toString().trim()));
       marksList.add(Integer.parseInt(paper10.getText().toString().trim()));


       // Add GPA To Respactive Paper
       for (int marks: marksList){
       if (marks < 40) {
           gpaList.add(0);
       } else if (marks >= 40 && marks < 45) {
           gpaList.add(4);
       } else if (marks >= 45 && marks < 50) {
           gpaList.add(5);
       } else if (marks >= 50 && marks < 55) {
           gpaList.add(6);
       } else if (marks >= 55 && marks < 60) {
           gpaList.add(7);
       } else if (marks >= 60 && marks < 70) {
           gpaList.add(8);
       } else if (marks >= 70 && marks < 80) {
           gpaList.add(9);
       } else if (marks >= 80) {
           gpaList.add(10);
       }
    };

       //add all values in marksList
       for (int i = 0; i < marksList.size(); i++) {
           sum += marksList.get(i);
       }

       //add all values in gpaList
       for (int i = 0; i < gpaList.size(); i++) {
           gpa += gpaList.get(i);
       }

       // all value
       String Sum = String.format("%s", sum);
       String Percent = String.format("%.2f",(sum / 10));
       String Gpa = String.format("%.2f", (gpa / 10));

       Intent intent = new Intent(this, Result.class);
       intent.putExtra("Sum", Sum);
       intent.putExtra("Percent", Percent);
       intent.putExtra("Gpa", Gpa);
       startActivity(intent);
   }



    public void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure, That down Information is Right." +
                "\nPaper 1 : "+ Objects.requireNonNull(paper1.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper2.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper3.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper4.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper5.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper6.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper7.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper8.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper9.getText()).toString().trim()+
                "\nPaper 2 : "+ Objects.requireNonNull(paper10.getText()).toString().trim()
                ).setCancelable(false);
        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            if(!(paper1.getText().toString().isEmpty() &&
                                    paper2.getText().toString().isEmpty() &&
                                    paper3.getText().toString().isEmpty() &&
                                    paper4.getText().toString().isEmpty() &&
                                    paper5.getText().toString().isEmpty() &&
                                    paper6.getText().toString().isEmpty() &&
                                    paper7.getText().toString().isEmpty() &&
                                    paper8.getText().toString().isEmpty() &&
                                    paper9.getText().toString().isEmpty() &&
                                    paper10.getText().toString().isEmpty()
                                    )){openMe();}else {
                                Toast.makeText(getApplicationContext(), "Some Error #$%@!$",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
    });

    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
   }
}
