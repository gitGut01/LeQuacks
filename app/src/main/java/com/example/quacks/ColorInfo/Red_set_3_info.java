package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

public class Red_set_3_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Red (Set 3)";
    }

    @Override
    public int getSet() {
        return 3;
    }

    @Override
    public int colorNr() {
        return 1; //Red
    }

    @Override
    public String getInfo() {
        return "If the previously placed chip was white,\n" +
                "add its value to the red chip.\n" +
                "Move the red chip that many spaces";
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

        int itemNr = MainActivity.board[MainActivity.prevStep];


        if (itemNr == 0 || itemNr == 1 || itemNr == 2) {

            String s = "";

            if (itemNr == 0) {
                MainActivity.currentStep += 1;
                s = "+ 1 additional step";
            } else if (itemNr == 1) {
                MainActivity.currentStep += 2;
                s = "+ 2 additional steps";
            } else if (itemNr == 2) {
                MainActivity.currentStep += 3;
                s = "+ 3 additional steps";
            }

            Toast.makeText(c, s,
                    Toast.LENGTH_SHORT).show();
        }
    }
}
