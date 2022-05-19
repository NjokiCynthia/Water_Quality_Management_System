package com.example.wqms.navigation.ui.Live_Data;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wqms.R;
import com.example.wqms.databinding.FragmentLiveDataBinding;
import com.github.mikephil.charting.charts.LineChart;

public class LiveDataFragment extends Fragment {

    private FragmentLiveDataBinding binding;
    LineChart line_chart;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live_data, container, false);

        line_chart = rootView.findViewById(R.id.nav_live_data);
        //graph_init();//for initialize graph
        return rootView;
    }
}