package com.example.recu;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
        private FragmentManager fragmentManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main2);

                TextView textNombre = findViewById(R.id.TV_PrintNombre);
                TextView textNombre2 = findViewById(R.id.TV_PrintApellidos);

                fragmentManager = getSupportFragmentManager();

                Fragment2 fragment2 = Fragment2.newInstance();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment2)
                        .commit();

                Intent intent = getIntent();
                String textoRecibido = intent.getStringExtra("texto");
                String textoRecibido2 = intent.getStringExtra("texto2");

                // Agregar mensajes de registro en el Logcat
                Log.d("MainActivity2", "Received Texto: " + textoRecibido);
                Log.d("MainActivity2", "Received Texto2: " + textoRecibido2);

                boolean b = textoRecibido2 != null;
                if (textoRecibido != null) {
                        textNombre.setText(textoRecibido);
                }
                if (b) {
                        textNombre2.setText(textoRecibido2);
                }
        }
}
