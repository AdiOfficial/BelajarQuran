package com.example.toshiba.belajarquran;


import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toshiba.belajarquran.Model.Abjad;
import com.example.toshiba.belajarquran.Model.AnswerListener;
import com.example.toshiba.belajarquran.Model.Quiz;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    private static final String TAG = "QuizFragment_TAG";
    public AnswerListener listener;


    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment newInstance(Quiz quiz, AnswerListener listener){
        QuizFragment fragment = new QuizFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, quiz);
        fragment.setArguments(bundle);
        fragment.listener = listener;
        return fragment;
    }

    private String getLabel(Abjad abj){
        int string_array_resource_id = -1;
        switch (abj.getType()){
            case Abjad.HIJAIYAH :
                string_array_resource_id = R.array.hijaiyah_label;
                break;
            case Abjad.FATTAH :
                string_array_resource_id = R.array.fattah_label;
                break;
            case Abjad.KASRAH :
                string_array_resource_id = R.array.kasrah_label;
                break;
            case Abjad.DAMMAH :
                string_array_resource_id = R.array.dammah_label;
                break;
            case Abjad.FATTAHAIN :
                string_array_resource_id = R.array.fattahain_label;
                break;
            case Abjad.KASRAHAIN :
                string_array_resource_id = R.array.kasrahain_label;
                break;
            case Abjad.DAMMAHAIN :
                string_array_resource_id = R.array.dammahain_label;
                break;
        }
        return getResources().getStringArray(string_array_resource_id)[abj.getOrder()];
    }

    private Drawable getQuestionImageDrawable(Abjad abjad){
        int image_array_resource_id = -1;
        switch (abjad.getType()){
            case Abjad.HIJAIYAH :
                image_array_resource_id = R.array.hijaiyah;
                break;
            case Abjad.FATTAH :
                image_array_resource_id = R.array.fattah;
                break;
            case Abjad.KASRAH :
                image_array_resource_id = R.array.kasrah;
                break;
            case Abjad.DAMMAH :
                image_array_resource_id = R.array.dammah;
                break;
            case Abjad.FATTAHAIN :
                image_array_resource_id = R.array.fattahain;
                break;
            case Abjad.KASRAHAIN :
                image_array_resource_id = R.array.kasrahain;
                break;
            case Abjad.DAMMAHAIN :
                image_array_resource_id = R.array.dammahain;
                break;
        }
        TypedArray typedArray = getResources().obtainTypedArray(image_array_resource_id);
        return typedArray.getDrawable(abjad.getOrder());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quiz,container,false);
        final Quiz question = getArguments().getParcelable(TAG);
        AppCompatImageView quizImage = v.findViewById(R.id.quiz_image);
        quizImage.setImageDrawable(getQuestionImageDrawable(question.getJawaban()));
        final AppCompatButton optionA = v.findViewById(R.id.jawaban_a);
        AppCompatButton optionB = v.findViewById(R.id.jawaban_b);
        AppCompatButton optionC = v.findViewById(R.id.jawaban_c);
        AppCompatButton optionD = v.findViewById(R.id.jawaban_d);
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.answer(0);
                listener.send(question);
            }
        });
        optionA.setText(getLabel(question.getOptions()[0]));
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.answer(1);
                listener.send(question);
            }
        });
        optionB.setText(getLabel(question.getOptions()[1]));
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.answer(2);
                listener.send(question);
            }
        });
        optionC.setText(getLabel(question.getOptions()[2]));
        optionD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                question.answer(3);
                listener.send(question);
            }
        });
        optionD.setText(getLabel(question.getOptions()[3]));
        return v;
    }


}
