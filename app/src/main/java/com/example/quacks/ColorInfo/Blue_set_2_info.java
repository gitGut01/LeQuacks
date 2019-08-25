package com.example.quacks.ColorInfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

import com.example.quacks.MainActivity;
import com.example.quacks.R;

public class Blue_set_2_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Blue (Set 2)";
    }

    @Override
    public int getSet() {
        return 2;
    }

    @Override
    public int colorNr() {
        return 0; //Blue
    }

    @Override
    public String getInfo() {
        return "If you place a blue chip on a ruby space,\n" +
                "you immediately receive 1 ruby";
    }

    @Override
    public int[] getPrice() {
        return new int[]{5, 10, 19};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{10, 11, 12};
    }

    @Override
    public int getBg() {
        return Color.rgb(153, 204, 255);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    public static void doTheRule(){
        if(MainActivity.arrItemField.get(MainActivity.currentStep).isRuby()){
            MainActivity.currentRub += 1;
        }

    }

}
