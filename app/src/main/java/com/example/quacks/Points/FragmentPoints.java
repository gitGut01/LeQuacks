package com.example.quacks.Points;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.ArrayList;


public class FragmentPoints extends Fragment implements PointsRecyclerViewAdapter.ItemClickListener{
    private FragmentPointsListener listener;
    private EditText editText;
    private Button buttonOk;

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


    //ImageView white_1;



    public interface FragmentPointsListener {
        void onInputPointsSent(int i);
    }

    private int[] pointBoard = new int[]{
            0, 1, -1, 2, 3, 4, -1, 5, 6, 7, -1, 8, 9, 10,
            -1, 11, 12, -1, 13, 14, -1, 15, 16, -1, 17, 18, -1, 19, 20,
            -1, 21, 22, -1, 23, 24, -1, 25, 26, -1, 27, 28, -1, 29, 30,
            -1, 31, 32, -1, 33, 34, -1, 35, 36, -1, 37, 38, -1, 39, 40,
            -1, 41, 42, -1, 43, 44, -1, 45, 46, -1, 47, 48, -1, 49, 50
    };

    PointsRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_points, container, false);

        // data to populate the RecyclerView with
        ArrayList<Integer> arrPointBoard = new ArrayList<>();

        for(int i = 0; i < pointBoard.length; i++){
            arrPointBoard.add(pointBoard[i]);

        }

        // set up the RecyclerView
        RecyclerView recyclerView = v.findViewById(R.id.rvPoints);




        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        adapter = new PointsRecyclerViewAdapter(v.getContext(), arrPointBoard);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(MainActivity.currentPoint);



        FrameLayout fl_close_points = v.findViewById(R.id.fl_close_points);
        fl_close_points.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.mainActivity.closeFragment();
            }
        });

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentPointsListener) {
            listener = (FragmentPointsListener) context;
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