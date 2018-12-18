package com.example.toshiba.belajarquran;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.ViewGroup;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppCompatImageView welcomeImageView = findViewById(R.id.welcome_icon);
        TextView welcomeTextView = findViewById(R.id.welcome_text);
        Typeface typeface = ResourcesCompat.getFont(this,R.font.indira_k);
        welcomeTextView.setTypeface(typeface,Typeface.BOLD);

        int orientation = getResources().getConfiguration().orientation;
        ViewGroup.LayoutParams layoutParams = welcomeImageView.getLayoutParams();
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            int newSize = getResources().getDimensionPixelSize(R.dimen.welcome_icon_landscape);
            layoutParams.width = newSize;
            layoutParams.height = newSize;
            welcomeTextView.setTextSize(15);
        } else {
            int newSize = getResources().getDimensionPixelSize(R.dimen.welcome_icon_portrait);
            layoutParams.width = newSize;
            layoutParams.height = newSize;
            welcomeTextView.setTextSize(25);
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        },1000);
    }
}
