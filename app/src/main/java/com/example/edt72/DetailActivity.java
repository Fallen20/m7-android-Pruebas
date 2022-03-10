package com.example.edt72;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView tituloDetail;
    private ImageView imageDetail;
    private TextView positionDetail;

    //personalidad
    private TextView personalityDescDetail;

    //story
    private TextView backstoryDescDetail;

    //batalla

    private TextView battleDescDetail;
    private ImageView battleSprite;
    private ImageView worldSprite;


    private TextView power1Tit;
    private TextView power1Des;
    private ImageView power1Img;

    private TextView power2Tit;
    private TextView power2Desc;
    private ImageView power2Img;

    private ImageView imagenBatallaGrande;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tituloDetail=findViewById(R.id.tituloDetail);//asignar objetos a las vars
        imageDetail=findViewById(R.id.imageProduct);
        positionDetail=findViewById(R.id.cargoDetail);
        power1Tit= findViewById(R.id.Poder1Tit);
        power2Tit= findViewById(R.id.Poder2Tit);

        Intent i=getIntent();//recuperas los datos que te ha enviado

        String titulo=i.getStringExtra(MainActivity.TITULO_PROD);//recupera esta var de la main y la guarda
        int img=i.getIntExtra(MainActivity.IMG_PROD, R.drawable.asgore);//sino lo encuentra pon a frisk
        String description=i.getStringExtra(MainActivity.POS_PROD);
        String power1Title=i.getStringExtra(MainActivity.POWER1_TIT);
        String power2Title=i.getStringExtra(MainActivity.POWER2_TIT);

        tituloDetail.setText(titulo);//ahora le asignas el texto que hemos recuperado
        imageDetail.setImageResource(img);//asignas la imagen recuperada, este es el icono de arriba
        positionDetail.setText(description);
        power1Tit.setText(power1Title);
        power2Tit.setText(power2Title);

    }
}