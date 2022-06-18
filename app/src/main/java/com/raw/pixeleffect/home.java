package com.raw.pixeleffect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class home extends AppCompatActivity {

    public static Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        ImageView istart, ialbum, imore, option;

        istart = findViewById(R.id.iaddtext);
        ialbum = findViewById(R.id.isize);
        imore = findViewById(R.id.icolor);
        option = findViewById(R.id.option);

        istart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1001);
            }
        });

        ialbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, mycreation.class);
                startActivity(intent);
            }
        });


        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(home.this, option);
                menu.getMenuInflater().inflate(R.menu.item, menu.getMenu());
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){

                            case R.id.rate:
                                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.ojasplus.ojasplus");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                break;
                            case R.id.share:
                                Intent sharing = new Intent(Intent.ACTION_SEND);
                                sharing.setType("text/plain");
                                sharing.putExtra(Intent.EXTRA_SUBJECT , "https://play.google.com/store/apps/details?id=com.ojasplus.ojasplus");
                                sharing.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.ojasplus.ojasplus");
                                startActivity(Intent.createChooser(sharing ,"Share via"));
                                break;
                            case R.id.more:
                                Uri uri1 = Uri.parse("https://play.google.com/store/apps/dev?id=8254489790785742148");
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri1);
                                startActivity(intent2);
                                break;
                            case R.id.privacy:
                                Uri uri2 = Uri.parse("https://appinflew.blogspot.com/2022/05/ojas-plus.html");
                                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri2);
                                startActivity(intent3);
                                break;

                        }
                        return false;
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){

            if(requestCode == 1001){
                uri = data.getData();
                Intent intent1 = new Intent(home.this,crop.class);
                startActivity(intent1);
            }

        }

    }
}