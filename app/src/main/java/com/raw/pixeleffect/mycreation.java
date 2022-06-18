package com.raw.pixeleffect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class mycreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycreation);

        getSupportActionBar().hide();

        ImageView iback;

        iback = findViewById(R.id.iback);

        iback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mycreation.this,home.class);
                startActivity(intent);
                finish();
            }
        });

    }
}