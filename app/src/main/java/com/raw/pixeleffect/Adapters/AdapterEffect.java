package com.raw.pixeleffect.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raw.pixeleffect.Model.modelEffect;
import com.raw.pixeleffect.R;
import com.raw.pixeleffect.crop;
import com.raw.pixeleffect.edit;

import java.util.List;

public class AdapterEffect extends RecyclerView.Adapter<AdapterEffect.EffectHolder> {

    Activity activity;
    List<modelEffect> modelEffect;

    public AdapterEffect(edit edit, List<modelEffect> modelEffect) {

        activity = edit;
        this.modelEffect = modelEffect;

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
        holder.front.setImageResource(modelEffect.get(position).effcet);
        holder.front.setColorFilter(activity.getResources().getColor(R.color.white));

        holder.front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.back_img.setImageResource(modelEffect.get(position).effcet);
                edit.back_img.setColorFilter(activity.getResources().getColor(R.color.white));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelEffect.size();
    }

    class EffectHolder extends RecyclerView.ViewHolder{

        ImageView back,front;

        public EffectHolder(@NonNull View itemView) {
            super(itemView);
            back = itemView.findViewById(R.id.back);
            front = itemView.findViewById(R.id.front);
        }
    }

}
