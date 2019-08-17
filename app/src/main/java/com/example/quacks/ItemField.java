package com.example.quacks;

import android.content.ClipData;
import android.content.res.Resources;
import android.util.Log;

public class ItemField {


    private int credits;
    private int points;
    private boolean ruby;

    private int drawableCredits;
    private int drawablePoints;
    private int drawableRuby;

    ItemField(int credits, int points, boolean ruby){
        this.credits = credits;
        this.points = points;
        this.ruby = ruby;



        drawableCredits = MainActivity.MAIN_RESOURCES.getIdentifier("e_" + credits, "drawable", MainActivity.PACKAGE_NAME);
        drawablePoints = MainActivity.MAIN_RESOURCES.getIdentifier("p_" + points, "drawable", MainActivity.PACKAGE_NAME);

        if(ruby){
            drawableRuby = R.drawable.rub;
        }else{
            drawableRuby = R.drawable.no_rub;
        }
    }


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isRuby() {
        return ruby;
    }

    public void setRuby(boolean ruby) {
        this.ruby = ruby;
    }


    public int getDrawableCredits(){
        return drawableCredits;
    }

    public int getDrawablePoints(){
        return drawablePoints;
    }

    public int getDrawableRuby(){
        return drawableRuby;
    }
}
