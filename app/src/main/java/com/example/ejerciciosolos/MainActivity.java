package com.example.ejerciciosolos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    Switch aSwitch2;
    SwitchCompat aSwitch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch=findViewById(R.id.switch1);
        aSwitch2=findViewById(R.id.switch2);
        aSwitch3=findViewById(R.id.switch3);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean a =aSwitch.isChecked();
                String valor=String.valueOf(a);
                Toast.makeText(MainActivity.this, valor, Toast.LENGTH_SHORT).show();
            }
        });

        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                }

            }
        });


        aSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}