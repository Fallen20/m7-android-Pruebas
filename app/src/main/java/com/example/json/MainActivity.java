package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Peak> peakList = new ArrayList<>();
    private static String JSONURL = "https://run.mocky.io/v3/59d6508d-522d-412e-ad22-425eaa2cd1f1";
    //esta es la url del json en internet
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMain);
        initJSONData();

    }

    private void initJSONData() {//recoger los datos del json y guardarlas en la case
        RequestQueue queue = Volley.newRequestQueue(this);//donde se guardan los datos

        //tien [ en el segundo elemento?>array
        //tiene un texto/numero en el segundo elemento¿>objeto normal
        JsonArrayRequest peaksObj = new JsonArrayRequest(
                Request.Method.GET,//get o put
                JSONURL,//url
                null,//si pedimos datos?
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {//response son los datos de dentro de la array
                        //ahora ya hemos leido la array, leemos la propia array
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();


                        for (int contador = 0; contador < response.length(); contador++) {
                            //como son muchos, podemos hacer un for

                            try {
                                JSONObject objetos = response.getJSONObject(contador);
                                //tenemos el objeto, ahora lo metemos en la clase
                                //cada objeto es un peak y guardamos todos los elementos de la clase
                                Peak peak = new Peak();
                                peak.setName(objetos.getString("name"));//pillamos el valor de dentro de la etiqueta 'name'
                                peak.setHeight(objetos.getString("height"));//pillamos el valor de dentro de la etiqueta 'name'
                                peak.setProminence(objetos.getString("prominence"));//pillamos el valor de dentro de la etiqueta 'name'
                                peak.setZone(objetos.getString("zone"));//pillamos el valor de dentro de la etiqueta 'name'
                                peak.setUrl(objetos.getString("url"));//pillamos el valor de dentro de la etiqueta 'name'
                                peak.setCountry(objetos.getString("country"));//pillamos el valor de dentro de la etiqueta 'name'

                                peakList.add(peak);//añadimos

                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Error leyendo datos", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        }

                        //con los datos llenos adaptamos el recycler como normal
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        myAdapter = new MyAdapter(getApplicationContext(), peakList);
                        recyclerView.setAdapter(myAdapter);

                    }
                }, //si da respuesta ok
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Ha habido un error", Toast.LENGTH_SHORT).show();
                        //podrias indagar en el error pero sino ponemos un toast general
                    }
                }//si da error


        );//instancias array porque el primero es array


        queue.add(peaksObj);//añadimos lo que hemos recogido


    }
}