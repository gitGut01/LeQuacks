package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

import java.util.Arrays;

public class Yellow_set_2_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Yellow (Set 2)";
    }

    @Override
    public int getSet() {
        return 2;
    }

    @Override
    public int colorNr() {
        return 2; //Yellow
    }

    @Override
    public String getInfo() {
        return "The next chip that is placed is moved ahead,\n" +
                "twice as far as its number indicates";
    }

    @Override
    public int[] getPrice() {
        return new int[]{8, 12, 18};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{14, 15, 16};
    }

    @Override
    public int getBg() {
        //Yellow
        return Color.rgb(255, 255, 153);
    }

    @Override
    public boolean isSingle() {
        return false;
    }


    public static void doTheRule(Context c){
        MainActivity.yellow_set_2_activated = true;

        Toast.makeText(c, "The value of the next placed chip is doubled",
                Toast.LENGTH_SHORT).show();
    }
}
