package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.example.quacks.MainActivity;

public class Yellow_set_4_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Yellow (Set 4)";
    }

    @Override
    public int getSet() {
        return 4;
    }

    @Override
    public int colorNr() {
        return 2; //Yellow
    }

    @Override
    public String getInfo() {
        return  "   - 1st drawn yellow chip +1\n" +
                "   - 2nd drawn yellow chip +2\n" +
                "   - 3rd drawn yellow chip +3\n" +
                "No additional bonus after that";
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
            MainActivity.currentStep += 1;

            Toast.makeText(c, "This yellow is moved +1 further",
                    Toast.LENGTH_SHORT).show();

        }else if(yellowCount == 2){
            MainActivity.currentStep += 2;

            Toast.makeText(c, "This yellow is moved +2 further",
                    Toast.LENGTH_SHORT).show();


        }else if(yellowCount == 3){
            MainActivity.currentStep += 3;

            Toast.makeText(c, "This yellow is moved +3 further",
                    Toast.LENGTH_SHORT).show();

        }

    }


}
