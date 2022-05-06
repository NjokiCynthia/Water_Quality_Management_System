package com.example.wqms.navigation.ui.PH_DATA;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PHViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PHViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the PH fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}