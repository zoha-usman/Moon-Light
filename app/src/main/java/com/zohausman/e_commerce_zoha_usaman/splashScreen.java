package com.zohausman.e_commerce_zoha_usaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent HomeActivity = new Intent(splashScreen.this, MainActivity.class);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(HomeActivity);
            }
        }, 4000);



    }
}