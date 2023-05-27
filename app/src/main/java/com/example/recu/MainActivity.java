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
    private Fragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment1 = Fragment1.newInstance();
        setContentView(R.layout.activity_main);
        Button btnSave = findViewById(R.id.BT_Save);
        EditText editCorreo = findViewById(R.id.ET_Email);
        EditText editDNI = findViewById(R.id.ET_DNI);
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

                String textoIngresado5 = fragment1.getCorreo();
                String textoIngresado6 = fragment1.getDni();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("texto2", textoIngresado2);
                intent.putExtra("texto", textoIngresado);
                startActivity(intent);

                Fragment2 fragment2 = Fragment2.newInstance(textoIngresado5, textoIngresado6);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment2)
                        .commit();
            }


        });
    }
}