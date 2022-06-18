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
import com.raw.pixeleffect.Model.modelSticker;
import com.raw.pixeleffect.R;
import com.raw.pixeleffect.crop;
import com.raw.pixeleffect.edit;

import java.util.List;

public class AdapterSticker extends RecyclerView.Adapter<AdapterSticker.StickerHolder>{

    Activity activity;
    int[] s1;
    public AdapterSticker(edit edit, int[] s1) {

        activity = edit;
        this.s1 = s1;

    }


    @NonNull
    @Override
    public StickerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.stickers,parent,false);
        return new AdapterSticker.StickerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StickerHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.sticker_icon.setImageResource(s1[position]);

        holder.sticker_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.back_img.setImageResource(s1[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    class StickerHolder extends RecyclerView.ViewHolder{
        ImageView sticker_icon;
        public StickerHolder(@NonNull View itemView) {
            super(itemView);
            sticker_icon = itemView.findViewById(R.id.sticker_icon);
        }
    }

}
