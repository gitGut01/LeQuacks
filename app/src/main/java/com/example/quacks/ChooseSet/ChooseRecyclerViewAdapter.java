package com.example.quacks.ChooseSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quacks.ColorInfo.ColorInfoAb;
import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.List;

public class ChooseRecyclerViewAdapter extends RecyclerView.Adapter<ChooseRecyclerViewAdapter.ViewHolder> {

    private List<ColorInfoAb> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    private ChooseRecyclerViewAdapter my_this;

    // data is passed into the constructor
    ChooseRecyclerViewAdapter(Context context, List<ColorInfoAb> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        my_this = this;
    }


    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row_choose, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cl_card.setBackgroundColor(mData.get(position).getBg());
        holder.cl_card.setAlpha(0.5f);
        holder.cl_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                v.setAlpha(1.0f);
                MainActivity.set_to_play[mData.get(position).colorNr()] = mData.get(position).getSet();
                Toast.makeText(v.getContext(),  mData.get(position).getHeader(), Toast.LENGTH_SHORT).show();
                my_this.notifyDataSetChanged();

            }
        });

        holder.tv_info.setText(mData.get(position).getInfo());
        holder.tv_header.setText(mData.get(position).getHeader());

        if(mData.get(position).getSet() == MainActivity.set_to_play[mData.get(position).colorNr()]){
            holder.cl_card.setAlpha(1.0f);
        }

        holder.tv_1.setText(Integer.toString(mData.get(position).getPrice()[1]));
        holder.img_1.setImageResource(MainActivity.arrDrawable.get(mData.get(position).getArrDrawable()[1]));

        //If not Orange
        if(!mData.get(position).isSingle()) {

            holder.tv_0.setText(Integer.toString(mData.get(position).getPrice()[0]));
            holder.tv_2.setText(Integer.toString(mData.get(position).getPrice()[2]));

            holder.img_0.setImageResource(MainActivity.arrDrawable.get(mData.get(position).getArrDrawable()[0]));
            holder.img_2.setImageResource(MainActivity.arrDrawable.get(mData.get(position).getArrDrawable()[2]));

        }
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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //notifyDataSetChanged();
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ColorInfoAb getItem(int id) {
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