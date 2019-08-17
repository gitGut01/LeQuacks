package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

import java.util.Arrays;

public class Yellow_set_1_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Yellow (Set 1)";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 2; //Yellow
    }

    @Override
    public String getInfo() {
        return "If the previously played chip was white,\n" +
                "put the white chip back into the bag";
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
        if(MainActivity.currentStep > -1) {


            int itemNr = MainActivity.board[MainActivity.currentStep];

            if (itemNr == 0 || itemNr == 1 || itemNr == 2) {

                MainActivity.arrBag.add(itemNr);
                MainActivity.board[MainActivity.currentStep] = -1;

                Toast.makeText(c, Arrays.toString(MainActivity.arrBag.toArray()),
                        Toast.LENGTH_SHORT).show();
            }

        }
    }
}
