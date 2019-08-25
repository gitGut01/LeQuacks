package com.example.quacks.ChooseSet;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.example.quacks.ColorInfo.Red_set_2_info;
import com.example.quacks.ColorInfo.Red_set_3_info;
import com.example.quacks.ColorInfo.Red_set_4_info;
import com.example.quacks.ColorInfo.Yellow_set_1_info;
import com.example.quacks.ColorInfo.Yellow_set_2_info;
import com.example.quacks.ColorInfo.Yellow_set_3_info;
import com.example.quacks.ColorInfo.Yellow_set_4_info;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.ArrayList;
import java.util.Arrays;


public class FragmentChooseSet extends Fragment implements ChooseRecyclerViewAdapter.ItemClickListener {

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


    ChooseRecyclerViewAdapter adapter;
    ChooseRecyclerViewAdapter.ItemClickListener icl_this;

    ConstraintLayout cl_choose;
    ArrayList<ImageView> arrImg;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose_set, container, false);

        icl_this = this;
        cl_choose = v.findViewById(R.id.cl_choose);

        ImageView img_blue = v.findViewById(R.id.img_blue);
        ImageView img_red = v.findViewById(R.id.img_red);
        ImageView img_green = v.findViewById(R.id.img_green);
        ImageView img_yellow = v.findViewById(R.id.img_yellow);
        ImageView img_purple = v.findViewById(R.id.img_purple);

        arrImg = new ArrayList<>(Arrays.asList(
                img_blue, img_red, img_green, img_yellow, img_purple));



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



        //Set bg for blue on init
        cl_choose.setBackgroundColor(Color.rgb(230, 242, 255));
        changeAlphaOfButton();
        arrImg.get(0).setAlpha(1.0f);


        Button btn_back = v.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(v1 -> MainActivity.mainActivity.closeFragment());

        return v;
    }

    //Blue, Red, Yellow, Green, Purple, Black, Orange
    public void makeTvClickable(ImageView img, final int i, final RecyclerView recyclerView){
        img.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

                ArrayList<ColorInfoAb> arrColorInfoAb = new ArrayList<>();

                changeAlphaOfButton();
                arrImg.get(i).setAlpha(1.0f);

                if(i == 0){
                    arrColorInfoAb.add(new Blue_set_1_info());
                    arrColorInfoAb.add(new Blue_set_2_info());
                    arrColorInfoAb.add(new Blue_set_3_info());
                    arrColorInfoAb.add(new Blue_set_4_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[0] - 1);

                    cl_choose.setBackgroundColor(Color.rgb(230, 242, 255));

                }else if(i == 1){
                    arrColorInfoAb.add(new Red_set_1_info());
                    arrColorInfoAb.add(new Red_set_2_info());
                    arrColorInfoAb.add(new Red_set_3_info());
                    arrColorInfoAb.add(new Red_set_4_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[1] - 1);

                    cl_choose.setBackgroundColor(Color.rgb(255, 230, 230));

                }else if(i == 2){
                    arrColorInfoAb.add(new Green_set_1_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[3] - 1);

                    cl_choose.setBackgroundColor(Color.rgb(230, 255, 230));

                }else if(i == 3){
                    arrColorInfoAb.add(new Yellow_set_1_info());
                    arrColorInfoAb.add(new Yellow_set_2_info());
                    arrColorInfoAb.add(new Yellow_set_3_info());
                    arrColorInfoAb.add(new Yellow_set_4_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[2] - 1);

                    cl_choose.setBackgroundColor(Color.rgb(255, 255, 230));

                }else if(i == 4){
                    arrColorInfoAb.add(new Purple_set_1_info());

                    recyclerView.scrollToPosition(MainActivity.set_to_play[4] - 1);

                    cl_choose.setBackgroundColor(Color.rgb(255, 230, 255));
                }



                adapter = new ChooseRecyclerViewAdapter(v.getContext(), arrColorInfoAb);
                adapter.setClickListener(icl_this);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void changeAlphaOfButton(){
        arrImg.forEach(item -> item.setAlpha(0.5f));
    }




}