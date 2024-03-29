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

import com.example.quacks.ColorSet;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.ArrayList;


public class FragmentBuyItem extends Fragment implements BuyRecyclerViewAdapter.ItemClickListener, BuyRecyclerViewAdapter.AdapterInterface{
    private FragmentBuyListener listener;


    TextView tv_credits;
    TextView tv_buy_limit;


    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(view.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInputBuyItem(int i) {
        tv_credits.setText("Credits: " + MainActivity.currentCredits);
        tv_buy_limit.setText(i + "/2");

        if(i >= 2){
            openRubyStore();
        }

    }



    public interface FragmentBuyListener {
        void onInputBuySent(int i);
    }


    BuyRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buy_item, container, false);
        MainActivity.mainActivity.backToBag();

        // data to populate the RecyclerView with
        //ArrayList<Integer> arrPointBoard = new ArrayList<>();

        ArrayList<ColorSet> arrColorSet = new ArrayList<>();


        arrColorSet.add(new ColorSet(6));
        arrColorSet.add(new ColorSet(0));
        arrColorSet.add(new ColorSet(1));
        arrColorSet.add(new ColorSet(2));
        arrColorSet.add(new ColorSet(3));
        arrColorSet.add(new ColorSet(4));
        arrColorSet.add(new ColorSet(5));


        // set up the RecyclerView
        RecyclerView recyclerView = v.findViewById(R.id.rvPoints);

        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        adapter = new BuyRecyclerViewAdapter(v.getContext(), arrColorSet, this);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(MainActivity.currentPoint);


        //Display available credits
        tv_credits = v.findViewById(R.id.tv_credits);
        tv_credits.setText("Credits: " + MainActivity.currentCredits);

        tv_buy_limit = v.findViewById(R.id.tv_buy_limit);
        tv_buy_limit.setText("0/2");

        Button btn_ruby_store = v.findViewById(R.id.btn_ruby_store);
        btn_ruby_store.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openRubyStore();
            }
        });


        return v;
    }

    private void openRubyStore(){
        MainActivity.currentCredits = 0;
        MainActivity.mainActivity.closeFragment();
        MainActivity.mainActivity.openRubyStore();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBuyListener) {
            listener = (FragmentBuyListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentPoints");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


}