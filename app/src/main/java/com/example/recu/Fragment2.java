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

    public static Fragment2 newInstance(MyViewModel viewModel) {
        Fragment2 fragment = new Fragment2();
        fragment.setViewModel(viewModel);
        return fragment;
    }

    public void setViewModel(MyViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        emailTextView = view.findViewById(R.id.TV_PrintEmail);
        dniTextView = view.findViewById(R.id.TV_PrintDNI);

        viewModel.getEmailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String correo) {
                emailTextView.setText(correo);
                Log.d("Fragment2", "Email changed: " + correo);
            }
        });

        viewModel.getDniLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String dni) {
                dniTextView.setText(dni);
                Log.d("Fragment2", "DNI changed: " + dni);
            }
        });


        return view;
    }


}



