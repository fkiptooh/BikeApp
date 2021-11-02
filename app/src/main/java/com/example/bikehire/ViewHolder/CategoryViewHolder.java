package com.example.bikehire.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikehire.Interface.ItemClickListener;
import com.example.bikehire.R;

public class CategoryViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtModelName;
    public ImageView imageView;
    public ItemClickListener itemClickListener;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtModelName = itemView.findViewById(R.id.model_name);
        imageView=itemView.findViewById(R.id.model_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(), false);

    }
}
