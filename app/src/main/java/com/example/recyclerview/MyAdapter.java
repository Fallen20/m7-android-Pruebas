package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //los elementos del adapter que le vamos a dar
    private String[] title;
    private String[] desc;
    private int[] img;
    private Context context;


    public MyAdapter(String[] title, String[] desc, int[] img, Context context) {
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //devuelve la inher class
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_row,parent,false);
                //false no lo enseña ahora, sino hasta que no la instancia no lo muestra
        //para hacer cada linea que base usa, de donde lo pilla

        //guardas el inflate en una view y luego lo pones en la clase que recibe un view y devuelve myviewholder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder coge las cosas de la clase interna, asi que hemos de poner las cosas ahi antes
        //linea a linea, le da el texto
        holder.tit.setText(title[position]);
        holder.subtit.setText(desc[position]);
        holder.imagenRow.setImageResource(img[position]);

        holder.layout.setOnClickListener(new View.OnClickListener() {//ahora el layout esta en listener
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("tit", title[holder.getAdapterPosition()]);
                intent.putExtra("sub", desc[holder.getAdapterPosition()]);
                intent.putExtra("img", img[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;//como todas las arrays son iguales, puedes devolver la largaria del que quieras
    }

    //esto es una clase interna
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tit;//el mismo nombre que los elementos de item_row
        TextView subtit;
        ImageView imagenRow;

        //solo activityDetail
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {//constructor
            super(itemView);

            //aunque sea un constructor se hacen los hooks aqui

            //para hacer el findById se necesitauna vista asi que usamos la del constructor
            tit=itemView.findViewById(R.id.tit);
            subtit=itemView.findViewById(R.id.subtit);
            imagenRow=itemView.findViewById(R.id.imagenRow);
            //como hemos puesto el mismo id para ambos actividades, eligirá uno u otro en funcion de lo que reciba

            layout=itemView.findViewById(R.id.linearLayout);
        }

    }
}
