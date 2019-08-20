package com.example.quacks;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BuyRecyclerViewAdapter extends RecyclerView.Adapter<BuyRecyclerViewAdapter.ViewHolder> {

    private List<ColorSet> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    AdapterInterface listener;

    public interface AdapterInterface{
        void onInputBuyItem();
    }


    // data is passed into the constructor
    BuyRecyclerViewAdapter(Context context, List<ColorSet> data, AdapterInterface listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.listener = listener;
    }


    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row_buy, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.cl_card.setBackgroundColor(mData.get(position).getBg());
        holder.tv_header.setText(mData.get(position).getHeader());
        holder.tv_info.setText(mData.get(position).getInfo());


        holder.img_1.setImageResource(mData.get(position).get_img_1());
        holder.tv_1.setText(Integer.toString(mData.get(position).getPrice1()));


        holder.img_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!holder.bought_this_round) {
                    v.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.img_click));

                    buyTheItem(mData.get(position).get_item_for_bag()[1],
                            mData.get(position).getPrice1(), holder);

                    Toast.makeText(v.getContext(), "You bought a " + mData.get(position).getColor() + " 2 item", Toast.LENGTH_SHORT).show();

                }
            }
        });


        //If not Orange
        if(!mData.get(position).isSingle()) {

            holder.tv_0.setText(Integer.toString(mData.get(position).getPrice0()));
            holder.tv_2.setText(Integer.toString(mData.get(position).getPrice2()));

            holder.img_0.setImageResource(mData.get(position).get_img_0());
            holder.img_2.setImageResource(mData.get(position).get_img_2());


            holder.img_0.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!holder.bought_this_round) {
                        v.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.img_click));

                        buyTheItem(mData.get(position).get_item_for_bag()[0],
                                mData.get(position).getPrice0(), holder);

                        Toast.makeText(v.getContext(), "You bought a " + mData.get(position).getColor() + " 1 item", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            holder.img_2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!holder.bought_this_round) {
                        v.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.img_click));

                        buyTheItem(mData.get(position).get_item_for_bag()[2],
                                mData.get(position).getPrice2(), holder);

                        Toast.makeText(v.getContext(), "You bought a " + mData.get(position).getColor() + " 4 item", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void buyTheItem(int itemNr, int price, ViewHolder holder){
        MainActivity.arrBag.add(itemNr);
        MainActivity.currentCredits -= price;
        listener.onInputBuyItem();
        holder.cl_card.setAlpha(0.4f);
        holder.bought_this_round = true;
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_header;
        TextView tv_info;

        Boolean bought_this_round;

        TextView tv_0, tv_1, tv_2;

        ImageView img_0, img_1, img_2;

        ConstraintLayout cl_card;


        ViewHolder(View itemView) {
            super(itemView);
            tv_header = itemView.findViewById(R.id.tv_header);
            tv_info = itemView.findViewById(R.id.tv_info);

            tv_0 = itemView.findViewById(R.id.tv_0);
            tv_1 = itemView.findViewById(R.id.tv_1);
            tv_2 = itemView.findViewById(R.id.tv_2);

            img_0 = itemView.findViewById(R.id.img_0);
            img_1 = itemView.findViewById(R.id.img_1);
            img_2 = itemView.findViewById(R.id.img_2);

            cl_card = itemView.findViewById(R.id.cl_card);

            bought_this_round = false;



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ColorSet getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }



}