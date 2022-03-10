package com.example.edt01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textResult;//txtview es el tipo de cosa que es
    private TextView casilla1;
    private TextView casilla2;
    private Button boton_suma;
    private Button boton_resta;
    private Button boton_multi;
    private Button boton_div;
    private Button boton_info;//no hace falta que sea el id

    Calculator calc=new Calculator();//instanciando la clase para usar sus metodos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//metodo java, a donde y el link al layout

        textResult=findViewById(R.id.textResult);//R> en resource; id>buscame el id; nombre ID
        casilla1=findViewById(R.id.casilla1);
        casilla2=findViewById(R.id.casilla2);
        boton_suma=findViewById(R.id.boton_suma);
        boton_resta=findViewById(R.id.boton_resta);
        boton_multi=findViewById(R.id.boton_multi);
        boton_div=findViewById(R.id.boton_div);
        boton_info=findViewById(R.id.boton_out);//busca el ID del objeto, no el string

        //metodo1
        boton_suma.setOnClickListener(new View.OnClickListener() {
            //cuando le haces click. Creas una clase anonima que te hace esto
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_SHORT);
                //donde lo quieres mostrar, que texto (string) y cuanto estara en pantalla

                toast.setGravity(Gravity.TOP,0,120);
                //donde quierea que salga
                //el primero es la posicion relativa (arriba, abajo..)
                //el segundo es la X desde la posicion relativa. Lo tercero la altura

                toast.show();
                //el show es para que lo muestre por pantalla

                double num1= Double.parseDouble(casilla1.getText().toString().trim());
                double num2= Double.parseDouble(casilla2.getText().toString().trim());
                //guarda los numeros

                textResult.setText(calc.suma(num1, num2)+"");
                //sino le pones +"" no lo acepta porque el setText es un texto y queremos darle un num

                Log.e(MainActivity.class.getSimpleName(),"Lol caiste");
                //el log es el sitio donde salen los errores en android studio
                //lo primero es simplemente para conseguir el nombre
            }
        });

        boton_info.setOnClickListener(new View.OnClickListener() {
            //cuando le haces click. Creas una clase anonima que te hace esto
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, infoActivity.class);
                //el origen a donde
                //estamos haciendo que cuando hacen click en el boton nos lleve a otro sitio

                startActivity(intent);
               // startService(intent);//con esto te lleva a a otra que le dices. Sino no hace nada
            }
        });

    }
    //metodo2
    public void buttonRestaClick(View v){
        double num1= Double.parseDouble(casilla1.getText().toString().trim());
        double num2= Double.parseDouble(casilla2.getText().toString().trim());
        //guarda los numeros

        textResult.setText(calc.resta(num1, num2)+"");
        //sino le pones +"" no lo acepta porque el setText es un texto y queremos darle un num
    }
}