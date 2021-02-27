package com.example.farmerfriend.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.farmerfriend.R;

public class Watermelon extends AppCompatActivity {

    private Button btnWatermelonGline;
    private Button btnWF;
    private Button btnWateremelonInsects;
    private Button btnDisease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermelon);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnWatermelonGline=(Button) findViewById(R.id.btnWatermelonGline);
        btnWF=(Button) findViewById(R.id.btnWF);
        btnWateremelonInsects=(Button) findViewById(R.id.btnWateremelonInsects);
        btnDisease=(Button) findViewById(R.id.btnDisease);

        btnWatermelonGline.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                btnWatermelonGline();
            }

        });

        btnWF.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWF();
            }
        });

        btnWateremelonInsects.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWateremelonInsects();
            }
        });

        btnDisease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent watermelonIntent= new Intent(Watermelon.this, WatermelonDisease.class);
                startActivity(watermelonIntent);

            }
        });

    }

    private void btnWatermelonGline() {

        Intent watermelonIntent= new Intent(Watermelon.this, WatermelonGuideline.class);
        startActivity(watermelonIntent);

    }

    private void btnWF() {

        Intent watermelonIntent= new Intent(Watermelon.this, WatermelonFertilizer.class);
        startActivity(watermelonIntent);

    }

    private void btnWateremelonInsects() {

        Intent watermelonIntent= new Intent(Watermelon.this, WatermelonInsects.class);
        startActivity(watermelonIntent);

    }
}