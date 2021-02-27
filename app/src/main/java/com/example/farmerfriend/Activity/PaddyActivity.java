package com.example.farmerfriend.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.farmerfriend.R;

public class PaddyActivity extends AppCompatActivity implements View.OnClickListener{

    Button guideline,insects,fertilizer,disease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddy);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        guideline=findViewById(R.id.guideline);
        insects=findViewById(R.id.insects);
        fertilizer=findViewById(R.id.fertilizerVitamin);
        disease=findViewById(R.id.disease);


        guideline.setOnClickListener(this);
        insects.setOnClickListener(this);
        fertilizer.setOnClickListener(this);
        disease.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guideline:
                Intent intent1= new Intent(PaddyActivity.this,PaddyGuideline.class);
                startActivity(intent1);
                break;
            case R.id.insects:
                Intent intent= new Intent(PaddyActivity.this,PaddyInsectsActivity.class);
                startActivity(intent);
                break;
            case R.id.fertilizerVitamin:
                Intent intent2= new Intent(PaddyActivity.this,PaddyFertilizerActivity.class);
                startActivity(intent2);
                break;
            case R.id.disease:
                Intent intent3= new Intent(PaddyActivity.this,PaddyDiseaseActivity.class);
                startActivity(intent3);
                break;
        }
    }
}