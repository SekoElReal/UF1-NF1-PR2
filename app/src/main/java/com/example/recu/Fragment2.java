package com.example.recu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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

    private String email;
    private String dni;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String email, String dni) {
        Fragment2 fragment2 = new Fragment2();
        Bundle args = new Bundle();
        args.putString("email", email);
        args.putString("dni", dni);
        fragment2.setArguments(args);
        return fragment2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            email = getArguments().getString("email");
            dni = getArguments().getString("dni");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        emailTextView = view.findViewById(R.id.TV_PrintEmail);
        dniTextView = view.findViewById(R.id.TV_PrintDNI);

        if (email != null) {
            emailTextView.setText(email);
        }

        if (dni != null) {
            dniTextView.setText(dni);
        }

        return view;
    }
}
