package com.example.toshiba.belajarquran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;

public class HarkatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harkat);

        AppCompatImageButton fattahButton = findViewById(R.id.fattah);
        fattahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HarkatActivity.this,FattahActivity.class);
                startActivity(intent);
            }
        });

        AppCompatImageButton kasrahButton = findViewById(R.id.kasrah);
        kasrahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HarkatActivity.this,KasrahActivity.class);
                startActivity(intent);
            }
        });

        AppCompatImageButton dammahButton = findViewById(R.id.dammah);
        dammahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HarkatActivity.this,DammahActivity.class);
                startActivity(intent);
            }
        });

    }
}
