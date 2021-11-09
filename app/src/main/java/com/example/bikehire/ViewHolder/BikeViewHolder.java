package com.example.bikehire.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikehire.Interface.ItemClickListener;
import com.example.bikehire.R;

public class BikeViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

    public TextView bike_name;
    public ImageView bike_image;
    public ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public BikeViewHolder(@NonNull View itemView) {
        super(itemView);
        bike_name = itemView.findViewById(R.id.bike_name);
        bike_image=itemView.findViewById(R.id.bike_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(), false);
    }
}
