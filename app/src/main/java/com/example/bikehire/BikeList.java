package com.example.bikehire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bikehire.Interface.ItemClickListener;
import com.example.bikehire.Model.Bike;
import com.example.bikehire.ViewHolder.BikeViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class BikeList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference bikeList;

    String modelsID="";
    FirebaseRecyclerAdapter<Bike, BikeViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_list);

        database=FirebaseDatabase.getInstance("https://bike-hire-8f968-default-rtdb.firebaseio.com/");
        bikeList=database.getReference("Bikes");

        recyclerView = findViewById(R.id.recycler_bike);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Setting up new intent
        if (getIntent()!=null)
        {
            modelsID=getIntent().getStringExtra("ModelsID");
        }
        if (!modelsID.isEmpty() && modelsID != null){
            loadBikeList(modelsID);
        }
    }

    private void loadBikeList(String modelsID) {
        FirebaseRecyclerOptions<Bike>options= new FirebaseRecyclerOptions.Builder<Bike>()
                .setQuery(bikeList.orderByChild("ModelsID").equalTo(modelsID),Bike.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<Bike, BikeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull BikeViewHolder holder, int position, @NonNull Bike model) {
                holder.bike_name.setText(model.getName());
                Picasso.get().load(model.getImage()).into(holder.bike_image);
                final Bike local = model;

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(BikeList.this, ""+local.getName(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @NonNull
            @Override
            public BikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bike_item,parent,false);
                return new BikeViewHolder(view);
            }
        };
        //set recycler adapter
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
}