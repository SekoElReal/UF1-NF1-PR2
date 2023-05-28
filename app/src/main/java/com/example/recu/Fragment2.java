package com.example.recu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private MyViewModel viewModel;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        emailTextView = view.findViewById(R.id.TV_PrintEmail);
        dniTextView = view.findViewById(R.id.TV_PrintDNI);

        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        viewModel.getEmailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String correo) {
                emailTextView.setText(correo);
            }
        });

        viewModel.getDniLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String dni) {
                dniTextView.setText(dni);
            }
        });

        // Obtener los valores del ViewModel
        String correo = viewModel.getEmail();
        String dni = viewModel.getDni();
        emailTextView.setText(correo);
        dniTextView.setText(dni);


        return view;
    }

}



