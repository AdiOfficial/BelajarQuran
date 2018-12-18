package com.example.toshiba.belajarquran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;

public class TanwinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanwin);

        AppCompatImageButton fattahain = findViewById(R.id.fattahain);
        fattahain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TanwinActivity.this,FattahainActivity.class);
                startActivity(intent);
            }
        });

        AppCompatImageButton dammahain = findViewById(R.id.dammahain);
        dammahain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TanwinActivity.this, DammahainActivity.class);
                startActivity(intent);
            }
        });

        AppCompatImageButton kasrahain = findViewById(R.id.kasrahain);
        kasrahain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TanwinActivity.this, KasrahainActivity.class);
                startActivity(intent);
            }
        });

    }
}
