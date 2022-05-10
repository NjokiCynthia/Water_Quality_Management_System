package com.example.wqms.navigation.ui.Reservoir;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReservoirViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ReservoirViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the reservoir fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}