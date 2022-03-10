package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    List<Picture> pictureList= new ArrayList<>();
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        drawerLayout=findViewById(R.id.drawerLinear);
        navigationView=findViewById(R.id.nav);
        toolbar= findViewById(R.id.toolbarMain);

        //TOOLBAR
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //navigation
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,//contexto
                drawerLayout,
                toolbar,
                R.string.open,//constante String. Puede ser cualquier texto
                R.string.close//constante String
        );

        drawerLayout.addDrawerListener(toggle);//dar el toggle al drawer
        toggle.syncState();//sincronizar

        navigationView.setCheckedItem(R.id.perfil);//por defecto está seleccionado este



        crearElementos();

    }
    //ESTO ES PARA QUE SALGAN LOS 3 PUNTOS A LA DERECHA/ICONOS.
    //como solo queremos que salga la toolbar con el menu hamburgesa no se pone
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);//primero el xml, luego el menu que  nos da el metodo

        return true;//true es que se ha creado
    }*/

    @Override
    public void onBackPressed() {//cuando tiras para atras con el desplazo abierto, se cierra eso y no la app
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {//start es que se abre por la izq
            Toast.makeText(this, "Se ha cerrado el desplazo", Toast.LENGTH_SHORT).show();

            drawerLayout.closeDrawer(GravityCompat.START);
            //ambos GravityCompat han de ser el mismo
        }
        else {
            Toast.makeText(this, "Se ha cerrado la app", Toast.LENGTH_SHORT).show();

            super.onBackPressed();//se cierra la app
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.upload://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Subiendo una imagen", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mensajes://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "No tienes mensajes sin leer", Toast.LENGTH_SHORT).show();
                break;

            case R.id.localizacion://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Compartiendo localización...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.perfil://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Hola Larry!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "No hay nada que configurar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.salir://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Saliendo..", Toast.LENGTH_SHORT).show();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);//cerrarlo
        return true;
    }

    private void crearElementos() {
        for (int i = 1; i <= 38; i++) {
            String finalurl = "";
            String name = "";

            if (i<10) {
                finalurl = "https://joanseculi.com/images/img0" + i + ".jpg";
                name = "img0" + i;
            }
            else {
                finalurl = "https://joanseculi.com/images/img" + i + ".jpg";
                name = "img0" + i;
            }
            pictureList.add(new Picture(finalurl, name, "Description"));
        }
    }
}