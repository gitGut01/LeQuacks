package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;

import com.example.quacks.R;

public class Blue_set_4_info extends ColorInfoAb{


    @Override
    public String getHeader() {
        return "Blue (Set 4)";
    }

    @Override
    public int getSet() {
        return 4;
    }

    @Override
    public int colorNr() {
        return 0; //Blue
    }

    @Override
    public String getInfo() {
        return "Blue set 4";
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
}
