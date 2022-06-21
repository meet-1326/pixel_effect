package com.raw.pixeleffect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.raw.pixeleffect.Adapters.Adapter3D;
import com.raw.pixeleffect.Adapters.AdapterEffect;
import com.raw.pixeleffect.Adapters.AdapterFilter;
import com.raw.pixeleffect.Adapters.AdapterGlare;
import com.raw.pixeleffect.Adapters.AdapterSticker;
import com.raw.pixeleffect.Model.model3D;
import com.raw.pixeleffect.Model.modelEffect;
import com.raw.pixeleffect.Model.modelGlare;
import com.raw.pixeleffect.Model.modelSticker;
import com.raw.pixeleffect.Utils.utils;

import java.util.ArrayList;
import java.util.List;

public class edit extends AppCompatActivity {

    LinearLayout btn3D,btneffect,btncolor,btnglare,btnfilter,btntext,btnsticker,btnrotate,btnflip,lsize;
    RecyclerView tdeffect,effect,glare,filter,sticker;
    TextView tvcolor,maintext,tvsizedone;
    ImageView is1,is2,is3,is4,is5,is6,iaddtextdone,iaddtext,isize;
    EditText edaddtext;
    CardView cvaddtext;
    SeekBar sbsize;
    public static Dialog dialog,dialog1;
    public static ImageView back_img,front_img;

    private  static  final String TAG = "MainActivity";

    List<model3D> model3D = new ArrayList<>();
    List<modelEffect> modelEffect = new ArrayList<>();
    List<modelGlare> modelGlare = new ArrayList<>();

    int check=0;
    float i=0,f=0;
    String smaintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        getSupportActionBar().hide();

        dialog = new Dialog(edit.this, com.google.android.material.R.style.ShapeAppearance_Material3_Corner_Full);
        dialog.setContentView(R.layout.stickerdialog);
        dialog1 = new Dialog(edit.this, com.google.android.material.R.style.ShapeAppearance_Material3_Corner_Full);
        dialog1.setContentView(R.layout.addtext);

        Binding();

        front_img.setImageBitmap(crop.bitmap);

        adddata();
        adpaters();

        btn3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = 0;
                if(check==0){
                    Gone();
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                    tdeffect.setVisibility(View.VISIBLE);
                    tdeffect.startAnimation(animation);
                    check=1;
                }else {
                    Gone();
                    check=0;
                }
            }
        });
        btneffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check = 0;
                if(check==0){
                    Gone();
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                    effect.setVisibility(View.VISIBLE);
                    effect.startAnimation(animation);
                    check=1;
                }else {
                    Gone();
                    check=0;
                }
            }
        });
        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ColorPickerDialogBuilder
                        .with(edit.this)
                        .setTitle("Choose color")
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {

                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                edit.back_img.setColorFilter(selectedColor);
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
            }
        });
        btnglare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = 0;
                if(check==0){
                    Gone();
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                    glare.setVisibility(View.VISIBLE);
                    glare.startAnimation(animation);
                    check=1;
                }else {
                    Gone();
                    check=0;
                }
            }
        });
        btnfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = 0;
                if(check==0){
                    Gone();
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                    filter.setVisibility(View.VISIBLE);
                    filter.startAnimation(animation);
                    check=1;
                }else {
                    Gone();
                    check=0;
                }
            }
        });
        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.show();
                iaddtext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(smaintext == ""){
                            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up_size);
                            cvaddtext.setVisibility(View.VISIBLE);
                            cvaddtext.startAnimation(animation);
                        }
                    }
                });
                iaddtextdone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        smaintext = edaddtext.getText().toString();
                        cvaddtext.setVisibility(View.GONE);
                        maintext.setText(smaintext);
                        maintext.setVisibility(View.VISIBLE);
                    }
                });
                isize.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        sbsize.setProgress(26);
                        sbsize.incrementProgressBy(1);
                        sbsize.setMin(27);
                        sbsize.setMax(76);
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
                        lsize.setVisibility(View.VISIBLE);
                        lsize.startAnimation(animation);
                    }
                });
                tvsizedone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lsize.setVisibility(View.GONE);
                    }
                });
                sbsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        maintext.setTextSize(progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        });
        btnsticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                is1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s1);
                        sticker.setAdapter(adapter4);

                    }
                });
                is2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s2);
                        sticker.setAdapter(adapter4);
                    }
                });
                is3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s3);
                        sticker.setAdapter(adapter4);
                    }
                });
                is4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s4);
                        sticker.setAdapter(adapter4);
                    }
                });
                is5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s5);
                        sticker.setAdapter(adapter4);
                    }
                });
                is6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s6);
                        sticker.setAdapter(adapter4);
                    }
                });
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==360){
                    front_img.setRotation(90);
                    i = 90;
                }else{
                    i= i+90;
                    front_img.setRotation(i);
                }
            }
        });
        btnflip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f==0){
                    front_img.setRotationY(180);
                    f=1;
                }else{
                    front_img.setRotationY(0);
                    f=0;
                }
            }
        });

    }

    private void Binding() {
        btn3D = findViewById(R.id.btn3D);
        btneffect = findViewById(R.id.btneffect);
        btncolor = findViewById(R.id.btncolor);
        btnglare = findViewById(R.id.btnglare);
        btnfilter = findViewById(R.id.btnfilter);
        btntext = findViewById(R.id.btntext);
        btnsticker = findViewById(R.id.btnsticker);
        btnrotate = findViewById(R.id.btnrotate);
        btnflip = findViewById(R.id.btnflip);
        tvcolor = findViewById(R.id.tvcolor);
        back_img = findViewById(R.id.back_img);
        front_img = findViewById(R.id.front_img);
        back_img = findViewById(R.id.back_img);

        is1 = dialog.findViewById(R.id.is1);
        is2 = dialog.findViewById(R.id.is2);
        is3 = dialog.findViewById(R.id.is3);
        is4 = dialog.findViewById(R.id.is4);
        is5 = dialog.findViewById(R.id.is5);
        is6 = dialog.findViewById(R.id.is6);

        tdeffect = findViewById(R.id.tdeffect);
        effect = findViewById(R.id.effect);
        glare = findViewById(R.id.glare);
        filter = findViewById(R.id.filter);
        sticker = dialog.findViewById(R.id.sticker);

        cvaddtext = dialog1.findViewById(R.id.cvaddtext);
        iaddtext = dialog1.findViewById(R.id.iaddtext);
        edaddtext = dialog1.findViewById(R.id.edaddtext);
        iaddtextdone = dialog1.findViewById(R.id.iaddtextdone);
        maintext = dialog1.findViewById(R.id.maintext);
        isize = dialog1.findViewById(R.id.isize);
        sbsize = dialog1.findViewById(R.id.sbsize);
        lsize = dialog1.findViewById(R.id.lsize);
        tvsizedone = dialog1.findViewById(R.id.tvsizedone);
    }

    private void adddata() {
        for (int i = 0; i < utils.tdeffect.length; i++) {
            model3D data = new model3D(utils.tdeffect[i]);
            model3D.add(data);
        }
        for (int i = 0; i < utils.effect.length; i++) {
            modelEffect data = new modelEffect(utils.effect[i]);
            modelEffect.add(data);
        }
        for (int i = 0; i < utils.glare.length; i++) {
            modelGlare data = new modelGlare(utils.glare[i]);
            modelGlare.add(data);
        }
    }

    private void adpaters() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(edit.this,LinearLayoutManager.HORIZONTAL,false);
        Adapter3D adapter = new Adapter3D(edit.this,model3D);
        tdeffect.setLayoutManager(manager);
        tdeffect.setAdapter(adapter);

        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(edit.this,LinearLayoutManager.HORIZONTAL,false);
        AdapterEffect adapter1 = new AdapterEffect(edit.this,modelEffect);
        effect.setLayoutManager(manager1);
        effect.setAdapter(adapter1);

        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(edit.this,LinearLayoutManager.HORIZONTAL,false);
        AdapterGlare adapter2 = new AdapterGlare(edit.this,modelGlare);
        glare.setLayoutManager(manager2);
        glare.setAdapter(adapter2);

        RecyclerView.LayoutManager manager3 = new LinearLayoutManager(edit.this, LinearLayoutManager.HORIZONTAL, false);
        AdapterFilter adapter3 = new AdapterFilter(edit.this);
        filter.setLayoutManager(manager3);
        filter.setAdapter(adapter3);

        RecyclerView.LayoutManager manager4 = new GridLayoutManager(edit.this,3,GridLayoutManager.VERTICAL,false);
        AdapterSticker adapter4 = new AdapterSticker(edit.this,utils.s1);
        sticker.setAdapter(adapter4);
        sticker.setLayoutManager(manager4);
    }

    private void Gone() {
        tdeffect.setVisibility(View.GONE);
        effect.setVisibility(View.GONE);
        glare.setVisibility(View.GONE);
        filter.setVisibility(View.GONE);
    }

}