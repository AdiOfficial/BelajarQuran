package com.example.toshiba.belajarquran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatImageButton hijaiyahButton = findViewById(R.id.hijaiyah);
        AppCompatImageButton harkatButton = findViewById(R.id.harkat);
        AppCompatImageButton tanwinButton = findViewById(R.id.tanwin);
        AppCompatImageButton quizButton = findViewById(R.id.quiz);
        AppCompatImageButton aboutButton = findViewById(R.id.about);

        hijaiyahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HijaiyahActivity.class);
                startActivity(intent);
            }
        });

        harkatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HarkatActivity.class);
                startActivity(intent);
            }
        });

        tanwinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TanwinActivity.class);
                startActivity(intent);
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}
