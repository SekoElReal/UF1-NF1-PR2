package com.example.recu;

import android.os.Bundle;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    private EditText emailEditText;
    private EditText dniEditText;
    private Button nextButton;
    private String correo;
    private String dni;

    public Fragment1(String correo, String dni) {
        this.correo = correo;
        this.dni = dni;
    }




    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        emailEditText = view.findViewById(R.id.ET_Email);
        dniEditText = view.findViewById(R.id.ET_DNI);

        correo = emailEditText.getText().toString();
        dni = dniEditText.getText().toString();

        return view;
    }
}
