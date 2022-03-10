package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView name;
    private TextView height;
    private TextView prominence;
    private TextView zone;
    private TextView country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imagen=findViewById(R.id.imageDetail);
        name=findViewById(R.id.nameDetail);
        height=findViewById(R.id.heightDetail);
        prominence=findViewById(R.id.prominenceDetail);
        zone=findViewById(R.id.zoneDetail);
        country=findViewById(R.id.countryDetail);

        Intent i=getIntent();

        String nameRecuperado=i.getStringExtra("name");
        String heightRecuperado=i.getStringExtra("height");
        String prominenceRecuperado=i.getStringExtra("prominence");
        String zoneRecuperado=i.getStringExtra("zone");
        String countryRecuperado=i.getStringExtra("country");
        String urlRecuperado=i.getStringExtra("url");

        name.setText(nameRecuperado);
        height.setText(heightRecuperado);
        prominence.setText(prominenceRecuperado);
        zone.setText(zoneRecuperado);
        country.setText(countryRecuperado);
        Picasso.get().load(urlRecuperado).fit().centerCrop().into(imagen);


    }
}