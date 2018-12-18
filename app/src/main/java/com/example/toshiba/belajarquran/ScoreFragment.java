package com.example.toshiba.belajarquran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {


    public final static String SCORE_TAG = "SCORE";

    public ScoreFragment() {
        // Required empty public constructor
    }

    public static ScoreFragment newInstance(int score){
        ScoreFragment fragment = new ScoreFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SCORE_TAG,"Score Anda Adalah : " + String.valueOf(score));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score,container,false);
        TextView score = v.findViewById(R.id.scoreText);
        score.setText(getArguments().getString(SCORE_TAG));
        return v;
    }

}
