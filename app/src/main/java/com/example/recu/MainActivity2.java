package com.example.recu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main2);
                TextView textNombre = findViewById(R.id.TV_PrintNombre);
                TextView textNombre2 = findViewById(R.id.TV_PrintApellidos);

                Intent intent2 = getIntent();
                String textoRecibido2 = intent2.getStringExtra("texto2");

                if (textoRecibido2 != null) {
                        textNombre2.setText(textoRecibido2);
                }
                Intent intent = getIntent();
                String textoRecibido = intent.getStringExtra("texto");

                if (textoRecibido != null) {
                        textNombre.setText(textoRecibido);
                }
        }
}