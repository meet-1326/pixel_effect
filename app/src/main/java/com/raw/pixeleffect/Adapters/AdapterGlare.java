package com.raw.pixeleffect.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raw.pixeleffect.Model.modelGlare;
import com.raw.pixeleffect.R;
import com.raw.pixeleffect.crop;
import com.raw.pixeleffect.edit;

import java.util.List;

public class AdapterGlare extends RecyclerView.Adapter<AdapterGlare.GlareHolder> {

    Activity activity;
    List<modelGlare> modelGlare;

    public AdapterGlare(edit edit, List<modelGlare> modelGlare) {
        activity = edit;
        this.modelGlare = modelGlare;
    }

    @NonNull
    @Override
    public AdapterGlare.GlareHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.effect,parent,false);
        return new GlareHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGlare.GlareHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.front.setImageResource(modelGlare.get(position).glare);

        holder.front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.back_img.setImageResource(modelGlare.get(position).glare);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelGlare.size();
    }

    public class GlareHolder extends RecyclerView.ViewHolder {
        ImageView back,front;
        public GlareHolder(@NonNull View itemView) {
            super(itemView);
            back = itemView.findViewById(R.id.back);
            front = itemView.findViewById(R.id.front);
        }
    }
}
