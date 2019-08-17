package com.example.quacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.quacks.ChooseSet.FragmentChooseSet;


public class FragmentRoundFinished extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_round_finished, container, false);


        Button btn_buy_items = v.findViewById(R.id.btn_buy_item);
        btn_buy_items.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                MainActivity.mainActivity.deactivateButtons();

                getActivity().onBackPressed();

            }
        });
        Button btn_take_points = v.findViewById(R.id.btn_take_points);
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