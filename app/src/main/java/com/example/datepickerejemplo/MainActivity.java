package com.example.datepickerejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;//esto se necesita para el calendario

    private EditText campoFecha;
    private EditText campoFecha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoFecha=findViewById(R.id.campoFecha);
        campoFecha2=findViewById(R.id.fecha2);
        //context==this==el sitio donde estás

        //antes de hacer el calendario hemos de hacer las fechas
        Calendar calendar= Calendar.getInstance();//se instancia el calendario
        int dia=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
                //ahora podemos usar estas fechas

        campoFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picker=new DatePickerDialog(
                        MainActivity.this, //el sitio donde estas

                        new DatePickerDialog.OnDateSetListener() {//la clase
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //esto es lo que escribe
                                campoFecha.setText(day+"/"+month+"/"+year);//esto es lo que se escribe en sitio del texto

                            }
                        },year, month, dia//ahora los datos que vas a usar: año>mes>dia
                );
             picker.show();
            }
        });


        campoFecha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picker=new DatePickerDialog(
                        MainActivity.this, //el sitio donde estas
                        android.R.style.Theme_Holo_Light,//ahora tiene un estilo
                        new DatePickerDialog.OnDateSetListener() {//la clase
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //esto es lo que escribe
                                campoFecha2.setText(day+"/"+month+"/"+year);//esto es lo que se escribe en sitio del texto

                            }
                        },year, month, dia//ahora los datos que vas a usar: año>mes>dia
                );
                picker.show();
            }
        });



    }
}