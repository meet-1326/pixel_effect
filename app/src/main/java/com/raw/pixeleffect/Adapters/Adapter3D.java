package com.raw.pixeleffect.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raw.pixeleffect.Model.model3D;
import com.raw.pixeleffect.R;
import com.raw.pixeleffect.crop;
import com.raw.pixeleffect.edit;

import java.util.List;

public class Adapter3D extends RecyclerView.Adapter<Adapter3D.EffectHolder>{

    Activity activity;
    List<model3D> dataList;

    public Adapter3D(edit edit , List<model3D> dataList) {
        activity = edit;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EffectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.effect,parent,false);
        return new EffectHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EffectHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.back.setImageBitmap(crop.bitmap);
        holder.front.setImageResource(dataList.get(position).tdeffcet);
        holder.front.setColorFilter(activity.getResources().getColor(R.color.white));

        holder.front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.back_img.setImageResource(dataList.get(position).tdeffcet);
                edit.back_img.setColorFilter(activity.getResources().getColor(R.color.white));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EffectHolder extends RecyclerView.ViewHolder {

        ImageView back,front;

        public EffectHolder(@NonNull View itemView) {
            super(itemView);

            back = itemView.findViewById(R.id.back);
            front = itemView.findViewById(R.id.front);

        }
    }

}
