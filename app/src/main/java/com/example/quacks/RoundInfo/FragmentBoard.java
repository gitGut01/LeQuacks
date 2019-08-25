package com.example.quacks.RoundInfo;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.quacks.ItemField;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.ArrayList;
import java.util.Arrays;


public class FragmentBoard extends Fragment implements View.OnClickListener {
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
        View v = inflater.inflate(R.layout.fragment_board, container, false);

        mainActivity = MainActivity.mainActivity;
        LinearLayout ll_close = v.findViewById(R.id.ll_close);
        ll_close.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.mainActivity.closeFragment();
            }
        });


        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Array of all the FrameLayouts in FragmentBoard
        arrIvInB = new ArrayList<>(Arrays.asList(
                getView().findViewById(R.id.fl_00), getView().findViewById(R.id.fl_01),
                getView().findViewById(R.id.fl_02), getView().findViewById(R.id.fl_03),

                getView().findViewById(R.id.fl_04), getView().findViewById(R.id.fl_05),
                getView().findViewById(R.id.fl_06), getView().findViewById(R.id.fl_07),

                getView().findViewById(R.id.fl_08), getView().findViewById(R.id.fl_09),
                getView().findViewById(R.id.fl_10), getView().findViewById(R.id.fl_11),

                getView().findViewById(R.id.fl_12), getView().findViewById(R.id.fl_13),
                getView().findViewById(R.id.fl_14), getView().findViewById(R.id.fl_15),

                getView().findViewById(R.id.fl_15_), getView().findViewById(R.id.fl_16),
                getView().findViewById(R.id.fl_16_), getView().findViewById(R.id.fl_17),

                getView().findViewById(R.id.fl_17_), getView().findViewById(R.id.fl_18),
                getView().findViewById(R.id.fl_18_), getView().findViewById(R.id.fl_19),

                getView().findViewById(R.id.fl_19_), getView().findViewById(R.id.fl_20),
                getView().findViewById(R.id.fl_20_), getView().findViewById(R.id.fl_21),

                getView().findViewById(R.id.fl_21_), getView().findViewById(R.id.fl_22),
                getView().findViewById(R.id.fl_22_), getView().findViewById(R.id.fl_23),

                getView().findViewById(R.id.fl_23_), getView().findViewById(R.id.fl_24),
                getView().findViewById(R.id.fl_24_), getView().findViewById(R.id.fl_25),

                getView().findViewById(R.id.fl_25_), getView().findViewById(R.id.fl_26),
                getView().findViewById(R.id.fl_26_), getView().findViewById(R.id.fl_27),

                getView().findViewById(R.id.fl_27_), getView().findViewById(R.id.fl_28),
                getView().findViewById(R.id.fl_28_), getView().findViewById(R.id.fl_29),

                getView().findViewById(R.id.fl_29_), getView().findViewById(R.id.fl_30),
                getView().findViewById(R.id.fl_30_), getView().findViewById(R.id.fl_31),

                getView().findViewById(R.id.fl_31_), getView().findViewById(R.id.fl_32),
                getView().findViewById(R.id.fl_32_), getView().findViewById(R.id.fl_33),

                getView().findViewById(R.id.fl_33_), getView().findViewById(R.id.fl_35)
        ));


        populateBoard();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void populateBoard(){

        arrIvInB.forEach(item -> item.removeAllViews());

        //Add the start chip
        ImageView imgStart = new ImageView(mainActivity);
        imgStart.setImageResource(R.drawable.start_step);
        imgStart.setScaleX(0.8f);
        imgStart.setScaleY(0.8f);
        arrIvInB.get(MainActivity.currentStart).addView(imgStart);

        //Add the rat chip
        if(MainActivity.currentRattail > 0) {
            ImageView imgRat = new ImageView(mainActivity);
            imgRat.setImageResource(R.drawable.rat);
            imgRat.setScaleX(0.8f);
            imgRat.setScaleY(0.8f);
            arrIvInB.get(MainActivity.currentStart + MainActivity.currentRattail).addView(imgRat);
        }

        //Add exploded
        if(MainActivity.isExploded){
            ImageView imgExp = new ImageView(mainActivity);
            imgExp.setImageResource(R.drawable.explosion);
            arrIvInB.get(MainActivity.currentStep).addView(imgExp);
        }

        int[] board = MainActivity.board;

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