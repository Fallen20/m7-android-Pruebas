package com.example.menunavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.NavigableMap;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLinear);
        navigationView=findViewById(R.id.nav);

        //toolbar
        toolbar= findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //layout_gravity==foreground_gravity es para que lo de detras salga pero en oscuro
        //firsSystemWindow es para que ocupe toda la pantalla
        //lo que empieza con toool es de diseño
        //openDrawer: start es para que al abrir la app salga

        //navigation
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,//contexto
                drawerLayout,
                toolbar,
                R.string.open,//constante String. Puede ser cualquier texto
                R.string.close//constante String
        );
        drawerLayout.addDrawerListener(toggle);//dar el toggle al drawer
        toggle.syncState();//sincronizar

        navigationView.setCheckedItem(R.id.home);//por defecto está seleccionado este

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//esto es para que salga
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);//primero el xml, luego el menu que  nos da el metodo

        return true;//true es que se ha creado
    }

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
            case R.id.home://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Home menu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bike://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Bike menu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.car://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Car menu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.foot://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Foot menu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.plane://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Plane", Toast.LENGTH_SHORT).show();
                break;

            case R.id.perfil://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.salir://los id de los iconos del desplegable (my_menu)
                Toast.makeText(this, "Salir de la app", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);//cerrarlo
        return true;
    }

}