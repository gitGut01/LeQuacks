package com.example.quacks;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class FragmentBlueItem extends Fragment implements View.OnClickListener {
    private FragmentBlueItemListener listener;


    public interface FragmentBlueItemListener {
        void onInputASent(int i);
    }

    private int oneTwoFour;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blue_item, container, false);

        oneTwoFour = Integer.parseInt(getArguments().getString("oneTwoFour"));

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView img1 = view.findViewById(R.id.img1);
        ImageView img2 = view.findViewById(R.id.img2);
        ImageView img3 = view.findViewById(R.id.img3);
        ImageView img4 = view.findViewById(R.id.img4);
        ImageView imgOnlyOne = view.findViewById(R.id.imgOnlyOne);

        ConstraintLayout constraintLayout = view.findViewById(R.id.constraintLayout);


        constraintLayout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.mainActivity.closeFragment();
            }
        });

        switch (oneTwoFour){

            //1
            case 1:
                setClickListener(imgOnlyOne);
                break;

            //2
            case 2:
                setClickListener(img2);
                setClickListener(img3);
                break;

            //4
            case 3:
                setClickListener(img1);
                setClickListener(img2);
                setClickListener(img3);
                setClickListener(img4);

        }

    }

    private void setClickListener(ImageView img){

        if(MainActivity.arrBag.size() > 0) {

            Random r = new Random();
            final int i1 = r.nextInt(MainActivity.arrBag.size());

            final int itemNr = MainActivity.arrBag.get(i1);
            img.setImageResource(MainActivity.arrDrawable.get(itemNr));


            img.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.img_click));

                    MainActivity.arrBag.remove(i1);

                    MainActivity.mainActivity.closeFragment();
                    MainActivity.colorRules(itemNr, getActivity());
                    //go back





                }
            });
        }else{
            img.setImageResource(R.drawable.no_item);
        }



    }


    @Override
    public void onClick(View v) {

    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBlueItemListener) {
            listener = (FragmentBlueItemListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBlueItemListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}