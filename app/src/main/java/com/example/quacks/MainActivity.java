package com.example.quacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.quacks.BuyItems.FragmentBuyItem;
import com.example.quacks.BuyItems.FragmentBuyRefillAndStep;
import com.example.quacks.BuyItems.FragmentDice;
import com.example.quacks.BuyItems.FragmentRattails;
import com.example.quacks.BuyItems.FragmentRoundFinished;
import com.example.quacks.Points.FragmentPoints;
import com.example.quacks.RoundInfo.FragmentBag;
import com.example.quacks.RoundInfo.FragmentBoard;
import com.example.quacks.RoundInfo.Fragment_round_info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements
        FragmentBoard.FragmentBListener, FragmentBlueItem.FragmentBlueItemListener,
        FragmentPoints.FragmentPointsListener, Fragment_round_info.Fragment_round_info_Listener,
        FragmentBuyItem.FragmentBuyListener {



    public static String PACKAGE_NAME;
    public static Resources MAIN_RESOURCES;


    private FragmentBuyItem fragmentBuyItem;
    private FragmentRoundFinished fragmentRoundFinished;
    private FragmentBoard fragmentBoard;
    public Fragment_round_info fragment_round_info;

    private Button btn_next;
    private Button btn_back_in_bag;

    private boolean boShowFrag = false;

    public int itemNr;


    public ArrayList<String> colors = new ArrayList<>(Arrays.asList(
            // 0        1           2
            "White 1", "White 2", "White 3",
            //3
            "Orange 1",
            //4         5           6
            "Green 1", "Green 2", "Green 4",
            //7         8       9
            "Red 1", "Red 2", "Red 4",
            //10         11         12
            "Blue 1", "Blue 2", "Blue 4",
            //13
            "Black 1",
            //14        15          16
            "Yellow 1", "Yellow 2", "Yellow 4",
            //17
            "Purple 1"));


    public static int[] stepValue = new int[]{1, 2, 3, 1, 1, 2, 4, 1, 2, 4, 1, 2, 4, 1, 1, 2, 4, 1};


    public static ArrayList<Integer> arrDrawable = new ArrayList<>(Arrays.asList(
            R.drawable.white_1, R.drawable.white_2, R.drawable.white_3,
            R.drawable.orange_1,
            R.drawable.green_1, R.drawable.green_2, R.drawable.green_4,
            R.drawable.red_1, R.drawable.red_2, R.drawable.red_4,
            R.drawable.blue_1, R.drawable.blue_2, R.drawable.blue_4,
            R.drawable.black_1,
            R.drawable.yellow_1, R.drawable.yellow_2, R.drawable.yellow_4,
            R.drawable.purple_1));


    public static int[] board = new int[54];

    public static int currentStep = 0;
    public static int currentPoint = 0;
    public static int opponentPoint = 0;
    public static int currentRub = 0;
    public static int currentWhite = 0;
    public static int currentCredits = 0;
    public static boolean flask_full = true;
    public static int currentRound = 1;
    public static int currentStart = 0;
    public static int currentRattail = 0;

    public ImageView img_current_item;

    public static int currentExplotionValue = 7;
    public static boolean isExploded = false;

    public static MainActivity mainActivity;

    public static ArrayList<Integer> arrBag = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 2, 3, 4));

    public static ArrayList<Integer> arrBagBak = new ArrayList<>(arrBag);

    public static ArrayList<ItemField> arrItemField;


    //Set blue,             Set Red,            Set yellow,             Set green,          Set Purple,       (Black), (orange)
    public static int[] set_to_play = new int[]{1, 1, 1, 1, 1, 1, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //<< this
        setContentView(R.layout.activity_main);

        PACKAGE_NAME = getApplicationContext().getPackageName();
        MAIN_RESOURCES = getResources();
        mainActivity = this;

        arrItemField = new ArrayList<>(Arrays.asList(
                new ItemField(0, 0, false),
                new ItemField(1, 0, false),
                new ItemField(2, 0, false),
                new ItemField(3, 0, false),
                new ItemField(4, 0, false),
                new ItemField(5, 0, true),

                new ItemField(6, 1, false),
                new ItemField(7, 1, false),
                new ItemField(8, 1, false),
                new ItemField(9, 1, true),

                new ItemField(10, 2, false),
                new ItemField(11, 2, false),
                new ItemField(12, 2, false),
                new ItemField(13, 2, true),

                new ItemField(14, 3, false),
                new ItemField(15, 3, false),
                new ItemField(15, 3, true),
                new ItemField(16, 3, false),

                new ItemField(16, 4, false),
                new ItemField(17, 4, false),
                new ItemField(17, 4, true),
                new ItemField(18, 4, false),

                new ItemField(18, 5, false),
                new ItemField(19, 5, false),
                new ItemField(19, 5, true),
                new ItemField(20, 5, false),

                new ItemField(20, 6, false),
                new ItemField(21, 6, false),
                new ItemField(21, 6, true),
                new ItemField(22, 7, false),

                new ItemField(22, 7, true),
                new ItemField(23, 7, false),
                new ItemField(23, 8, false),
                new ItemField(24, 8, false),

                new ItemField(24, 8, true),
                new ItemField(25, 9, false),
                new ItemField(25, 9, true),
                new ItemField(26, 9, false),

                new ItemField(26, 10, false),
                new ItemField(27, 10, false),
                new ItemField(27, 10, true),
                new ItemField(28, 11, false),

                new ItemField(28, 11, true),
                new ItemField(29, 11, false),
                new ItemField(29, 12, false),
                new ItemField(30, 12, false),

                new ItemField(30, 12, true),
                new ItemField(31, 12, false),
                new ItemField(31, 13, false),
                new ItemField(32, 13, false),

                new ItemField(32, 13, true),
                new ItemField(33, 14, false),
                new ItemField(33, 14, true),
                new ItemField(35, 15, false)
        ));

        Arrays.fill(board, -1);



        //Initialize round info fragment
        fragment_round_info = new Fragment_round_info();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_round_info, fragment_round_info)
                .commit();


        img_current_item = (ImageView) findViewById(R.id.img_current_item);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Log.d("hey", "dahh");

                if(arrBag.size() > 0) {
                    Random r = new Random();
                    int i1 = r.nextInt(arrBag.size());

                    itemNr = arrBag.get(i1);

                    arrBag.remove(i1);

                    String s = "";
                    for (int i : arrBag) {
                        s += Integer.toString(i);
                        s += " ";

                    }

                    Log.d("Game", s);


                    img_current_item.setImageResource(arrDrawable.get(itemNr));
                    img_current_item.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.img_scale));


                    //Color Rules   ___________
                    colorRules(itemNr, MainActivity.this);

                    //v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.img_click));


                    Log.d("Game", colors.get(itemNr) + "      " + itemNr + "       "   + currentStep);

                    //fragmentBoard.updateBoard(board);

                    fragment_round_info.updateInfo();

                }
            }
        });



        //Put the item back in the bag
        btn_back_in_bag = (Button) findViewById(R.id.btn_back_in_bag);
        btn_back_in_bag.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                openDice();
            }
        });


    }

    public static void colorRules(int itemNr, Context c){

        //arrItemField.get(currentStep + 1).getCredits();


        if(itemNr == 0 || itemNr == 1 || itemNr == 2){
            currentWhite += (itemNr + 1);

            if(currentWhite > currentExplotionValue){
                isExploded = true;
                //mainActivity.openBuyItem();

                mainActivity.openRoundFinished();

            }

        }
        //If item is Blue 1, 2, 4
        if(itemNr == 10 || itemNr == 11 || itemNr == 12) {
            ColorSet.Blue(c, itemNr);
        }

        //If item is Red 1, 2 or 4
        else if(itemNr == 7 || itemNr == 8 || itemNr == 9){
            ColorSet.Red(c);


            //If item is Yellow 1, 2 or 4
        }else if(itemNr == 14 || itemNr == 15 || itemNr == 16){
            ColorSet.Yellow(c);

        }

        //Next step
        currentStep += stepValue[itemNr];
        board[currentStep] = itemNr;
        currentCredits = arrItemField.get(currentStep + 1).getCredits();

    }


    //Open fragment buy Item
    public void openBuyItem(){
        deactivateButtons();
        fragmentBuyItem = new FragmentBuyItem();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, 0, 0, R.anim.exit_to_button)
                .replace(R.id.container_buy, fragmentBuyItem)
                .addToBackStack(null)
                .commit();
    }

    public void openRoundFinished(){
        deactivateButtons();
        fragmentRoundFinished = new FragmentRoundFinished();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_button, 0, 0, R.anim.exit_to_button)
                .replace(R.id.container_round_finished, fragmentRoundFinished, "ROUND_FINISHED")
                .addToBackStack(null)
                .commit();
    }

    public void openDice(){
        deactivateButtons();

        currentPoint += arrItemField.get(currentStep + 1).getPoints();

        if(currentStep + 1 < arrItemField.size()) {
            if (arrItemField.get(currentStep + 1).isRuby()) {
                currentRub += 1;
            }
        }

        fragment_round_info.updateInfo();

        FragmentDice fragmentDice = new FragmentDice();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_button, 0, 0, R.anim.exit_to_left)
                .replace(R.id.container_round_finished, fragmentDice, "DICE")
                .addToBackStack(null)
                .commit();
    }

    public void openRubyStore(){
        FragmentBuyRefillAndStep fragmentBuyRefillAndStep = new FragmentBuyRefillAndStep();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, 0, 0, R.anim.exit_to_button)
                .replace(R.id.container_round_finished, fragmentBuyRefillAndStep, "DICE")
                .addToBackStack(null)
                .commit();
    }

    public void openFragmentPoints(){
        FragmentPoints fragmentPoints = new FragmentPoints();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left, 0, 0, R.anim.exit_to_left)
                .replace(R.id.container_points, fragmentPoints)
                .addToBackStack(null)
                .commit();
    }

    public void openFragmentBag(){
        FragmentBag fragmentBag = new FragmentBag();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_top, 0, 0, R.anim.exit_to_top)
                .replace(R.id.container_points, fragmentBag)
                .addToBackStack(null)
                .commit();
    }

    public void openFragmentBoard(){

        FragmentBoard fragmentBoard = new FragmentBoard();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, 0, 0, R.anim.exit_to_right)
                .replace(R.id.container_board, fragmentBoard, "SHOW_BOARD_TAG")
                .addToBackStack(null)
                .commit();
    }


    public void openFragmentRattail(){

        FragmentRattails fragmentRattails = new FragmentRattails();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, 0, 0, R.anim.exit_to_button)
                .replace(R.id.container_points, fragmentRattails, "RATTAILS")
                .addToBackStack(null)
                .commit();
    }

    //Fresh initialization of new round
    public void startNewRound(){
        arrBagBak = new ArrayList<>(arrBag);
        currentRound += 1;
        currentStep = MainActivity.currentStart;
        Arrays.fill(MainActivity.board, -1);
        currentWhite = 0;

        isExploded = false;

        //getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(0, R.anim.exit_to_button).remove(this).commit();
        mainActivity.fragment_round_info.updateInfo();
    }

    //Put items back in bag
    public void backToBag(){
        arrBag = new ArrayList<>(MainActivity.arrBagBak);
        img_current_item.setImageDrawable(null);
    }

    public void openBuyRefillAndStep(){

    }


    public void deactivateButtons(){
        btn_next.setEnabled(false);
        btn_back_in_bag.setEnabled(false);
    }

    public void activateButtons(){
        btn_next.setEnabled(true);
        btn_back_in_bag.setEnabled(true);
    }


    @Override
    public void onInputASent(int i) {


        Log.d("wow", Integer.toString(i));

        arrBag.add(i);
        Toast.makeText(MainActivity.this, colors.get(i) + " added to bag",
                Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBackPressed() {

        //activateButtons();
        /*
        if(getSupportFragmentManager().findFragmentByTag("ROUND_FINISHED")!= null){
            openBuyItem();
        }
        */
        //super.onBackPressed();

    }

    public void closeFragment(){
        activateButtons();
        this.getSupportFragmentManager().popBackStack();
    }


    @Override
    public void onInputPointsSent(int i) {

    }

    @Override
    public void onInput_round_info_Sent() {

    }


    @Override
    public void onInputBuySent(int i) {

    }


}
