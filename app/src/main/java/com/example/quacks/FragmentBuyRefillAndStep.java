package com.example.quacks;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.Arrays;


public class FragmentBuyRefillAndStep extends Fragment{


    private Button btn_buy_fill;
    private Button btn_next_round;
    private ImageView img_refill;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buy_refill_and_step, container, false);

        img_refill = v.findViewById(R.id.img_refill);
        btn_buy_fill = v.findViewById(R.id.btn_buy_fill);

        if(MainActivity.flask_full){
            btn_buy_fill.setEnabled(false);
        }

        btn_buy_fill.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String toast = "Not enough rubies";

                if(MainActivity.currentRub > 2) {
                    MainActivity.currentRub -= 2;
                    MainActivity.flask_full = true;
                    MainActivity.mainActivity.fragment_round_info.updateAfterFill();
                    btn_buy_fill.setEnabled(false);

                    toast = "You bought a refill";
                    MainActivity.mainActivity.fragment_round_info.updateInfo();
                }


                Toast.makeText(MainActivity.mainActivity, toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //start of new round
        btn_next_round = v.findViewById(R.id.btn_next_round);
        btn_next_round.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                MainActivity.currentRound += 1;
                MainActivity.currentStep = -1;
                Arrays.fill(MainActivity.board, -1);
                MainActivity.currentWhite = 0;
                MainActivity.currentCredits = 0;


                getActivity().onBackPressed();
                //getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(0, R.anim.exit_to_button).remove(this).commit();
                MainActivity.mainActivity.fragment_round_info.updateInfo();
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