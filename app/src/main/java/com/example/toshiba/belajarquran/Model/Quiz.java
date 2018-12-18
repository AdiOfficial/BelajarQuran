package com.example.toshiba.belajarquran.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Quiz implements Parcelable{

    private Abjad[] options;
    private Abjad jawaban;
    private boolean isRightAnswer = false;

    public Quiz(Abjad[] options, Abjad jawaban){
        this.options = options;
        this.jawaban = jawaban;
    }

    public Abjad[] getOptions() {
        return options;
    }

    public Abjad getJawaban() {
        return jawaban;
    }

    public void answer(int choosen){
        isRightAnswer = jawaban.isEqual(options[choosen]);
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    protected Quiz(Parcel in) {
        options = in.createTypedArray(Abjad.CREATOR);
        jawaban = in.readParcelable(Abjad.class.getClassLoader());
    }

    public static final Parcelable.Creator<Quiz> CREATOR = new Creator<Quiz>() {
        @Override
        public Quiz createFromParcel(Parcel in) {
            return new Quiz(in);
        }

        @Override
        public Quiz[] newArray(int size) {
            return new Quiz[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(options,flags);
        dest.writeParcelable(jawaban,flags);
    }
}
