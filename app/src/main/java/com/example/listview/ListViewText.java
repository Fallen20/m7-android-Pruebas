package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewText extends AppCompatActivity {
    private ListView listView;
    List<String> lista=new ArrayList<>();
    ArrayAdapter<String> adapter;//para la arraylist



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_text);

        listView=findViewById(R.id.listViewTxt);

        for(int contador=1;contador<=30;contador++){lista.add("ejemplo LISTVIEW "+contador);}

        adapter=new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                lista);//esto solo adapta arrayList a cual contexto (la activity que esta ligada)
        //la forma y los datos
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewText.this,"Has hecho click en la posicion "+position, Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //esto es cuando le haces click durante +1s
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewText.this,"Has hecho LONG click en la posicion "+position, Toast.LENGTH_LONG).show();
                return true;
            }
        });


    }


}