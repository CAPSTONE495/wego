package com.example.wego.ui.Drive;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DriveViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DriveViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is drive fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}