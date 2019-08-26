package com.example.quacks;

import android.content.Context;

import com.example.quacks.ColorInfo.Black_set_info;
import com.example.quacks.ColorInfo.Blue_set_1_info;
import com.example.quacks.ColorInfo.Blue_set_2_info;
import com.example.quacks.ColorInfo.Blue_set_3_info;
import com.example.quacks.ColorInfo.Blue_set_4_info;
import com.example.quacks.ColorInfo.ColorInfoAb;
import com.example.quacks.ColorInfo.Green_set_1_info;
import com.example.quacks.ColorInfo.Orange_set_info;
import com.example.quacks.ColorInfo.Purple_set_1_info;
import com.example.quacks.ColorInfo.Red_set_1_info;
import com.example.quacks.ColorInfo.Red_set_2_info;
import com.example.quacks.ColorInfo.Red_set_3_info;
import com.example.quacks.ColorInfo.Red_set_4_info;
import com.example.quacks.ColorInfo.Yellow_set_1_info;
import com.example.quacks.ColorInfo.Yellow_set_2_info;
import com.example.quacks.ColorInfo.Yellow_set_3_info;
import com.example.quacks.ColorInfo.Yellow_set_4_info;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorSet {

    ArrayList<int[]> blue_price = new ArrayList<>(Arrays.asList(
            new int[]{5, 10, 19},
            new int[]{5, 10, 19},
            new int[]{4, 8, 14},
            new int[]{5, 10, 19}
    ));

    ArrayList<int[]> red_price = new ArrayList<>(Arrays.asList(
            new int[]{6, 10, 16},
            new int[]{4, 8, 14},
            new int[]{5, 9, 15},
            new int[]{7, 11, 17}
    ));


    ArrayList<int[]> yellow_price = new ArrayList<>(Arrays.asList(
            new int[]{8, 12, 18},
            new int[]{9, 13, 19},
            new int[]{8, 12, 18},
            new int[]{8, 12, 18}
    ));


    ArrayList<int[]> green_price = new ArrayList<>(Arrays.asList(
            new int[]{4, 8, 14},
            new int[]{6, 11, 18},
            new int[]{6, 11, 21},
            new int[]{4, 8, 14}
    ));

    ArrayList<int[]> purple_price = new ArrayList<>(Arrays.asList(
            new int[]{9},
            new int[]{12},
            new int[]{10},
            new int[]{11}
    ));

    ArrayList<ArrayList<int[]>> price_list = new ArrayList<>(Arrays.asList(
            blue_price, red_price, yellow_price, green_price, purple_price
    ));

    int black_price = 10;

    String color;
    int colorNr;
    int colorSetNr;

    int price0 = 0;
    int price1 = 0;
    int price2 = 0;

    String colorInfo;


    //Set blue,             Set Red,            Set yellow,             Set green,          Set Purple,       (Black), (orange)
    static public int[] set_to_play = MainActivity.set_to_play;//new int[]{1, 1, 1, 1, 1, 1, 1};
    public String[] availableColors = new String[]{"Blue", "Red", "Yellow", "Green", "Purple", "Black", "Orange"};


    public ArrayList<ColorInfoAb> blue_set = new ArrayList<>(Arrays.asList(
            new Blue_set_1_info(),
            new Blue_set_2_info(),
            new Blue_set_3_info(),
            new Blue_set_4_info()
    ));

    public ArrayList<ColorInfoAb> red_set = new ArrayList<>(Arrays.asList(
            new Red_set_1_info(),
            new Red_set_2_info(),
            new Red_set_3_info(),
            new Red_set_4_info()
    ));

    public ArrayList<ColorInfoAb> yellow_set = new ArrayList<ColorInfoAb>(Arrays.asList(
            new Yellow_set_1_info(),
            new Yellow_set_2_info(),
            new Yellow_set_3_info(),
            new Yellow_set_4_info()
    ));

    private ArrayList<ColorInfoAb> green_set = new ArrayList<ColorInfoAb>(Arrays.asList(
            new Green_set_1_info()
    ));

    private ArrayList<ColorInfoAb> purple_set = new ArrayList<ColorInfoAb>(Arrays.asList(
            new Purple_set_1_info()
    ));




    ColorInfoAb colorI;
    Boolean singleColor = false;

    public ColorSet(int i){
        //HashMap<String, int[]> hashMap = new HashMap<>();

        if(i == 0){
            colorI = blue_set.get(set_to_play[0] - 1);
        }else if(i == 1){
            colorI = red_set.get(set_to_play[1] - 1);
        }else if(i == 2) {
            colorI = yellow_set.get(set_to_play[2] - 1);
        }else if(i == 3) {
            colorI = green_set.get(set_to_play[3] - 1);
        }else if(i == 4){
            colorI = purple_set.get(set_to_play[4] - 1);
            singleColor = true;
        }else if(i == 5){
            colorI = new Black_set_info();
            singleColor = true;
        }else if(i == 6){
            colorI = new Orange_set_info();
            singleColor = true;
        }

        color = availableColors[i];
        colorNr = i;
        colorSetNr = set_to_play[i];



        /*
        //Set cheapest price
        if(i != 4 && i!= 5){
            price0 = (price_list.get(i).get(colorSetNr - 1))[0];
            price2 = (price_list.get(i).get(colorSetNr - 1))[2];
        }

        else if(i!= 5){
            price1 = (price_list.get(i).get(colorSetNr - 1))[1];
        }

        if(i == 5){
            price1 = black_price;
        }
        */

    }

    public boolean isSingle(){
        return singleColor;
    }

    public int[] get_item_for_bag(){
        return colorI.getArrDrawable();
    }

    public String getColor(){
        return color;
    }

    public int getColorNr(){
        return colorNr;
    }

    public String getHeader(){
        return color + " (Set " + (colorSetNr) + ")";
    }


    public int getPrice0(){
        return colorI.getPrice()[0];
    }

    public int getPrice1(){
        return colorI.getPrice()[1];
    }

    public int getPrice2(){
        return colorI.getPrice()[2];
    }


    public String getInfo(){
        return colorI.getInfo();
    }

    public int get_img_0(){
        return MainActivity.arrDrawable.get(colorI.getArrDrawable()[0]);
    }

    public int get_img_1(){
        return MainActivity.arrDrawable.get(colorI.getArrDrawable()[1]);
    }

    public int get_img_2(){
        return MainActivity.arrDrawable.get(colorI.getArrDrawable()[2]);
    }

    public int getBg(){
        return colorI.getBg();
    }



    public static void Orange(){

    }

    public static void Blue(Context c, int itemNr){

        switch(set_to_play[0]){

            case 1:
                Blue_set_1_info.doTheRule(c, itemNr);
                break;
            case 2:
                Blue_set_2_info.doTheRule();
                break;
            case 3:
                Blue_set_3_info.doTheRule();
                break;
        }


    }

    public static void Red(Context c){

        switch(set_to_play[1]){
            case 1:
                Red_set_1_info.doTheRule(c);
                break;
            case 3:
                Red_set_3_info.doTheRule(c);
                break;
            case 4:
                Red_set_4_info.doTheRule(c);
                break;

        }

    }


    public static void Yellow(Context c){

        switch(set_to_play[2]){
            case 1:
                Yellow_set_1_info.doTheRule(c);
                break;
            case 2:
                Yellow_set_2_info.doTheRule(c);
                break;
            case 3:
                Yellow_set_3_info.doTheRule(c);
                break;
            case 4:
                Yellow_set_4_info.doTheRule(c);
                break;

        }
    }

    public static void Green(){
        switch (set_to_play[3]){
            case 1:
                Green_set_1_info.doTheRule();
                break;

        }
    }

    public static void Purple(Context c){

    }


}
