package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;//importa uno corto por defecto, este es el correcto

public class MainActivity extends AppCompatActivity {
    private TextView textoCentro;
    private ImageView img;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoCentro=findViewById(R.id.textoCentro);
        img=findViewById(R.id.img);
        toolbar=findViewById(R.id.toolbarMain);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//esto es para que salga
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);//primero el xml, luego el menu que  nos da el metodo

        return true;//true es que se ha creado
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //para cuando le apretas al icono
        switch(item.getItemId()){

            case R.id.item1://los id de los item del menu
                img.setVisibility(View.INVISIBLE);

                Toast.makeText(this, "Carrito de compra", Toast.LENGTH_SHORT).show();

                intentSecondAct();
                return true;

            case R.id.item2:
                img.setVisibility(View.INVISIBLE);

                Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
                intentSecondAct();

                return true;

            case R.id.item3:
                img.setVisibility(View.INVISIBLE);
                textoCentro.setText("Vehiculos go brrr");

                Toast.makeText(this, "Item3", Toast.LENGTH_SHORT).show();
                return true;

                //SUBMENU
            case R.id.item3_1:
                img.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.ic_coche);

                animationImg();

                Toast.makeText(this, "Has seleccionado el coche!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3_2:
                img.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.ic_patinete);
                animationImg();

                Toast.makeText(this, "Has seleccionado el patinete!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3_3:
                img.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.ic_avion);
                animationImg();

                Toast.makeText(this, "Has seleccionado el avion!", Toast.LENGTH_SHORT).show();
                return true;
            //FIN SUBMENU


            case R.id.item4:
                img.setVisibility(View.INVISIBLE);

                Toast.makeText(this, "El mapa", Toast.LENGTH_SHORT).show();
                intentSecondAct();
                return true;

            case android.R.id.home:
                Toast.makeText(this, "Has seleccionado el menu hamburgesa", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }














    private void intentSecondAct() {
        Intent intent=new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void animationImg(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(img,"rotationY",0f,360f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
//si showAsAction:always Siempre salen los iconos
//si showAsAction:never> salen 3 puntos y apretas y sale en desplegable
//vsi showAsAction:ifRoom>saca los iconos que pueda en el espacio, los demás se muestran en el menu de 3 puntos