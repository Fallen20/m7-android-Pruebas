package com.example.json;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private List<Peak> peakList =new ArrayList<>();

    public MyAdapter(Context context, List<Peak> peakList) {
        this.context = context;
        this.peakList = peakList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.peak_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt1.setText(peakList.get(position).getName());
        holder.txt2.setText(peakList.get(position).getHeight());
        holder.txt3.setText(peakList.get(position).getCountry());
        Picasso.get().load(peakList.get(position).getUrl()).fit().centerCrop().into(holder.imagen);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", peakList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("height", peakList.get(holder.getAdapterPosition()).getHeight());
                intent.putExtra("prominence", peakList.get(holder.getAdapterPosition()).getProminence());
                intent.putExtra("zone", peakList.get(holder.getAdapterPosition()).getZone());
                intent.putExtra("country", peakList.get(holder.getAdapterPosition()).getCountry());
                intent.putExtra("url", peakList.get(holder.getAdapterPosition()).getUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peakList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView txt1;
        private TextView txt2;
        private TextView txt3;
        private ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen=itemView.findViewById(R.id.imagenRow);
            txt1=itemView.findViewById(R.id.texto1Row);
            txt2=itemView.findViewById(R.id.texto2Row);
            txt3=itemView.findViewById(R.id.texto3Row);
            constraintLayout=itemView.findViewById(R.id.linearRow);
        }
    }
}
