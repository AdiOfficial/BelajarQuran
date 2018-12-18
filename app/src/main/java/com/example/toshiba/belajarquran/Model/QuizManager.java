package com.example.toshiba.belajarquran.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class QuizManager  {

    private static int TOTAL_QUESTIONS = 10;
    private Iterator<Quiz> iterator;

    public QuizManager(){
        Abjad[] abjads = initializeQuestions();
        ArrayList<Quiz> questions = new ArrayList<>();
        for(Abjad abj : abjads){
            questions.add(new Quiz(initializeOptionsFor(abj),abj));
        }
        this.iterator = questions.iterator();
    }

    public Iterator<Quiz> iterator(){
        return iterator;
    }

    private Abjad[] initializeQuestions(){
        final int max = 28 * 7;
        int[] temp = new int[max];
        for(int i = 0;i < max;i++){
            temp[i] = i;
        }

        Abjad[] result = new Abjad[10];
        for(int i = 0;i < TOTAL_QUESTIONS;i++){
            Random rand = new Random();
            int min = i;
            int randomNum = rand.nextInt(max - min) + min;
            int t = temp[randomNum];
            temp[randomNum] = temp[i];
            temp[i] = t;
            result[i] = new Abjad(t % 28, t / 28);
        }
        return result;
    }

    private Abjad[] initializeOptionsFor(Abjad abj){
        final int max = 28 * 7;
        int[] temp = new int[max];
        int j = abj.getType() * 7 + abj.getOrder();
        for(int i = 1;i < max;i++){
            temp[i] = i;
        }
        temp[j] = 0;

        Abjad[] result = new Abjad[4];
        for(int i = 1;i < 4;i++){
            Random rand = new Random();
            int min = i;
            int randomNum = rand.nextInt(max - min) + min;
            int t = temp[randomNum];
            temp[randomNum] = temp[i];
            temp[i] = t;
            result[i] = new Abjad(t % 28, t / 28);
        }

        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        result[0] = result[randomNum];
        result[randomNum] = abj;
        return result;
    }
}

