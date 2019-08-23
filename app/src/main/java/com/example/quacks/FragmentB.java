package com.example.quacks;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;


public class FragmentB extends Fragment implements View.OnClickListener {
    private FragmentBListener listener;



    //ImageView white_1;
    ArrayList<FrameLayout> arrIvInB;


    public interface FragmentBListener {
        void onInputASent(int i);
    }


    public void updateBoard(int[] b){

        Log.d("updated", "updated");

    }


    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        mainActivity = MainActivity.mainActivity;
        //MainActivity.arrDrawable.get(0);
        LinearLayout ll_close = v.findViewById(R.id.ll_close);
        ll_close.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Array of all ImageViews in FragmentB

        arrIvInB = new ArrayList<>(Arrays.asList(
                (FrameLayout) getView().findViewById(R.id.fl_00), (FrameLayout) getView().findViewById(R.id.fl_01),
                (FrameLayout) getView().findViewById(R.id.fl_02), (FrameLayout) getView().findViewById(R.id.fl_03),

                (FrameLayout) getView().findViewById(R.id.fl_04), (FrameLayout) getView().findViewById(R.id.fl_05),
                (FrameLayout) getView().findViewById(R.id.fl_06), (FrameLayout) getView().findViewById(R.id.fl_07),

                (FrameLayout) getView().findViewById(R.id.fl_08), (FrameLayout) getView().findViewById(R.id.fl_09),
                (FrameLayout) getView().findViewById(R.id.fl_10), (FrameLayout) getView().findViewById(R.id.fl_11),

                (FrameLayout) getView().findViewById(R.id.fl_12), (FrameLayout) getView().findViewById(R.id.fl_13),
                (FrameLayout) getView().findViewById(R.id.fl_14), (FrameLayout) getView().findViewById(R.id.fl_15),

                (FrameLayout) getView().findViewById(R.id.fl_15_), (FrameLayout) getView().findViewById(R.id.fl_16),
                (FrameLayout) getView().findViewById(R.id.fl_16_), (FrameLayout) getView().findViewById(R.id.fl_17),

                (FrameLayout) getView().findViewById(R.id.fl_17_), (FrameLayout) getView().findViewById(R.id.fl_18),
                (FrameLayout) getView().findViewById(R.id.fl_18_), (FrameLayout) getView().findViewById(R.id.fl_19),

                (FrameLayout) getView().findViewById(R.id.fl_19_), (FrameLayout) getView().findViewById(R.id.fl_20),
                (FrameLayout) getView().findViewById(R.id.fl_20_), (FrameLayout) getView().findViewById(R.id.fl_21),

                (FrameLayout) getView().findViewById(R.id.fl_21_), (FrameLayout) getView().findViewById(R.id.fl_22),
                (FrameLayout) getView().findViewById(R.id.fl_22_), (FrameLayout) getView().findViewById(R.id.fl_23),

                (FrameLayout) getView().findViewById(R.id.fl_23_), (FrameLayout) getView().findViewById(R.id.fl_24),
                (FrameLayout) getView().findViewById(R.id.fl_24_), (FrameLayout) getView().findViewById(R.id.fl_25),

                (FrameLayout) getView().findViewById(R.id.fl_25_), (FrameLayout) getView().findViewById(R.id.fl_26),
                (FrameLayout) getView().findViewById(R.id.fl_26_), (FrameLayout) getView().findViewById(R.id.fl_27),

                (FrameLayout) getView().findViewById(R.id.fl_27_), (FrameLayout) getView().findViewById(R.id.fl_28),
                (FrameLayout) getView().findViewById(R.id.fl_28_), (FrameLayout) getView().findViewById(R.id.fl_29),

                (FrameLayout) getView().findViewById(R.id.fl_29_), (FrameLayout) getView().findViewById(R.id.fl_30),
                (FrameLayout) getView().findViewById(R.id.fl_30_), (FrameLayout) getView().findViewById(R.id.fl_31),

                (FrameLayout) getView().findViewById(R.id.fl_31_), (FrameLayout) getView().findViewById(R.id.fl_32),
                (FrameLayout) getView().findViewById(R.id.fl_32_), (FrameLayout) getView().findViewById(R.id.fl_33),

                (FrameLayout) getView().findViewById(R.id.fl_33_), (FrameLayout) getView().findViewById(R.id.fl_35)
        ));

        int[] board = MainActivity.board;

        ImageView imgStart = new ImageView(mainActivity);
        imgStart.setImageResource(R.drawable.start_step);
        imgStart.setScaleX(0.8f);
        imgStart.setScaleY(0.8f);
        arrIvInB.get(MainActivity.currentStart).addView(imgStart);


        if(MainActivity.isExploded){
            ImageView imgExp = new ImageView(mainActivity);
            imgExp.setImageResource(R.drawable.explosion);
            arrIvInB.get(MainActivity.currentStep).addView(imgExp);
        }

        for(int i = 0; i < board.length; i++){
            ImageView imageView = new ImageView(mainActivity);
            ImageView imgRuby = new ImageView(mainActivity);
            ImageView imgPoints = new ImageView(mainActivity);

            TextView txtField = new TextView(mainActivity);
            txtField.setTypeface(null, Typeface.BOLD);
            txtField.setGravity(Gravity.CENTER);


            ItemField itemField = MainActivity.arrItemField.get(i);

            imgRuby.setImageResource(itemField.getDrawableRuby());
            imgPoints.setImageResource(itemField.getDrawablePoints());

            if(board[i] != -1){

                imageView.setImageResource(MainActivity.arrDrawable.get(board[i]));
                txtField.setText("");

                if(MainActivity.isExploded && i == MainActivity.currentStep){
                    imageView.setScaleX(0.6f);
                    imageView.setScaleY(0.6f);
                }


            }else{
                imageView.setImageResource(R.drawable.empty_field);
                imageView.setAlpha(0.5f);
                txtField.setText(itemField.getCredits() + "");
            }

            arrIvInB.get(i).addView(imageView);
            arrIvInB.get(i).addView(imgRuby);
            arrIvInB.get(i).addView(imgPoints);
            arrIvInB.get(i).addView(txtField);

        }
    }

    @Override
    public void onClick(View v) {

    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBListener) {
            listener = (FragmentBListener) context;
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