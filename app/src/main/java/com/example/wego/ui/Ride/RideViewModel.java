package com.example.wego.ui.Ride;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RideViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RideViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ride fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}