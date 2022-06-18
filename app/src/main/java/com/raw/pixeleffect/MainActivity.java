package com.raw.pixeleffect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        TextView title = findViewById(R.id.title);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        title.startAnimation(animation);

        Thread thread = new Thread() {

            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                    finish();
                }
            }

        };
        thread.start();

    }
}