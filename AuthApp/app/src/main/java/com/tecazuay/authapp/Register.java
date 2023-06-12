package com.tecazuay.authapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Register extends AppCompatActivity {

    EditText emailTxt;
    EditText passwordTxt;
    ImageButton buttonRegister;

    TextView textView;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textView = findViewById(R.id.txt_login);
        textView.setOnClickListener(l -> LoginNow());
    }

    public void LoginNow() {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }

    public void RegisterCall(View view) {

        emailTxt = findViewById(R.id.txt_email_register);
        passwordTxt = findViewById(R.id.txt_password_register);
        buttonRegister = findViewById(R.id.button_register);
        mAuth = FirebaseAuth.getInstance();
        String email = String.valueOf(emailTxt.getText());
        String password = String.valueOf(passwordTxt.getText());

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(Register.this, "Ingrese " + (TextUtils.isEmpty(email) ? "un email" : "una contraseña de al menos 6 dígitos") , Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Cuenta creada.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register.this, "Falló la autenticación.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}