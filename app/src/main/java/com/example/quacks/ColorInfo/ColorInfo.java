package com.example.quacks.ColorInfo;


import android.content.Context;
import android.graphics.Color;

public interface ColorInfo {

    String getHeader();
    int getSet();
    int colorNr();

    String getInfo();
    int[] getPrice();
    int[] getArrDrawable();

    int getBg();

    boolean isSingle();


}


