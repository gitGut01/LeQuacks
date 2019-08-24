package com.example.quacks;

import android.content.Context;
import android.graphics.Typeface;
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
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;


public class FragmentB2 extends Fragment implements View.OnClickListener {
    private FragmentBListener listener;



    //ImageView white_1;
    ArrayList<ImageView> arrIvInB;


    public interface FragmentBListener {
        void onInputASent(int i);
    }


    public void updateBoard(int[] b){

        Log.d("updated", "updated");


        //ImageView vv = (ImageView) arrIvInB.get(13);

        //vv.setImageResource(R.drawable.blue_1);

        //arrIvInB.get(8).setImageResource(R.drawable.blue_1);



        //((ImageView) getView().findViewById(R.id.e_0)).setImageResource(R.drawable.blue_1);

        /*
        for(int i = 0; i < board.length - 1; i++){

            if(board[i] != -1){
                //ImageView iv = getView().findViewById(R.id.);
                arrIvInB.get(i).setImageResource(R.drawable.blue_1);

            }
        }
        */

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_board, container, false);

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
        //Array of all ImageViews in FragmentBoard

        arrIvInB = new ArrayList<>(Arrays.asList(
                (ImageView) getView().findViewById(R.id.e_00), (ImageView) getView().findViewById(R.id.e_01),
                (ImageView) getView().findViewById(R.id.e_02), (ImageView) getView().findViewById(R.id.e_03),

                (ImageView) getView().findViewById(R.id.e_04), (ImageView) getView().findViewById(R.id.e_05),
                (ImageView) getView().findViewById(R.id.e_06), (ImageView) getView().findViewById(R.id.e_07),

                (ImageView) getView().findViewById(R.id.e_08), (ImageView) getView().findViewById(R.id.e_09),
                (ImageView) getView().findViewById(R.id.e_10), (ImageView) getView().findViewById(R.id.e_11),

                (ImageView) getView().findViewById(R.id.e_12), (ImageView) getView().findViewById(R.id.e_13),
                (ImageView) getView().findViewById(R.id.e_14), (ImageView) getView().findViewById(R.id.e_15),

                (ImageView) getView().findViewById(R.id.e_15_), (ImageView) getView().findViewById(R.id.e_16),
                (ImageView) getView().findViewById(R.id.e_16_), (ImageView) getView().findViewById(R.id.e_17),

                (ImageView) getView().findViewById(R.id.e_17_), (ImageView) getView().findViewById(R.id.e_18),
                (ImageView) getView().findViewById(R.id.e_18_), (ImageView) getView().findViewById(R.id.e_19),

                (ImageView) getView().findViewById(R.id.e_19_), (ImageView) getView().findViewById(R.id.e_20),
                (ImageView) getView().findViewById(R.id.e_20_), (ImageView) getView().findViewById(R.id.e_21),

                (ImageView) getView().findViewById(R.id.e_21_), (ImageView) getView().findViewById(R.id.e_22),
                (ImageView) getView().findViewById(R.id.e_22_), (ImageView) getView().findViewById(R.id.e_23),

                (ImageView) getView().findViewById(R.id.e_23_), (ImageView) getView().findViewById(R.id.e_24),
                (ImageView) getView().findViewById(R.id.e_24_), (ImageView) getView().findViewById(R.id.e_25),

                (ImageView) getView().findViewById(R.id.e_25_), (ImageView) getView().findViewById(R.id.e_26),
                (ImageView) getView().findViewById(R.id.e_26_), (ImageView) getView().findViewById(R.id.e_27),

                (ImageView) getView().findViewById(R.id.e_27_), (ImageView) getView().findViewById(R.id.e_28),
                (ImageView) getView().findViewById(R.id.e_28_), (ImageView) getView().findViewById(R.id.e_29),

                (ImageView) getView().findViewById(R.id.e_29_), (ImageView) getView().findViewById(R.id.e_30),
                (ImageView) getView().findViewById(R.id.e_30_), (ImageView) getView().findViewById(R.id.e_31),

                (ImageView) getView().findViewById(R.id.e_31_), (ImageView) getView().findViewById(R.id.e_32),
                (ImageView) getView().findViewById(R.id.e_32_), (ImageView) getView().findViewById(R.id.e_33),

                (ImageView) getView().findViewById(R.id.e_33_), (ImageView) getView().findViewById(R.id.e_35)
        ));

        int[] board = MainActivity.board;

        //Log.d("oppp", Integer.toString(arrIvInB.size()) + "   " + Integer.toString(board.length));

        for(int i = 0; i < board.length; i++){

            if(board[i] != -1){
                //ImageView iv = getView().findViewById(R.id.);
                arrIvInB.get(i).setImageResource(MainActivity.arrDrawable.get(board[i]));

                Log.d("oppp", arrIvInB.get(i).toString()+  "   "  + board[i]);
            }else{
                arrIvInB.get(i).setAlpha(0.7f);
            }
        }

        if(MainActivity.isExploded){
            arrIvInB.get(MainActivity.currentStep).setImageResource(R.drawable.explosion);
        }


        //Log.d("oppp", Arrays.toString(arrIvInB.toArray()));

        //ImageView vv = (ImageView) arrIvInB.get(6);

        //ImageView e_0 = v.findViewById();
        //vv.setImageResource(R.drawable.black_4);


        FrameLayout fl_09 = view.findViewById(R.id.fl_09);
        ImageView i = new ImageView(MainActivity.mainActivity);
        i.setImageResource(R.drawable.dice_orange);

        ImageView j = new ImageView(MainActivity.mainActivity);
        j.setImageResource(R.drawable.rub);

        TextView t = new TextView(MainActivity.mainActivity);
        t.setTypeface(null, Typeface.BOLD);
        t.setGravity(Gravity.CENTER);
        t.setText("Hallo da");

        fl_09.addView(i);
        fl_09.addView(j);
        fl_09.addView(t);

        Log.d("updated", "wow");
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