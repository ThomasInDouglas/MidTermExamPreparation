package com.example.exampreparation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MID TERM DEMO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started Mid Term Demo.");
        //findViewById must be done only after setContentView
        Button btnName = findViewById(R.id.btnIdName);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //what needs to be done when button is clicked
                //start another Activity
                startActivity(new Intent(MainActivity.this, AnotherActivity.class));
            }
        });
        Button btnAudio = findViewById(R.id.btnAudio);
        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AudioActivity.class));
            }
        });

        //put the icon in ActionBar and switch the display title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_round);
        actionBar.setTitle(R.string.txtTitle);
    }
}