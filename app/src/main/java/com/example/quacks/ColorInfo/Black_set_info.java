package com.example.quacks.ColorInfo;

import android.graphics.Color;

public class Black_set_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Black";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 5;
    }

    @Override
    public String getInfo() {
        return "Black rule";
    }

    @Override
    public int[] getPrice() {
        return new int[]{0, 10, 0};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{0, 13, 0};
    }

    @Override
    public int getBg() {
        return Color.rgb(211,211,211);
    }

    @Override
    public boolean isSingle() {
        return true;
    }
}
