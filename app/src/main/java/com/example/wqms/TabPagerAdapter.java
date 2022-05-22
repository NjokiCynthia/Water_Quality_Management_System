package com.example.wqms;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wqms.navigation.ui.report_tabs.Custom;
import com.example.wqms.navigation.ui.report_tabs.Month;
import com.example.wqms.navigation.ui.report_tabs.Today;
import com.example.wqms.navigation.ui.report_tabs.Week;

public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new Today();
        }
        else if (position == 1)
        {
            fragment = new Week();
        }
        else if (position == 2)
        {
            fragment = new Month();
        }
        else if (position == 3)
        {
            fragment = new Custom();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Today";
        }
        else if (position == 1)
        {
            title = "Week";
        }
        else if (position == 2)
        {
            title = "Month";
        }
        else if (position == 3)
        {
            title = "Custom";
        }
        return title;
    }
}
