package com.raw.pixeleffect.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flask.colorpicker.Utils;
import com.raw.pixeleffect.Effects;
import com.raw.pixeleffect.R;
import com.raw.pixeleffect.crop;
import com.raw.pixeleffect.edit;

public class AdapterFilter extends RecyclerView.Adapter<AdapterFilter.FilterHolder> {

    Activity activity;
    public AdapterFilter(edit edit) {
        activity = edit;
    }

    @NonNull
    @Override
    public FilterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.effect,parent,false);
        return new FilterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.back.setImageBitmap(crop.bitmap);

        holder.front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Effects.applyEffectNone(edit.front_img);
                        break;
                    case 1:
                        Effects.applyEffect2(edit.front_img);
                        break;
                    case 2:
                        Effects.applyEffect2(edit.front_img);
                        break;
                    case 3:
                        Effects.applyEffect3(edit.front_img);
                        break;
                    case 4:
                        Effects.applyEffect4(edit.front_img);
                        break;
                    case 5:
                        Effects.applyEffect5(edit.front_img);
                        break;
                    case 6:
                        Effects.applyEffect6(edit.front_img);
                        break;
                    case 7:
                        Effects.applyEffect7(edit.front_img);
                        break;
                    case 8:
                        Effects.applyEffect8(edit.front_img);
                        break;
                    case 9:
                        Effects.applyEffect9(edit.front_img);
                        break;
                    case 10:
                        Effects.applyEffect10(edit.front_img);
                        break;
                    case 11:
                        Effects.applyEffect11(edit.front_img);
                        break;
                    case 12:
                        Effects.applyEffect12(edit.front_img);
                        break;
                    case 13:
                        Effects.applyEffect13(edit.front_img);
                        break;
                    case 14:
                        Effects.applyEffect14(edit.front_img);
                        break;
                    case 15:
                        Effects.applyEffect15(edit.front_img);
                        break;
                    case 16:
                        Effects.applyEffect16(edit.front_img);
                        break;
                    case 17:
                        Effects.applyEffect17(edit.front_img);
                        break;
                    case 18:
                        Effects.applyEffect18(edit.front_img);
                        break;
                    case 19:
                        Effects.applyEffect19(edit.front_img);
                        break;
                    case 20:
                        Effects.applyEffect20(edit.front_img);
                        break;
                    case 21:
                        Effects.applyEffect21(edit.front_img);
                        break;
                    case 22:
                        Effects.applyEffect22(edit.front_img);
                        break;
                }
            }
        });
        switch (position) {

            case 0:
                Effects.applyEffectNone(holder.back);
                break;
            case 1:
                Effects.applyEffect2(holder.back);
                break;
            case 2:
                Effects.applyEffect2(holder.back);
                break;
            case 3:
                Effects.applyEffect3(holder.back);
                break;
            case 4:
                Effects.applyEffect4(holder.back);
                break;
            case 5:
                Effects.applyEffect5(holder.back);
                break;
            case 6:
                Effects.applyEffect6(holder.back);
                break;
            case 7:
                Effects.applyEffect7(holder.back);
                break;
            case 8:
                Effects.applyEffect8(holder.back);
                break;
            case 9:
                Effects.applyEffect9(holder.back);
                break;
            case 10:
                Effects.applyEffect10(holder.back);
                break;
            case 11:
                Effects.applyEffect11(holder.back);
                break;
            case 12:
                Effects.applyEffect12(holder.back);
                break;
            case 13:
                Effects.applyEffect13(holder.back);
                break;
            case 14:
                Effects.applyEffect14(holder.back);
                break;
            case 15:
                Effects.applyEffect15(holder.back);
                break;
            case 16:
                Effects.applyEffect16(holder.back);
                break;
            case 17:
                Effects.applyEffect17(holder.back);
                break;
            case 18:
                Effects.applyEffect18(holder.back);
                break;
            case 19:
                Effects.applyEffect19(holder.back);
                break;
            case 20:
                Effects.applyEffect20(holder.back);
                break;
            case 21:
                Effects.applyEffect21(holder.back);
                break;
            case 22:
                Effects.applyEffect22(holder.back);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 23;
    }

    public class FilterHolder extends RecyclerView.ViewHolder {
        ImageView back,front;
        public FilterHolder(@NonNull View itemView) {
            super(itemView);
            back = itemView.findViewById(R.id.back);
            front = itemView.findViewById(R.id.front);
        }
    }

}
