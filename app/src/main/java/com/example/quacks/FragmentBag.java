package com.example.quacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FragmentBag extends Fragment{
    private EditText editText;
    private Button buttonOk;

    private final int[] tv = new int[]{
            R.id.tv_w1, R.id.tv_b1, R.id.tv_o1,
            R.id.tv_w2, R.id.tv_b2, R.id.tv_black1,
            R.id.tv_w4, R.id.tv_b4, R.id.tv_p1,

            R.id.tv_g1, R.id.tv_r1, R.id.tv_y1,
            R.id.tv_g2, R.id.tv_r2, R.id.tv_y2,
            R.id.tv_g4, R.id.tv_r4, R.id.tv_y4
    };

    private final int[] img = new int[]{
            R.id.img_w1, R.id.img_b1, R.id.img_o1,
            R.id.img_w2, R.id.img_b2, R.id.img_black1,
            R.id.img_w4, R.id.img_b4, R.id.img_p1,

            R.id.img_g1, R.id.img_r1, R.id.img_y1,
            R.id.img_g2, R.id.img_r2, R.id.img_y2,
            R.id.img_g4, R.id.img_r4, R.id.img_y4
    };

    private int[] bag = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,

            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bag_info, container, false);



        for(int itemNr : MainActivity.arrBag){
            switch(itemNr){
                case 0:
                    bag[0] += 1;
                    break;
                case 1:
                    bag[3] += 1;
                    break;
                case 2:
                    bag[6] += 1;
                    break;

                case 3:
                    bag[2] += 1;
                    break;

                case 4:
                    bag[9] += 1;
                    break;
                case 5:
                    bag[12] += 1;
                    break;
                case 6:
                    bag[15] += 1;
                    break;

                case 7:
                    bag[10] += 1;
                    break;
                case 8:
                    bag[13] += 1;
                    break;
                case 9:
                    bag[16] += 1;
                    break;

                case 10:
                    bag[1] += 1;
                    break;
                case 11:
                    bag[4] += 1;
                    break;
                case 12:
                    bag[7] += 1;
                    break;

                case 13:
                    bag[5] += 1;
                    break;

                case 14:
                    bag[11] += 1;
                    break;
                case 15:
                    bag[14] += 1;
                    break;
                case 16:
                    bag[17] += 1;
                    break;

                case 17:
                    bag[8] += 1;
                    break;

            }
        }

        for(int i = 0; i < bag.length; i++){

            ImageView imageView = v.findViewById(img[i]);
            TextView textView = v.findViewById(tv[i]);

            if(bag[i] == 0){
                imageView.setAlpha(0.2f);
            }

            textView.setText(" x " + bag[i]);





        }

        ConstraintLayout cl_close = v.findViewById(R.id.cl_close);
        cl_close.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}