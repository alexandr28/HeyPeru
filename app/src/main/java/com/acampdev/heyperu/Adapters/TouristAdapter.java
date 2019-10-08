package com.acampdev.heyperu.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.acampdev.heyperu.Models.Tourist;
import com.acampdev.heyperu.PlaceDet;
import com.acampdev.heyperu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.ViewHolder> {

    List<Tourist> touristList;
    Context context;

    public TouristAdapter(Context applicationContext, List<Tourist> touristList) {
        this.context=applicationContext;
        this.touristList=touristList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        view= layoutInflater.inflate(R.layout.card_lugar,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlaceDet.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name",touristList.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("ubigeo",touristList.get(viewHolder.getAdapterPosition()).getUbigeo());
                intent.putExtra("img",touristList.get(viewHolder.getAdapterPosition()).getImg());
                intent.putExtra("description",touristList.get(viewHolder.getAdapterPosition()).getDescription());

                //intent.putExtra("lat",touristList.get(viewHolder.getAdapterPosition()).getLat());
                //intent.putExtra("longt",touristList.get(viewHolder.getAdapterPosition()).getLongt());

                context.startActivity(intent);
            }
        });
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(touristList.get(position).getName());
        Picasso.get().load(touristList.get(position).getImg()).into(holder.imgPlace);
    }

    @Override
    public int getItemCount() {
        return touristList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView imgPlace;
        CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView=itemView.findViewById(R.id.cardViewID);
            title=itemView.findViewById(R.id.txtNamePlaceID);
            imgPlace=itemView.findViewById(R.id.imgPlaceID);
        }
    }
}
