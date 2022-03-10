package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView textTitle;
    private TextView textDesc;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textTitle = findViewById(R.id.tit);
        textDesc = findViewById(R.id.subtit);
        image =  findViewById(R.id.imagenRow);

        Intent intent=getIntent();
        String tile=intent.getStringExtra("tit");
        String desc=intent.getStringExtra("sub");
        int myImage=intent.getIntExtra("img",0);

        textTitle.setText(tile);
        textDesc.setText(desc);
        image.setImageResource(myImage);

    }
}