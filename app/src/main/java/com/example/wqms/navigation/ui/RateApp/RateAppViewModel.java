package com.example.wqms.navigation.ui.RateApp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RateAppViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public RateAppViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Rate Us...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}