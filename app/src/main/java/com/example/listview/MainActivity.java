package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button listView_text;
    private Button gridView_text;
    private Button listView_class;
    private Button gridView_class;

    public static String TITULO_PROD="com.exampl.ListView.TITULO_PROD";
    public static String SUBTITULO_PROD="com.exampl.ListView.SUBTITULO_PROD";
    public static String DESC_PROD="com.exampl.ListView.DESC_PROD";
    public static String DETAIL_PROD="com.exampl.ListView.DETAIL_PROD";

    public static String IMG_PROD="com.exampl.ListView.IMG_PROD";
    public static String ICONOLIST_PROD="com.exampl.ListView.ICONOLIST_PROD";
    public static String ICONOClASS_PROD="com.exampl.ListView.ICONOClASS_PROD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_class=findViewById(R.id.listClass);
        gridView_class=findViewById(R.id.gridClass);
        listView_text=findViewById(R.id.listTxt);
        gridView_text=findViewById(R.id.gridTxt);

        listView_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ListViewText.class);
                startActivity(intent);
            }
        });


        gridView_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, GridViewText.class);
                startActivity(intent);
            }
        });

        listView_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ListViewClass.class);
                startActivity(intent);
            }
        });


        gridView_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, GridViewClass.class);
                startActivity(intent);
            }
        });





    }

    //se cargan de arrayList/clase y se muestran todos
    //no hace falta scroll view porque ya lo hace

    //se puede hacer con un listView, gridView, listgrid y gridview


}