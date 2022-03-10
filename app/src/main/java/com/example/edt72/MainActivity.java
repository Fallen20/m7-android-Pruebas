package com.example.edt72;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String TITULO_PROD="com.exampl.Edt72_parte2.TITULO_PROD";//constantes
    //com.exampl es fijo. Edt72_parte2 es el nombre del archivo TITULO_PROD es el nombre de la constante
    public static String IMG_PROD="com.exampl.Edt72_parte2.IMG_PROD";
    public static String POS_PROD="com.exampl.Edt72_parte2.POS_PROD";

    //personalidad
    public static String PERSONALITY_PROD="com.exampl.Edt72_parte2.PERSONALITY_PROD";

    //story
    public static String STORY_PROD="com.exampl.Edt72_parte2.STORY_PROD";

    //batttle
    public static String BATTLE_DES_PROD="com.exampl.Edt72_parte2.BATTLE_DES_PROD";
    public static String BATTLE_SPRITE="com.exampl.Edt72_parte2.BATTLE_SPRITE";
    public static String WORLD_SPRITE="com.exampl.Edt72_parte2.WORLD_SPRITE";


    public static String POWER1_TIT="com.exampl.Edt72_parte2.POWER1_TIT";
    public static String POWER1_DESC="com.exampl.Edt72_parte2.POWER1_DESC";
    public static String POWER1_IMG="com.exampl.Edt72_parte2.POWER1_IMG";


    public static String POWER2_TIT="com.exampl.Edt72_parte2.POWER2_TIT";
    public static String POWER2_DESC="com.exampl.Edt72_parte2.POWER2_DESC";
    public static String POWER2_IMG="com.exampl.Edt72_parte2.POWER2_IMG";

    //estas son las cosaas que vamos a cambiar

    private CardView card11;//cardview del grid




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//esto siempre esta, no borrar

        card11= findViewById(R.id.card11);//buscar el cardview del layout original y se lo asignamos
        card11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){//para que cuando aprete pase algo
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.asgore);//este texto esta en string
                String position=getString(R.string.position);
                int imagenTop= R.drawable.asgore;//envias una imagen

                //personalidad
                String personalidad="hola esto es la personalidad del personaje";//guardar en strings
                //story

                //batalla
                String power1= getString(R.string.power1);
                String power1Desc="blavla";
                int imagenPoder1=0;//aqui no envias una imagen
                String power2= getString(R.string.blank);




                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);//de la case donde estas a cual quieres ir
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);


                intent.putExtra(POWER1_TIT, power1);//envia imagenes
                intent.putExtra(POWER2_TIT, power2);
                startActivity(intent);//ahora salta

            }
        });
    }

}