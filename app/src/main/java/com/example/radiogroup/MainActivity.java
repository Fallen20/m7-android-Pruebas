package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioButton boton1R1;
    private RadioButton boton2R1;
    private RadioButton boton3R1;

    private RadioGroup radioGroup2;
    private RadioButton boton1R2;
    private RadioButton boton2R2;
    private RadioButton boton3R2;

    private RadioGroup radioGroup3;
    private RadioButton boton1R3;
    private RadioButton boton2R3;
    private RadioButton boton3R3;

    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links
        radioGroup1=findViewById(R.id.grupoRadio1);
        radioGroup2=findViewById(R.id.grupoRadio2);
        radioGroup3=findViewById(R.id.grupoRadio3);

        boton1R1=findViewById(R.id.boton1R1);
        boton2R1=findViewById(R.id.boton2R1);
        boton3R1=findViewById(R.id.boton3R1);

        boton1R2=findViewById(R.id.boton1R2);
        boton2R2=findViewById(R.id.boton2R2);
        boton3R2=findViewById(R.id.boton3R2);

        boton1R3=findViewById(R.id.boton1R3);
        boton2R3=findViewById(R.id.boton2R3);
        boton3R3=findViewById(R.id.boton3R3);

        aSwitch=findViewById(R.id.switch1);


        //al iniciar la app alguno esta seleccionado? Checked=true
        //clickable es que no se puede hacer click, aka no puede cambiar
        //ahora, en java

        boton1R1.setChecked(true);
        boton1R2.setChecked(true);
        //no pueden haber 2 activados en el mismo grupo. Tiene prioridad lo escrito aqui y no el puesto en el layout


        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int seleccionado=radioGroup1.getCheckedRadioButtonId();//esto devuelve el id del boton seleccionad
                RadioButton seleccionTexto= findViewById(seleccionado);

                switch (seleccionado){

                    case R.id.boton1R1://el id que devuelve es el nombre pero en int
                        Toast.makeText(MainActivity.this, seleccionTexto.getText(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.boton2R1://el id que devuelve es el nombre pero en int
                        Toast.makeText(MainActivity.this, seleccionTexto.getText(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.boton3R1://el id que devuelve es el nombre pero en int
                        Toast.makeText(MainActivity.this, seleccionTexto.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });


        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int seleccionado=radioGroup2.getCheckedRadioButtonId();//esto devuelve el id del boton seleccionad
                RadioButton seleccionTexto= findViewById(seleccionado);

                switch (seleccionado){
                    case R.id.boton1R2://el id que devuelve es el nombre pero en int
                        Toast.makeText(MainActivity.this, seleccionTexto.getText(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.boton2R2://el id que devuelve es el nombre pero en int


                        for(int contador=0;contador<radioGroup2.getChildCount();contador++){
                            radioGroup2.getChildAt(contador).setClickable(false);
                        }

                        for(int contador=0;contador<radioGroup1.getChildCount();contador++){
                            radioGroup1.getChildAt(contador).setClickable(false);
                        }

                        Toast.makeText(MainActivity.this, seleccionTexto.getText(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.boton3R2://el id que devuelve es el nombre pero en int
                        Toast.makeText(MainActivity.this, seleccionTexto.getText(), Toast.LENGTH_SHORT).show();
                        radioGroup2.clearCheck();
                        break;
                }

            }
        });


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    for(int contador=0;contador<radioGroup2.getChildCount();contador++){
                        radioGroup2.getChildAt(contador).setClickable(true);
                    }

                    for(int contador=0;contador<radioGroup1.getChildCount();contador++){
                        radioGroup1.getChildAt(contador).setClickable(true);
                    }
                }


            }
        });






    }
}