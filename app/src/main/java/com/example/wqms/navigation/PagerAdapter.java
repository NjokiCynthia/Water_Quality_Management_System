package com.example.wqms.navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wqms.Custom;
import com.example.wqms.Month;
import com.example.wqms.Today;
import com.example.wqms.Week;

public class PagerAdapter extends FragmentPagerAdapter {

    private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm, int Tabs_No) {
        super(fm);
        this.tabsNumber = Tabs_No;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Today();
            case 1:
                return new Week();
            case 2:
                return new Month();
            case 3:
                return new Custom();

        }
        return null;
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
