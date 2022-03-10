package com.example.spinnerejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;//esto es el menu desplegable
    private Spinner spinner2;//esto es el menu desplegable
    private Spinner spinner3;//esto es el menu desplegable con clase

    private List<String> menu=new ArrayList<>();
    private ArrayList<Clase2> objetosClaseSpinner;//lista de ojetos de la clase de solo los attr
    private ClaseAdapter claseAdapter;//instanciamos la clase que hace todo


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3ClaseExt);

        menu.add(0,"Elige una opcion");//posicion, texto
        menu.add(1,"arrayList opcion1");//posicion, texto
        menu.add(2,"arrayList opcion2");//posicion, texto
        menu.add(3,"arrayList opcion3");//posicion, texto
        menu.add(4,"arrayList opcion4");//posicion, texto
        menu.add(5,"arrayList opcion5");//posicion, texto

        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                this,//a que afecta
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.arraySpinner1)//esto busca la array
        );

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);


        ArrayAdapter<String> adapterArrayList=new ArrayAdapter<>(
                this,//a que afecta
                R.layout.estilo_spinner,
                menu//esto busca la array. Como es una propia arraylist y no string-array (que son strings), lo añadimos directamente
        );

        adapterArrayList.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapterArrayList);//le damos todo al spinner


//con array en otro sitio
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String seleccionado = parent.getItemAtPosition(position).toString();
                    Toast.makeText(MainActivity.this,seleccionado, Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(MainActivity.this, "No has seleccionado nada" , Toast.LENGTH_SHORT).show();
                }
            }
        );



//ahora con arraylist
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccionado = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, seleccionado , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No has seleccionado nada" , Toast.LENGTH_SHORT).show();
            }
        });


        initList();//ahora crea los objetos

        claseAdapter=new ClaseAdapter(this,objetosClaseSpinner);
        //a la clase que adapta, le damos el contexto (donde queremos que se cree) y la array
        spinner3.setAdapter(claseAdapter);//ahora el spinner3 saca esto

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //el ? en el AdapterView<?> es un general. Le podemos pasar cualquier cosa

                Clase2 seleccionado = (Clase2) parent.getItemAtPosition(position);
                String selectedTxt=seleccionado.getNombreOriginal();
                int selectedImg=seleccionado.getImagenOriginal();

                Toast.makeText(MainActivity.this, selectedTxt,Toast.LENGTH_SHORT).show();




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No has seleccionado nada" , Toast.LENGTH_SHORT).show();
            }
        });













    }//oncreate

    private void initList(){//ahora añadimos cosas a la arraylist
        objetosClaseSpinner=new ArrayList<>();
        objetosClaseSpinner.add(new Clase2("Nombre 1",R.drawable.catto));
        objetosClaseSpinner.add(new Clase2("Nombre 2",R.drawable.ejemplo));
        objetosClaseSpinner.add(new Clase2("Nombre 3",R.drawable.catto));
        objetosClaseSpinner.add(new Clase2("Nombre 4",R.drawable.catto));
//esto podemos hacerlo dentro como el add del menu
    }

}