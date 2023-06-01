package com.santiago.guaman.traveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void enviarMensaje(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        EditText txt_msg_1 = findViewById(R.id.txt_name_act_1);
        Calendar calendar = Calendar.getInstance();
        EditText txt_msg_3 = findViewById(R.id.txt_estatura_act_1);
        EditText txt_msg_4 = findViewById(R.id.txt_email_act_1);
        Switch swt_casado = findViewById(R.id.switch_casado_act1);

        String nombre_apellido = txt_msg_1.getText().toString();
        String fecha = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());
        String email = txt_msg_4.getText().toString();
        Boolean casado = swt_casado.isChecked();
        try {
            Double estatura = Double.parseDouble(txt_msg_3.getText().toString());

            if (nombre_apellido.isEmpty() || email.isEmpty()) {
                Snackbar.make(findViewById(R.id.body), "Llene todos los campos.", 3000).show();
                return;
            }
                intent.putExtra("mensa1", nombre_apellido);
                intent.putExtra("mensa2", fecha);
                intent.putExtra("mensa3", estatura);
                intent.putExtra("mensa4", email);
                intent.putExtra("mensa5", casado);
                startActivity(intent);  //Iniciamos el segundo activity
        } catch (NumberFormatException nfe) {
            Snackbar.make(findViewById(R.id.body), "Llene todos los campos.", 3000).show();
        }



    }

}