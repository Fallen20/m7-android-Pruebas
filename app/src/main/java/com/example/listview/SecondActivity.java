package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView icono;
    private TextView titulo;
    private TextView subtitulo;
    private TextView descripcion;

    private TextView detalles;

    private ImageView imagenGrande;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //link
        icono=findViewById(R.id.iconoSecond);
        titulo=findViewById(R.id.classTit);
        subtitulo=findViewById(R.id.classSubtit);
        descripcion=findViewById(R.id.classDescript);
        detalles=findViewById(R.id.detalles);
        imagenGrande=findViewById(R.id.imagenBottom);

        Intent i=getIntent();//recuperas los datos que te ha enviado

        //recupera texto
        String title=i.getStringExtra(MainActivity.TITULO_PROD);//recupera esta var de la main que viene y la guarda
        //como viene de dos sitios distintos, poner la var en el main activity, que es comun, ahorra el duplicarlo
        String sutitle=i.getStringExtra(MainActivity.SUBTITULO_PROD);
        String desc=i.getStringExtra(MainActivity.DESC_PROD);
        String details=i.getStringExtra(MainActivity.DETAIL_PROD);

        //recuperar imagens
        int iconoImg=i.getIntExtra(MainActivity.ICONOClASS_PROD, 0);
        int imgGrandeIMG=i.getIntExtra(MainActivity.IMG_PROD, 0);

        //asigna lo recuperado a la activida
        titulo.setText(title);//ahora le asignas el texto que hemos recuperado
        subtitulo.setText(sutitle);
        descripcion.setText(desc);
        detalles.setText(details);
        icono.setImageResource(iconoImg);//esto sin images
        imagenGrande.setImageResource(imgGrandeIMG);
    }
}