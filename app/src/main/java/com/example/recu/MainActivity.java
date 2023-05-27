package com.example.recu;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSave = findViewById(R.id.BT_Save);
        EditText editNombre = findViewById(R.id.ET_Nombre);
        EditText editApellidos = findViewById(R.id.ET_Apellido);
        fragmentManager = getSupportFragmentManager();
        Fragment1 fragment1 = new Fragment1(); // Crea una instancia de tu fragmento
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment1) // Reemplaza el contenido del contenedor con el fragmento
                .commit();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoIngresado = editNombre.getText().toString();
                String textoIngresado2 = editApellidos.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("texto2", textoIngresado2);
                intent.putExtra("texto", textoIngresado);
                startActivity(intent);
            }
        });
    }
}