package com.example.toshiba.belajarquran;

import android.content.Context;
import android.util.DisplayMetrics;

class Utility {
    public static int calculateNumberOfColumns(Context context, int customWidth){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns  = (int) dpWidth / customWidth;
        return noOfColumns;
    }
}
