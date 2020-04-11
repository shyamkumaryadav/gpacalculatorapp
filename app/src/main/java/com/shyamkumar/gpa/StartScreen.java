package com.shyamkumar.gpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen);

        imageView = findViewById(R.id.Logo);
        textView = findViewById(R.id.textView);

        textView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_0));
        imageView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_10));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(StartScreen.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
