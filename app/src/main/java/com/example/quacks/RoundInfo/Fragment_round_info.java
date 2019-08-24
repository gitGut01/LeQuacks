package com.example.quacks.RoundInfo;

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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.quacks.ItemField;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class Fragment_round_info extends Fragment implements View.OnClickListener {
    private Fragment_round_info_Listener listener;


    public interface Fragment_round_info_Listener {
        void onInput_round_info_Sent();
    }

    private ArrayList<Integer> arrPoint;
    private ArrayList<Integer> arrField;

    private View thisView;
    private ConstraintLayout cl_flask;
    private ImageView img_flask;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_round_info, container, false);


        img_flask = v.findViewById(R.id.img_flask);

        final ConstraintLayout cl_points =v.findViewById(R.id.cl_points);
        cl_points.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.mainActivity.openFragmentPoints();
            }
        });

        ConstraintLayout cl_round = v.findViewById(R.id.cl_round);
        cl_round.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.mainActivity.openFragmentBag();
            }
        });


        ConstraintLayout cl_nextField = v.findViewById(R.id.cl_nextField);
        cl_nextField.setAlpha(0.0f);
        cl_nextField.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.img_click_inverted));


                if(getActivity().getSupportFragmentManager().findFragmentByTag("SHOW_BOARD_TAG")== null){
                    MainActivity.mainActivity.openFragmentBoard();
                }else{
                    MainActivity.mainActivity.closeFragment();
                }
            }

        });


        //Remove the last white chip played and put it back into your bag
        cl_flask = v.findViewById(R.id.cl_flask);
        cl_flask.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(MainActivity.flask_full && MainActivity.currentWhite > 0){
                    img_flask.setImageResource(R.drawable.flask_empty);
                    MainActivity.flask_full = false;
                    String strToast = "Put the last white back in the bag";

                    int currentStepItemNr = MainActivity.board[MainActivity.currentStep];

                    MainActivity.arrBag.add(currentStepItemNr);     //Put item back in bag

                    MainActivity.board[MainActivity.currentStep] = -1;      //Clear the board at the step

                    //Set back the step values after item is put back in bag
                    if(currentStepItemNr == 0){
                        MainActivity.currentStep -= 1;
                    }else if(currentStepItemNr == 1){
                        MainActivity.currentStep -= 2;
                    }else if(currentStepItemNr == 2){
                        MainActivity.currentStep -= 3;
                    }


                    MainActivity.mainActivity.img_current_item.setImageDrawable(null); //Remove the image of the white

                    Toast.makeText(MainActivity.mainActivity, strToast,
                            Toast.LENGTH_SHORT).show();

                    updateInfo();

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

        //Update round info
        TextView tv_round = thisView.findViewById(R.id.tv_round);
        tv_round.setText("Round: " + MainActivity.currentRound + "/9");


        //Flask active

        int currentItemNr;

        if(MainActivity.currentStep == -1){
            currentItemNr = MainActivity.board[MainActivity.currentStep + 1];
        }else{
            currentItemNr = MainActivity.board[MainActivity.currentStep];
        }

        if(MainActivity.flask_full) {
            if ((currentItemNr == 0 || currentItemNr == 1 || currentItemNr == 2) && !MainActivity.isExploded) {
                cl_flask.setEnabled(true);
                cl_flask.setAlpha(1);
                }else{
                    cl_flask.setEnabled(false);
                    cl_flask.setAlpha(0.4f);
            }
        }else {
            cl_flask.setEnabled(false);
            cl_flask.setAlpha(0.4f);
        }


    }

    public void updateAfterFill(){
        img_flask.setImageResource(R.drawable.flask_full);
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