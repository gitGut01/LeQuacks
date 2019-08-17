package com.example.quacks.ColorInfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import com.example.quacks.FragmentBlueItem;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

public class Blue_set_1_info extends ColorInfoAb{

    @Override
    public String getHeader() {
        return "Blue (Set 1)";
    }

    @Override
    public int getSet() {
        return 1;
    }

    //Set blue, Set Red, Set yellow, Set green, Set Purple, (Black), (orange)
    @Override
    public int colorNr() {
        return 0; //Blue
    }

    @Override
    public String getInfo() {
        return "       If you draw a blue chip from your bag, put it in your pot. You can then take chips out of \\n\n" +
                "        your bag according to the number shown on the chip.\\n\n" +
                "        For a 1-chip, take out 1 chip.\n" +
                "        For a 2-chip, take out 2 chips.\n" +
                "        For a 4-chip, take out 4 chips.\n" +
                "        From the chips drawn, you may lay down 1 of them as your next chip.\n" +
                "        Put the other chips back into the bag.\n" +
                "        If you do not like what you see, you may put them all back into the bag.\n" +
                "        If the newly laid chip also has a bonus, it can also be carried out immediately.";
    }

    @Override
    public int[] getPrice() {
        return new int[]{5, 10, 19};
    }

    @Override
    public int[] getArrDrawable() {
        return new int[]{10, 11, 12};
    }

    @Override
    public int getBg() {
        return Color.rgb(153, 204, 255);
    }

    @Override
    public boolean isSingle() {
        return false;
    }


    public static void doTheRule(Context c, int itemNr){

        FragmentBlueItem fragmentBlueItem;

        Bundle bundle = new Bundle();

        if (itemNr == 10) {

            bundle.putString("oneTwoFour", "1");
            fragmentBlueItem = new FragmentBlueItem();


        } else if (itemNr == 11) {
            bundle.putString("oneTwoFour", "2");
            fragmentBlueItem = new FragmentBlueItem();

        } else{
            bundle.putString("oneTwoFour", "3");
            fragmentBlueItem = new FragmentBlueItem();
            //ColorSet.Blue(MainActivity.this);
        }

        fragmentBlueItem.setArguments(bundle);


        MainActivity mainActivity = (MainActivity) c;

        mainActivity.deactivateButtons();

        mainActivity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.zoom_in_and_alpha, 0, 0, R.anim.zoom_in_and_alpha_out)
                .replace(R.id.container_b, fragmentBlueItem)
                .addToBackStack(null)
                .commit();
    }
}
