

        package com.example.recu;



        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.FragmentManager;
        import androidx.lifecycle.ViewModelProvider;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.FrameLayout;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager, fragmentManager2;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private MyViewModel viewModel;
    private TextView fragmentlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtén el ViewModel desde ViewModelProvider
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);




        // Crea una instancia del Fragment1 y pasa el ViewModel
        fragment1 = Fragment1.newInstance(viewModel);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();

        Button btnSave = findViewById(R.id.BT_Save);
        EditText editNombre = findViewById(R.id.ET_Nombre);
        EditText editApellidos = findViewById(R.id.ET_Apellido);
        fragmentManager2 = getSupportFragmentManager();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoIngresado = editNombre.getText().toString();
                String textoIngresado2 = editApellidos.getText().toString();
                String correo = fragment1.getCorreo();
                String dni = fragment1.getDni();
                fragment2 = Fragment2.newInstance(viewModel);
                viewModel.setEmail(correo);
                viewModel.setDni(dni);


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("texto2", textoIngresado2);
                intent.putExtra("texto", textoIngresado);
                startActivity(intent);
            }

        });
    }
}
