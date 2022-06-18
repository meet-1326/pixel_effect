package com.raw.pixeleffect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.canhub.cropper.CropImageView;

public class crop extends AppCompatActivity {

    public static Bitmap bitmap;

    CropImageView image;
    ImageView right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        getSupportActionBar().hide();

        image = findViewById(R.id.image);
        right = findViewById(R.id.right);

        image.setImageUriAsync(home.uri);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap = image.getCroppedImage();
                Intent intent = new Intent(crop.this,edit.class);
                startActivity(intent);
            }
        });

    }
}