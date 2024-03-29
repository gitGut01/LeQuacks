package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

public class Red_set_4_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Red (Set 4)";
    }

    @Override
    public int getSet() {
        return 4;
    }

    @Override
    public int colorNr() {
        return 1; //Red
    }

    @Override
    public String getInfo() {
        return "As soon as at least 1 red chip is on the board\n," +
                "All following 1 - white chips this round will move +1 extra space";
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

        if(!MainActivity.red_set_4_activated){
            Toast.makeText(c, "All 1-white go +1 extra step this round",
                    Toast.LENGTH_SHORT).show();

            MainActivity.red_set_4_activated = true;
        }
    }
}
