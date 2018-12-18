package com.example.toshiba.belajarquran;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.toshiba.belajarquran.Model.AnswerListener;
import com.example.toshiba.belajarquran.Model.Quiz;
import com.example.toshiba.belajarquran.Model.QuizManager;

import java.util.Iterator;

public class QuizActivity extends AppCompatActivity implements AnswerListener {

    private int rightCount = 0;

    private FragmentManager fragmentManager;
    private QuizManager quizManager;

    @Override
    public void send(Quiz task) {
        if(task.isRightAnswer()){
            rightCount++;
        }
        if(quizManager.iterator().hasNext()){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            QuizFragment fragment = QuizFragment.newInstance(quizManager.iterator().next(),this);
            fragmentTransaction.add(R.id.quiz_fragment_container,fragment);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this,String.valueOf(rightCount),Toast.LENGTH_LONG);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        quizManager = new QuizManager();
        Quiz question = quizManager.iterator().next();
        QuizFragment fragment = QuizFragment.newInstance(question,this);
        fragmentTransaction.add(R.id.quiz_fragment_container,fragment)
                .commit();
    }
}