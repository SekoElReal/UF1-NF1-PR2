package com.example.recu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private TextView emailTextView;
    private TextView dniTextView;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String correo, String dni) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString("correo", correo);
        args.putString("dni", dni);
        fragment.setArguments(args);

        Log.d("Fragment2", "Correo: " + correo + ", DNI: " + dni);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        emailTextView = view.findViewById(R.id.TV_PrintEmail);
        dniTextView = view.findViewById(R.id.TV_PrintDNI);

        // Obtén los valores del correo y el DNI del argumento del fragmento
        Bundle args = getArguments();
        if (args != null) {
            String correo = args.getString("correo");
            String dni = args.getString("dni");

            // Asigna los valores a los TextView
            emailTextView.setText(correo);
            dniTextView.setText(dni);
        }

        return view;
    }

}



