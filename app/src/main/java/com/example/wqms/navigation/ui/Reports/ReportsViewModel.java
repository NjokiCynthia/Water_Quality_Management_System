package com.example.wqms.navigation.ui.Reports;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReportsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ReportsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}