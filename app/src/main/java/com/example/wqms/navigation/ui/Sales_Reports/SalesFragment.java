package com.example.wqms.navigation.ui.Sales_Reports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.wqms.R;
import com.example.wqms.databinding.FragmentSalesBinding;
import com.example.wqms.navigation.PagerAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SalesFragment extends Fragment {


    ViewPager2 viewpager;
    TabItem today, week, month, custom;
    TabLayout tab_layout;
    PagerAdapter adapter;

    private BarChart chart;

    private FragmentSalesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales, container, false);

        chart = view.findViewById(R.id.fragment_sales_chart);
        viewpager = view.findViewById(R.id.viewpager);
        today = view.findViewById(R.id.today);
        week = view.findViewById(R.id.week);
        month = view.findViewById(R.id.month);
        custom = view.findViewById(R.id.custom);
        tab_layout = view.findViewById(R.id.tab_layout);

        tab_layout.addTab(tab_layout.newTab().setText("Tab 1 Item"));
        tab_layout.addTab(tab_layout.newTab().setText("Tab 2 Item"));
        tab_layout.addTab(tab_layout.newTab().setText("Tab 3 Item"));
        tab_layout.addTab(tab_layout.newTab().setText("Tab 4 Item"));

        assert getFragmentManager() != null;
         adapter = new PagerAdapter(getFragmentManager(),
                        tab_layout.getTabCount());
        viewpager.setAdapter(viewpager.getAdapter());

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return viewpager;
    }
}