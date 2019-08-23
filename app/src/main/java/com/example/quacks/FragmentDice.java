package com.example.quacks;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quacks.ChooseSet.FragmentChooseSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class FragmentDice extends Fragment{

    //ImageView white_1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dice, container, false);

        final ArrayList<ImageView>arrImgView = new ArrayList<>(Arrays.asList(
                (ImageView)v.findViewById(R.id.img_dice_orange),
                (ImageView)v.findViewById(R.id.img_dice_ruby),
                (ImageView)v.findViewById(R.id.img_dice_move),
                (ImageView)v.findViewById(R.id.img_dice_v1_a),
                (ImageView)v.findViewById(R.id.img_dice_v1_b),
                (ImageView)v.findViewById(R.id.img_dice_v2)));


        final int[] chooseAnimation = new int[]{R.anim.dice_1, R.anim.dice_2, R.anim.dice_3,
                R.anim.dice_4, R.anim.dice_5, R.anim.dice_6};

        final int[] diceSide = {-1};


        Button btn_lost = v.findViewById(R.id.btn_lost);
        btn_lost.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(diceSide[0] != -1){

                    String strDiceSide = "";

                    switch(diceSide[0]){
                        case 0:
                            MainActivity.arrBag.add(3);
                            strDiceSide = "One orange chip was added to your bag";
                            break;

                        case 1:
                            MainActivity.currentRub += 1;
                            strDiceSide = "You got one ruby";
                            break;

                        case 2:
                            strDiceSide = "Start chip moved +1 up";
                            MainActivity.currentStart += 1;
                            break;

                        case 3:
                        case 4:
                            MainActivity.currentPoint += 1;
                            strDiceSide = "You received 1 victory point";
                            break;

                        case 5:
                            MainActivity.currentPoint += 2;
                            strDiceSide = "You received 2 victory point";
                            break;

                    }

                    Toast.makeText(MainActivity.mainActivity, strDiceSide,
                            Toast.LENGTH_SHORT).show();

                    MainActivity.mainActivity.fragment_round_info.updateInfo();
                }

                MainActivity.mainActivity.closeFragment();
                MainActivity.mainActivity.openBuyItem();

            }
        });




        final Button btn_won = v.findViewById(R.id.btn_won);
        btn_won.setOnClickListener(new View.OnClickListener() {

            int i = 0;

            public void onClick(View v) {

                if(i == 0){
                    i += 1;
                    btn_won.setText("Are you sure you won?");

                }else{

                    Random r = new Random();

                    int[] ex = {};
                    int i1 = getRandomWithExclusion(r, 0, 5, ex);

                    ex = new int[] {i1};
                    int i2 = getRandomWithExclusion(r, 0, 5, ex);

                    ex = new int[] {i1, i2};
                    int i3 = getRandomWithExclusion(r, 0, 5, ex);

                    ex = new int[] {i1, i3};
                    int i4 = getRandomWithExclusion(r, 0, 5, ex);

                    ex = new int[] {i1, i4};
                    int i5 = getRandomWithExclusion(r, 0, 5, ex);

                    ex = new int[] {i1, i5};
                    int i6 = getRandomWithExclusion(r, 0, 5, ex);


                    arrImgView.get(0).startAnimation(AnimationUtils.loadAnimation(getContext(), chooseAnimation[i1]));
                    arrImgView.get(1).startAnimation(AnimationUtils.loadAnimation(getContext(), chooseAnimation[i2]));
                    arrImgView.get(2).startAnimation(AnimationUtils.loadAnimation(getContext(), chooseAnimation[i3]));
                    arrImgView.get(3).startAnimation(AnimationUtils.loadAnimation(getContext(), chooseAnimation[i4]));
                    arrImgView.get(4).startAnimation(AnimationUtils.loadAnimation(getContext(), chooseAnimation[i5]));
                    arrImgView.get(5).startAnimation(AnimationUtils.loadAnimation(getContext(), chooseAnimation[i6]));


                    diceSide[0] = r.nextInt(6);
                    arrImgView.get(diceSide[0]).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dice_the_one));

                    btn_won.setEnabled(false);

                }
            }
        });



        return v;
    }

    //Random generater with exclusion
    public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }



}