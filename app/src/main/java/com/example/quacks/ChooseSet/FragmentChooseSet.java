package com.example.quacks.ChooseSet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quacks.ColorInfo.Blue_set_1_info;
import com.example.quacks.ColorInfo.Blue_set_2_info;
import com.example.quacks.ColorInfo.Blue_set_3_info;
import com.example.quacks.ColorInfo.Blue_set_4_info;
import com.example.quacks.ColorInfo.ColorInfoAb;
import com.example.quacks.ColorInfo.Green_set_1_info;
import com.example.quacks.ColorInfo.Purple_set_1_info;
import com.example.quacks.ColorInfo.Red_set_1_info;
import com.example.quacks.ColorInfo.Yellow_set_1_info;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.ArrayList;


public class FragmentChooseSet extends Fragment implements ChooseRecyclerViewAdapter.ItemClickListener {

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


    ChooseRecyclerViewAdapter adapter;
    ChooseRecyclerViewAdapter.ItemClickListener icl_this;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose_set, container, false);

        icl_this = this;

        ImageView img_blue = v.findViewById(R.id.img_blue);
        ImageView img_red = v.findViewById(R.id.img_red);
        ImageView img_green = v.findViewById(R.id.img_green);
        ImageView img_yellow = v.findViewById(R.id.img_yellow);
        ImageView img_purple = v.findViewById(R.id.img_purple);



        ArrayList<ColorInfoAb> arrColorInfoAb = new ArrayList<>();

        //arrColorInfoAb.add(new ChooseSet());

        arrColorInfoAb.add(new Blue_set_1_info());
        arrColorInfoAb.add(new Blue_set_2_info());
        arrColorInfoAb.add(new Blue_set_3_info());
        arrColorInfoAb.add(new Blue_set_4_info());


        // set up the RecyclerView
        RecyclerView recyclerView = v.findViewById(R.id.rvPoints);

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        adapter = new ChooseRecyclerViewAdapter(v.getContext(), arrColorInfoAb);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(MainActivity.set_to_play[0] - 1);

        //adapter.notifyDataSetChanged();


        makeTvClickable(img_blue, 0, recyclerView);
        makeTvClickable(img_red, 1, recyclerView);
        makeTvClickable(img_green, 2, recyclerView);
        makeTvClickable(img_yellow, 3, recyclerView);
        makeTvClickable(img_purple, 4, recyclerView);

        return v;
    }

    //Blue, Red, Yellow, Green, Purple, Black, Orange
    public void makeTvClickable(ImageView img, final int i, final RecyclerView recyclerView){
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<ColorInfoAb> arrColorInfoAb = new ArrayList<>();

                if(i == 0){
                    arrColorInfoAb.add(new Blue_set_1_info());
                    arrColorInfoAb.add(new Blue_set_2_info());
                    arrColorInfoAb.add(new Blue_set_3_info());
                    arrColorInfoAb.add(new Blue_set_4_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[0] - 1);

                }else if(i == 1){
                    arrColorInfoAb.add(new Red_set_1_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[1] - 1);

                }else if(i == 2){
                    arrColorInfoAb.add(new Green_set_1_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[3] - 1);

                }else if(i == 3){
                    arrColorInfoAb.add(new Yellow_set_1_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[2] - 1);

                }else if(i == 4){
                    arrColorInfoAb.add(new Purple_set_1_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[4] - 1);
                }



                adapter = new ChooseRecyclerViewAdapter(v.getContext(), arrColorInfoAb);
                adapter.setClickListener(icl_this);
                recyclerView.setAdapter(adapter);
            }
        });




    }




}