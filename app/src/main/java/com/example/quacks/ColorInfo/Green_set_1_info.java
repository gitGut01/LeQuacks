package com.example.quacks.ColorInfo;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.quacks.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Green_set_1_info extends ColorInfoAb {

    @Override
    public String getHeader() {
        return "Green (Set 1)";
    }

    @Override
    public int getSet() {
        return 1;
    }

    @Override
    public int colorNr() {
        return 3; //Green
    }
    @Override
    public String getInfo() {
        return "For each green chip that is\n" +
                "the last or next-to-last chip in your pot,\n" +
                "you receive 1 ruby.";
    }

    @Override
    public int[] getPrice() {
        return new int[]{4, 8, 14};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{4, 5, 6};
    }

    @Override
    public int getBg() {
        return Color.rgb(153, 255, 102);
    }

    @Override
    public boolean isSingle() {
        return false;
    }


    public static int find_last_next_to_last(int range){
        for(int i = range; i > 0; i--){
            if(MainActivity.board[i] != -1){
                return i;
            }
        }

        return -1;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void doTheRule(){

        List<Integer> arrBoard  = Arrays.stream(MainActivity.board)
                .boxed()
                .filter(itemNr -> itemNr != -1)
                .collect(Collectors.toList());



        String s = "";
        Boolean b1 = false;
        Boolean b2 = false;

        if(Arrays.asList(4, 5, 6).contains(arrBoard.get(arrBoard.size() - 1))){
            MainActivity.currentRub += 1;
            s = "The last chip placed was green -> +1 ruby";
            b1 = true;
        }

        if(arrBoard.size() - 2 > -1){
            if(Arrays.asList(4, 5, 6).contains(arrBoard.get(arrBoard.size() - 2))){
                MainActivity.currentRub += 1;
                s = "The next-to-last chip placed was green -> +1 ruby";
                b2 = true;
            }
        }

        if(b1 && b2){
            s = "Both the last and next-to-last chip placed where green -> +2 ruby";
        }

        if(!s.equals("")){
            Toast.makeText(MainActivity.mainActivity, s,
                    Toast.LENGTH_SHORT).show();
        }

    }
}
