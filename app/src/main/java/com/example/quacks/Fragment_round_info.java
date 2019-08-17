package com.example.quacks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Fragment_round_info extends Fragment implements View.OnClickListener {
    private Fragment_round_info_Listener listener;


    public interface Fragment_round_info_Listener {
        void onInput_round_info_Sent();
    }

    private ArrayList<Integer> arrPoint;
    private ArrayList<Integer> arrField;

    private View thisView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_round_info, container, false);

        ConstraintLayout cl_points =v.findViewById(R.id.cl_points);
        //cl_points.setAlpha(0);


        cl_points.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                FragmentPoints fragmentPoints = new FragmentPoints();


                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_left, 0, 0, R.anim.exit_to_left)
                        .replace(R.id.container_points, fragmentPoints)
                        .addToBackStack(null)
                        .commit();
            }
        });

        ConstraintLayout cl_round = v.findViewById(R.id.cl_round);
        cl_round.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                FragmentBag fragmentBag = new FragmentBag();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_top, 0, 0, R.anim.exit_to_top)
                        .replace(R.id.container_points, fragmentBag)
                        .addToBackStack(null)
                        .commit();
            }
        });


        ConstraintLayout cl_nextField = v.findViewById(R.id.cl_nextField);
        cl_nextField.setAlpha(0.0f);
        cl_nextField.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.img_click_inverted));


                if(getActivity().getSupportFragmentManager().findFragmentByTag("SHOW_BOARD_TAG")== null){


                    FragmentB fragmentB = new FragmentB();


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.enter_from_right, 0, 0, R.anim.exit_to_right)
                            .replace(R.id.container_board, fragmentB, "SHOW_BOARD_TAG")
                            .addToBackStack(null)
                            .commit();
                }else{
                    getActivity().onBackPressed();
                }
            }

        });


        ConstraintLayout cl_flask = v.findViewById(R.id.cl_flask);
        cl_flask.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(MainActivity.flask_full){
                    ImageView img_flask = v.findViewById(R.id.img_flask);
                    img_flask.setImageResource(R.drawable.flask_empty);
                    MainActivity.flask_full = false;
                }



            }
        });



        thisView = v;
        updateInfo();

        return v;
    }

    @SuppressLint("SetTextI18n")
    public void updateInfo(){
        ImageView img_next_point = thisView.findViewById(R.id.img_next_point);
        ImageView img_next_field = thisView.findViewById(R.id.img_next_field);
        ImageView img_next_rub = thisView.findViewById(R.id.img_next_rub);


        ItemField itemField = MainActivity.arrItemField.get(MainActivity.currentStep + 1);

        img_next_point.setImageResource(itemField.getDrawablePoints());
        img_next_field.setImageResource(itemField.getDrawableCredits());
        img_next_rub.setImageResource(itemField.getDrawableRuby());

        TextView tv_rub_count = thisView.findViewById(R.id.tv_rub_count);
        tv_rub_count.setText(MainActivity.currentRub + "");

        TextView tv_point = thisView.findViewById(R.id.tv_round_point2);
        tv_point.setText("Points: " + MainActivity.currentPoint);

        TextView tv_white = thisView.findViewById(R.id.tv_white);
        tv_white.setText(MainActivity.currentWhite + " x");

        ImageView img_explotion = thisView.findViewById(R.id.img_explotion);

        FrameLayout fl_size = thisView.findViewById(R.id.fl_size);

        if(MainActivity.isExploded){
            img_explotion.setImageResource(R.drawable.explosion);
            fl_size.setScaleX(0.6f);
            fl_size.setScaleY(0.6f);
        }else{
            img_explotion.setImageDrawable(null);
            fl_size.setScaleX(1);
            fl_size.setScaleY(1);

        }
    }


    @Override
    public void onClick(View v) {


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment_round_info_Listener) {
            listener = (Fragment_round_info_Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Fragment_round_info_Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}