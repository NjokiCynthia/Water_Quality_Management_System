package com.example.wqms.navigation.ui.Sales_Reports;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SalesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}