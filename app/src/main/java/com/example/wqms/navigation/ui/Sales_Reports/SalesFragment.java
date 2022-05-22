package com.example.wqms.navigation.ui.Sales_Reports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import com.example.wqms.R;

import com.example.wqms.TabPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class SalesFragment extends Fragment {


    ViewPager viewpager;
    TabLayout tab_layout;
    TabPagerAdapter tabPagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales, container, false);

        viewpager = view.findViewById(R.id.viewpager);
        tabPagerAdapter = new TabPagerAdapter(getActivity().getSupportFragmentManager());
        viewpager.setAdapter(tabPagerAdapter);
        tab_layout = view.findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(viewpager);

        return view;
    }

}