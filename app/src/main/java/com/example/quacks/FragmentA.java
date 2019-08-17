package com.example.quacks;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class FragmentA extends Fragment implements View.OnClickListener {
    private FragmentAListener listener;
    private EditText editText;
    private Button buttonOk;


    //ImageView white_1;



    public interface FragmentAListener {
        void onInputASent(int i);
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        //ImageView white_1 =  getView().findViewById(R.id.white_1);
        //white_1.setOnClickListener(this);


        v.findViewById(R.id.white_1).setOnClickListener(this);
        v.findViewById(R.id.white_2).setOnClickListener(this);
        v.findViewById(R.id.white_3).setOnClickListener(this);

        v.findViewById(R.id.orange_1).setOnClickListener(this);
        v.findViewById(R.id.orange_2).setOnClickListener(this);
        v.findViewById(R.id.orange_4).setOnClickListener(this);

        v.findViewById(R.id.blue_1).setOnClickListener(this);
        v.findViewById(R.id.blue_2).setOnClickListener(this);
        v.findViewById(R.id.blue_4).setOnClickListener(this);

        v.findViewById(R.id.purple_1).setOnClickListener(this);
        v.findViewById(R.id.purple_2).setOnClickListener(this);
        v.findViewById(R.id.purple_4).setOnClickListener(this);

        v.findViewById(R.id.red_1).setOnClickListener(this);
        v.findViewById(R.id.red_2).setOnClickListener(this);
        v.findViewById(R.id.red_4).setOnClickListener(this);

        v.findViewById(R.id.yellow_1).setOnClickListener(this);
        v.findViewById(R.id.yellow_2).setOnClickListener(this);
        v.findViewById(R.id.yellow_4).setOnClickListener(this);

        v.findViewById(R.id.green_1).setOnClickListener(this);
        v.findViewById(R.id.green_2).setOnClickListener(this);
        v.findViewById(R.id.green_4).setOnClickListener(this);

        v.findViewById(R.id.black_1).setOnClickListener(this);
        v.findViewById(R.id.black_2).setOnClickListener(this);
        v.findViewById(R.id.black_4).setOnClickListener(this);




        Button btn_next = (Button) v.findViewById(R.id.btn_close);

        btn_next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        //editText = v.findViewById(R.id.edit_text);
        //buttonOk = v.findViewById(R.id.button_ok);
        /*
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });
        */



        return v;
    }




    @Override
    public void onClick(View v) {

        String s = "";
        v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.img_click));

        switch (v.getId()){
            case R.id.white_1:
                //Log.d("wow", "suo");
                listener.onInputASent(0);
                break;
            case R.id.white_2:
                listener.onInputASent(1);
                break;
            case R.id.white_3:
                listener.onInputASent(2);
                break;

            case R.id.orange_1:
                listener.onInputASent(3);
                break;


            case R.id.green_1:
                listener.onInputASent(4);
                break;
            case R.id.green_2:
                listener.onInputASent(5);
                break;
            case R.id.green_4:
                listener.onInputASent(6);
                break;

            case R.id.red_1:
                listener.onInputASent(7);
                break;
            case R.id.red_2:
                listener.onInputASent(8);
                break;
            case R.id.red_4:
                listener.onInputASent(9);
                break;


            case R.id.blue_1:
                listener.onInputASent(10);
                break;
            case R.id.blue_2:
                listener.onInputASent(11);
                break;
            case R.id.blue_4:
                listener.onInputASent(12);
                break;

            case R.id.black_1:
                listener.onInputASent(13);
                break;

            case R.id.yellow_1:
                listener.onInputASent(14);
                break;
            case R.id.yellow_2:
                listener.onInputASent(15);
                break;
            case R.id.yellow_4:
                listener.onInputASent(16);
                break;

            case R.id.purple_1:
                listener.onInputASent(17);
                break;
        }
    }



    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}