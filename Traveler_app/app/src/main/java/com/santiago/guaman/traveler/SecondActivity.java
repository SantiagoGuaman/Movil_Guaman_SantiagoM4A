package com.santiago.guaman.traveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String nombre_apellido = intent.getStringExtra("mensa1");
        String fecha = intent.getStringExtra("mensa2");
        Double estatura = intent.getDoubleExtra("mensa3",0);
        String email = intent.getStringExtra("mensa4");
        Boolean casado = intent.getBooleanExtra("mensa5", false);

        TextView textview1 = findViewById(R.id.txt_name_act2);
        TextView textview2 = findViewById(R.id.txt_date_act2);
        TextView textview3 = findViewById(R.id.txt_height_act2);
        TextView textview4 = findViewById(R.id.txt_email_act2);
        TextView textview5 = findViewById(R.id.txt_casado);
        textview1.setText(nombre_apellido);
        textview2.setText(fecha);
        textview3.setText(estatura.toString());
        textview4.setText(email);
        if (casado) {
            textview5.setText("Casado");
        } else {
            textview5.setText("No Casado");
        }
    }

    public void OpenSettings(View view) {
        Intent intent = new Intent(this, Settings_activity.class);
        startActivity(intent);
    }
}