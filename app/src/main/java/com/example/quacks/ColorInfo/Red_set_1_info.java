package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

public class Red_set_1_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Red (Set 1)";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 1; //Red
    }

    @Override
    public String getInfo() {
        return "If there are already orange chips in your pot move the red chip forward\n" +
                "according to the chat:\n" +
                "       if(1 or 2 orange):\n" +
                "           red += 1\n" +
                "           \n" +
                "       if (orange >=3):\n" +
                "           red += 2";
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
        int count = 0;
        for(int i : MainActivity.board){

            //3 is the value of orange 1
            if(i == 3){
                count += 1;
            }
        }

        if(count == 1 || count == 2){

            MainActivity.currentStep += 1;

            Toast.makeText(c, "1 or 2 orange (+ 1) step",
                    Toast.LENGTH_SHORT).show();

        }else if(count >= 3){
            MainActivity.currentStep += 2;

            Toast.makeText(c, "> 3 orange (+ 2) step",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
