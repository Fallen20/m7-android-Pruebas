package com.example.guardardatostelf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String FILE_SHARE_NAME="SharedFile";
    private EditText name;
    private EditText email;
    private EditText telf;

    private Button save;
    private Button recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //modos: private> solo esta app pueede acceder al archivo
        //modo: multi_process>el archivo puede ser modificar el arhcivo

        name=findViewById(R.id.nameInt);
        email=findViewById(R.id.emailInt);
        telf=findViewById(R.id.telfInt);
        save=findViewById(R.id.buttonSave);
        recuperar =findViewById(R.id.buttonRecuperar);
        recuperar();



        //mirar el archivo: iniciar emulador>Device file explorer>data>data>buscar el nombre del ejercicio>shared_prefs>ahi esta

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save();

                Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void save() {
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARE_NAME,Context.MODE_PRIVATE);
        //le pasamos el nombre y el modo. El context no hace falta porque ya es THIS

        SharedPreferences.Editor editor= sharedPreferences.edit(); //editor es el intermediario para escribir en el fichero

        //las cosas que guardas
        editor.putString("name", name.getText().toString());//como en intents; etiqueta y el valor asignado a
        editor.putString("email", email.getText().toString());//el TOSTRING es mas bien por si pones un numero, que se guarde como string
        editor.putString("telefono", telf.getText().toString());

        editor.commit();//lo guardas
    }

    private void recuperar() {
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARE_NAME,Context.MODE_PRIVATE);

        //recuperar
        String nombreRecuperado=sharedPreferences.getString("name","No se ha encontrado un nombre");
        //name es el texto donde se ha guardado (como una constante) y el segundo es lo que sale si no hay datos asociados a eso
        String telfRecuperado=sharedPreferences.getString("telefono","No se ha encontrado un telefono");
        String emailRecuperado=sharedPreferences.getString("email","No se ha encontrado el email");

        //ponemos el texto recuperado
        name.setText(nombreRecuperado);
        telf.setText(telfRecuperado);
        email.setText(emailRecuperado);
    }
}