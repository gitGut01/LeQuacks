package com.example.quacks.ColorInfo;

import android.graphics.Color;

public class Purple_set_1_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Purple (Set 1)";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 4; //Purple
    }

    @Override
    public String getInfo() {
        return "Purple set 1 rules";
    }

    @Override
    public int[] getPrice() {
        return new int[]{0, 9, 0};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{0, 17, 0};
    }

    @Override
    public int getBg() {
        return Color.rgb(204, 153, 255);
    }

    @Override
    public boolean isSingle() {
        return true;
    }
}
