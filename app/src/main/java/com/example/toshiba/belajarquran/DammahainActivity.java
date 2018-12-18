package com.example.toshiba.belajarquran;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DammahainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baca_layout);

        TypedArray abjads = getResources().obtainTypedArray(R.array.dammahain);
        final TypedArray sounds = getResources().obtainTypedArray(R.array.sound_dammahain);
        RecyclerView.Adapter adapter = new AbjadAdapter(this, abjads, new AbjadAdapter.OnMusicStartListener() {
            @Override
            public void startMusic(int position) {
                if(mp != null){
                    mp.stop();
                    mp.release();
                }
                mp = MediaPlayer.create(DammahainActivity.this,sounds.getResourceId(position,R.raw.button));
                mp.start();
            }
        });
        RecyclerView grid = findViewById(R.id.grid_abjad);
        int noOfColumns = Utility.calculateNumberOfColumns(this,70);
        grid.setLayoutManager(new GridLayoutManager(this,noOfColumns));
        grid.setAdapter(adapter);
    }
}
