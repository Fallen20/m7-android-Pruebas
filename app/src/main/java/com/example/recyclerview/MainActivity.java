package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String title[];
    String desc[];

    int[] img={R.drawable.catto,R.drawable.ejemplo,R.drawable.mem,R.drawable.catto,R.drawable.ejemplo,R.drawable.mem};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);

        //ahora las arrays de String estan en las que hemos creado aqui
        title=getResources().getStringArray(R.array.tittle);
        desc=getResources().getStringArray(R.array.descripciones);


        MyAdapter myAdapter=new MyAdapter(title, desc, img, this);//el orden de las array enviadas ha de ser el mismo
        //creas un nuevo adaptador con la clase que hemos hecho
        recyclerView.setAdapter(myAdapter);//se lo das


        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));//que layour quiere que muestre (en este caso linear)
        //donde lo muestra
        //como quiere que lo muestre LinearLayoutManager.HORIZONTAL/LinearLayoutManager.VERTICAL
        //false>orden normal, true>el ultimo arriba






    }
}