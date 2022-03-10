package com.example.edt27;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//todo lo que queremos animar debemos ponerlo en vars y asigarlo
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image4R;
    private ImageView image5;

    private int estadoImagen1=0;
    private int estadoImagen2=0;
    private int estadoImagen4=0;

    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;
    ObjectAnimator rotation1;
    ObjectAnimator rotation2;
    ObjectAnimator alpha1;
    ObjectAnimator alpha0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1= findViewById(R.id.image1);
        image2= findViewById(R.id.image2);
        image3= findViewById(R.id.image3);
        image4= findViewById(R.id.image4);
        image4R= findViewById(R.id.image4Reverse);
        image5= findViewById(R.id.image5);

        image4R.setAlpha(0f);//ahora no es visible

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoImagen1==0){
                    AnimatorSet set;
                    set= (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.frontanimator);
                    //cargamos la animacion en esta clase

                    set.setTarget(v);//a quien le damos la animacion y como tenemos el onclick usamos el view
                    set.start();//haz la animacion
                    estadoImagen1=1;
                }
               else if(estadoImagen1>0){//si ya se ha ejecutado lo de antes, aka la imagen esta al reves
                    AnimatorSet set;
                    set= (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.backanimation);
                    set.setTarget(v);//a quien le damos la animacion y como tenemos el onclick usamos el view
                    set.start();//haz la animacion
                    estadoImagen1=0;
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(estadoImagen2==0){//manera2 de hacerlo, sin archivo externo
                    objectAnimator1 =ObjectAnimator.ofFloat(image2,"rotationY",0f,180f);
                    //puede ser la image2 o view. Es la que nos estamos refiriendo
                    //el segundo es el tipo de animacion
                    //el tercero son los ejes
                    objectAnimator2=ObjectAnimator.ofFloat(view, "pivotX",0f,250f);//mismo valor que el tamano de la imagen, en teoria


                    objectAnimator1.setDuration(1000);
                    objectAnimator2.setDuration(1000);

                    //objectAnimator1.setStartDelay(50);//delay en milisegundos

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(objectAnimator1, objectAnimator2);//ahora las dos se hacen a la vez
                    set.start();
                    //objectAnimator1.start();
                    estadoImagen2=1;
                }
                else{
                    objectAnimator1 =ObjectAnimator.ofFloat(image2,"rotationY",180f,0f);
                    //puede ser la image2 o view. Es la que nos estamos refiriendo
                    //el segundo es el tipo de animacion
                    //el tercero son los ejes
                    objectAnimator1.setDuration(1000);
                    objectAnimator1.start();
                    estadoImagen2=0;
                }

            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(estadoImagen4==0){
                    alpha0=ObjectAnimator.ofFloat(view,"alpha",1f,0f);//desaparece
                    rotation1=ObjectAnimator.ofFloat(view,"rotationY",0f,180f);//gira

                    alpha1=ObjectAnimator.ofFloat(image4R,"alpha",0f,1f);//desaparece
                    rotation2=ObjectAnimator.ofFloat(image4R,"rotationY",0f,180f);

                    alpha0.setDuration(1);
                    alpha0.setStartDelay(500);
                    rotation1.setDuration(1000);

                    alpha1.setDuration(1);
                    alpha1.setStartDelay(500);
                    rotation2.setDuration(1000);


                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotation1, alpha0, alpha1, rotation2);//ahora las dos se hacen a la vez
                    set.start();
                    estadoImagen4=1;
                }
                else{
                    alpha0=ObjectAnimator.ofFloat(image4R,"alpha",1f,0f);//desaparece
                    rotation1=ObjectAnimator.ofFloat(image4R,"rotationY",180f,0f);//gira

                    alpha1=ObjectAnimator.ofFloat(image4,"alpha",0f,1f);//desaparece
                    rotation2=ObjectAnimator.ofFloat(image4,"rotationY",180f,0f);

                    alpha0.setDuration(0);
                    alpha0.setStartDelay(500);
                    rotation1.setDuration(1000);

                    alpha1.setDuration(0);
                    alpha1.setStartDelay(500);
                    rotation2.setDuration(1000);


                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotation1, alpha0, alpha1, rotation2);//ahora las dos se hacen a la vez
                    set.start();
                    estadoImagen4=0;
                }
            }
        });
    }
}