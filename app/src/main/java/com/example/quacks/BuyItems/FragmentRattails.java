package com.example.quacks.BuyItems;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class FragmentRattails extends Fragment implements RattailsRecyclerViewAdapter.ItemClickListener {

    TextView tv_rattails;

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(view.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        int item = adapter.getItem(position);
        if(item != -1){
            MainActivity.opponentPoint = item;

        //MainActivity.currentPoint

        int indexOpponent = pointBoard.indexOf(item);
        int indexYou = pointBoard.indexOf(MainActivity.currentPoint);


        if(indexOpponent > indexYou){
            MainActivity.currentRattail = Collections.frequency(pointBoard.subList(indexYou, indexOpponent), -1);
        }else{
            MainActivity.currentRattail = 0;
        }

        tv_rattails.setText(MainActivity.currentRattail + "");

        adapter.notifyDataSetChanged();

        }
    }

    //ImageView white_1;


    private ArrayList<Integer> pointBoard = new ArrayList<>(Arrays.asList(
            0, 1, -1, 2, 3, 4, -1, 5, 6, 7, -1, 8, 9, 10,
            -1, 11, 12, -1, 13, 14, -1, 15, 16, -1, 17, 18, -1, 19, 20,
            -1, 21, 22, -1, 23, 24, -1, 25, 26, -1, 27, 28, -1, 29, 30,
            -1, 31, 32, -1, 33, 34, -1, 35, 36, -1, 37, 38, -1, 39, 40,
            -1, 41, 42, -1, 43, 44, -1, 45, 46, -1, 47, 48, -1, 49, 50
    ));

    RattailsRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rattails, container, false);

        MainActivity.opponentPoint = 0;
        tv_rattails = v.findViewById(R.id.tv_rattails);

        // data to populate the RecyclerView with
        ArrayList<Integer> arrPointBoard = new ArrayList<>();

        for(int i = 0; i < pointBoard.size(); i++){
            arrPointBoard.add(pointBoard.get(i));

        }

        // set up the RecyclerView
        RecyclerView recyclerView = v.findViewById(R.id.rvPoints);


        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        adapter = new RattailsRecyclerViewAdapter(v.getContext(), arrPointBoard);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(MainActivity.currentPoint);


        Button btn_continue = v.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.mainActivity.startNewRound();
                MainActivity.mainActivity.closeFragment();
            }
        });

        return v;
    }
}