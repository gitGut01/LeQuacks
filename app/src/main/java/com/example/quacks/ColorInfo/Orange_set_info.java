package com.example.quacks.ColorInfo;

import android.graphics.Color;

public class Orange_set_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Orange";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 6; //Orange
    }

    @Override
    public String getInfo() {
        return "A 1-chip in the pot has no particular function other than filling the pot by 1 space." +
                "\nIt is the least expensive chip in the game.";
    }

    @Override
    public int[] getPrice() {
        return new int[]{0, 3, 0};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{3, 3, 3};
    }

    @Override
    public int getBg() {
        return Color.rgb(255, 204, 102);
    }

    @Override
    public boolean isSingle() {
        return true;
    }
}
