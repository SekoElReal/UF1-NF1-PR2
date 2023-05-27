package com.example.recu;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editNombre = findViewById(R.id.ET_Nombre);
        EditText editApellidos = findViewById(R.id.ET_Apellido);

        fragmentManager = getSupportFragmentManager();

        Fragment1 fragment1 = Fragment1.newInstance();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment1)
                .commit();

        Button btnSave = findViewById(R.id.BT_Save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editNombre.getText().toString();
                String apellidos = editApellidos.getText().toString();

                Fragment2 fragment2 = Fragment2.newInstance(nombre, apellidos);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment2)
                        .commit();
            }
        });
    }
}

