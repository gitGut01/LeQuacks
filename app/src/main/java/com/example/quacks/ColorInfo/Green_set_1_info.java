package com.example.quacks.ColorInfo;

import android.graphics.Color;

public class Green_set_1_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Green (Set 1)";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 3; //Green
    }
    @Override
    public String getInfo() {
        return "Green set 1 info";
    }

    @Override
    public int[] getPrice() {
        return new int[]{4, 8, 14};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{4, 5, 6};
    }

    @Override
    public int getBg() {
        return Color.rgb(153, 255, 102);
    }

    @Override
    public boolean isSingle() {
        return false;
    }
}
