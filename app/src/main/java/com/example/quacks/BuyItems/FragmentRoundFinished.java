package com.example.quacks.BuyItems;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.quacks.ChooseSet.FragmentChooseSet;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

public class FragmentRoundFinished extends Fragment{

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_round_finished, container, false);


        Button btn_buy_items = v.findViewById(R.id.btn_buy_item);
        btn_buy_items.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.mainActivity.closeFragment();
                MainActivity.mainActivity.openBuyItem();
            }
        });
        Button btn_take_points = v.findViewById(R.id.btn_take_points);
        btn_take_points.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.currentPoint += MainActivity.arrItemField.get(MainActivity.currentStep + 1).getPoints();
                MainActivity.mainActivity.fragment_round_info.updateInfo();
                MainActivity.mainActivity.backToBag();
                MainActivity.mainActivity.closeFragment();

                MainActivity.mainActivity.openRubyStore();
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