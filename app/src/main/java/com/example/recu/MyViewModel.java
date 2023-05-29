package com.example.recu;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> emailLiveData = new MutableLiveData<>();
    private MutableLiveData<String> dniLiveData = new MutableLiveData<>();

    public LiveData<String> getEmailLiveData() {
        return emailLiveData;
    }

    public LiveData<String> getDniLiveData() {
        return dniLiveData;
    }

    public void setEmail(String email) {
        emailLiveData.setValue(email);
        Log.d("MyViewModel", "Email set: " + email);
    }

    public void setDni(String dni) {
        dniLiveData.setValue(dni);
        Log.d("MyViewModel", "DNI set: " + dni);
    }

    public String getEmail() {
        return emailLiveData.getValue();
    }

    public String getDni() {
        return dniLiveData.getValue();
    }
}