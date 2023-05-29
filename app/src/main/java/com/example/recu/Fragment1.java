package com.example.recu;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModel;
import androidx.fragment.app.Fragment;
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
    private MyViewModel viewModel;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance(MyViewModel viewModel) {
        Fragment1 fragment11= new Fragment1();
        fragment11.setViewModel(viewModel);
        return fragment11;
    }

    public void setViewModel(MyViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        emailEditText = view.findViewById(R.id.ET_Email);
        dniEditText = view.findViewById(R.id.ET_DNI);

        return view;

    }

    public String getCorreo() {
        return emailEditText.getText().toString();
    }

    public String getDni() {
        return dniEditText.getText().toString();
    }

}