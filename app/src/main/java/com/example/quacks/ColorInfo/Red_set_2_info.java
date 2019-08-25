package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

public class Red_set_2_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Red (Set 2)";
    }

    @Override
    public int getSet() {
        return 2;
    }

    @Override
    public int colorNr() {
        return 1; //Red
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public int[] getPrice() {
        return new int[]{6, 10, 16};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{7, 8, 9};
    }

    @Override
    public int getBg() {
        return Color.rgb(255, 153, 153);
    }

    @Override
    public boolean isSingle() {
        return false;
    }


    public static void doTheRule(Context c){

    }
}
