package com.example.recu;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
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
                Fragment2 fragment2 = new Fragment2(); // Crea una instancia de tu fragmento
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment2) // Reemplaza el contenido del contenedor con el fragmento
                        .commit();




                Intent intent = getIntent();
                String textoRecibido = intent.getStringExtra("texto");
                String textoRecibido2 = intent.getStringExtra("texto2");
                boolean b = textoRecibido2 != null;
                boolean b1 = b;
                if (textoRecibido != null)  {
                        textNombre.setText(textoRecibido);
                }
                if (b) {
                        textNombre2.setText(textoRecibido2);
                }
        }
}