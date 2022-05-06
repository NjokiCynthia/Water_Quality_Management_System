package com.example.wqms.navigation.ui.Live_Data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LiveDataViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Live Data fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}