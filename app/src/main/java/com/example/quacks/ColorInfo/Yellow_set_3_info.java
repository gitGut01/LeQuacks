package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.quacks.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Yellow_set_3_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Yellow (Set 3)";
    }

    @Override
    public int getSet() {
        return 3;
    }

    @Override
    public int colorNr() {
        return 2; //Yellow
    }

    @Override
    public String getInfo() {
        return "If there is 1 or 2 yellow chips on the board,\n" +
                "The pot blows first at >8 whites.\n" +
                "If there are 3 or more yellows on the board," +
                "\nthe pot blows first at >9";
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
        MainActivity.yellow_set_3_and_4_count += 1;
        int yellowCount = MainActivity.yellow_set_3_and_4_count;

        if(yellowCount == 1){
            MainActivity.currentExplotionValue = 8;

            Toast.makeText(c, "Pot explodes at >8",
                    Toast.LENGTH_SHORT).show();

        }else if(yellowCount > 2){

            if(yellowCount == 3){
                Toast.makeText(c, "Pot explodes at >9",
                        Toast.LENGTH_SHORT).show();
            }
            MainActivity.currentExplotionValue = 9;
        }



    }


}
