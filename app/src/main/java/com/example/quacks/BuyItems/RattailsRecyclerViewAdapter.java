package com.example.quacks.BuyItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quacks.MainActivity;
import com.example.quacks.R;

import java.util.List;

public class RattailsRecyclerViewAdapter extends RecyclerView.Adapter<RattailsRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RattailsRecyclerViewAdapter(Context context, List<Integer> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String animal;

        if(mData.get(position) == -1){
            animal = "";
            holder.img_point_bg.setImageResource(R.drawable.rat_tale);
        }else{

            if(mData.get(position) == MainActivity.currentPoint){
                holder.img_point_bg.setImageResource(R.drawable.current_point_bg);
            }else if(mData.get(position) == MainActivity.opponentPoint){
                holder.img_point_bg.setImageResource(R.drawable.opponent_point_bg);
            }else{
                holder.img_point_bg.setImageResource(R.drawable.points_bg);

            }

            animal = Integer.toString(mData.get(position));
        }

        holder.myTextView.setText(animal);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView img_point_bg;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            img_point_bg = itemView.findViewById(R.id.img_point_bg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Integer getItem(int id) {
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