package com.example.toshiba.belajarquran.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Abjad implements Parcelable {

    public final static int HIJAIYAH = 0;
    public final static int FATTAH = 1;
    public final static int KASRAH = 2;
    public final static int DAMMAH = 3;
    public final static int FATTAHAIN = 4;
    public final static int KASRAHAIN = 5;
    public final static int DAMMAHAIN = 6;

    private int order;
    private int type;
    public Abjad(int order,int type){
        this.order = order;
        this.type = type;
    }

    protected Abjad(Parcel in) {
        order = in.readInt();
        type = in.readInt();
    }

    public static final Creator<Abjad> CREATOR = new Parcelable.Creator<Abjad>() {
        @Override
        public Abjad createFromParcel(Parcel in) {
            return new Abjad(in);
        }

        @Override
        public Abjad[] newArray(int size) {
            return new Abjad[size];
        }
    };

    public int getOrder(){
        return order;
    }

    public int getType(){
        return type;
    }

    public boolean isEqual(Abjad abj){
        return this.order == abj.getOrder() && this.type == abj.getType();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(order);
        dest.writeInt(type);
    }
}


