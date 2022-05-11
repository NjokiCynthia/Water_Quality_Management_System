package com.example.wqms.navigation.ui.Sales_Reports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wqms.R;
import com.example.wqms.databinding.FragmentSalesBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.firestore.util.Util;
//import com.google.firebase.firestore.util.Util;

import java.util.ArrayList;

public class SalesFragment extends Fragment {

    private static final int MAX_X_VALUE = 7;
    private static final int MAX_Y_VALUE = 50;
    private static final int MIN_Y_VALUE = 5;
    private static final String SET_LABEL = "App Downloads";
    private static final String[] DAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    private BarChart chart;

    private FragmentSalesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales, container, false);

        chart = view.findViewById(R.id.fragment_sales_chart);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(945f, 0));
        NoOfEmp.add(new BarEntry(1040f, 1));
        NoOfEmp.add(new BarEntry(1133f, 2));
        NoOfEmp.add(new BarEntry(1240f, 3));
        NoOfEmp.add(new BarEntry(1369f, 4));
        NoOfEmp.add(new BarEntry(1487f, 5));
        NoOfEmp.add(new BarEntry(1501f, 6));
        NoOfEmp.add(new BarEntry(1645f, 7));
        NoOfEmp.add(new BarEntry(1578f, 8));
        NoOfEmp.add(new BarEntry(1695f, 9));

        ArrayList year = new ArrayList();

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(5000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);

        return view;
    }
}


//        BarData data = createChartData();
//        configureChartAppearance();
//        prepareChartData(data);
//        return view;
//    }
//
//    private void configureChartAppearance() {
//        //chart.getDescription().setEnabled(false);
//        chart.setDrawValueAboveBar(false);
//
//        XAxis xAxis = chart.getXAxis();
//        xAxis.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float value) {
//                return DAYS[(int) value];
//            }
//        });
//
//        YAxis axisLeft = chart.getAxisLeft();
//        axisLeft.setGranularity(10f);
//        axisLeft.setAxisMinimum(0);
//
//        YAxis axisRight = chart.getAxisRight();
//        axisRight.setGranularity(10f);
//        axisRight.setAxisMinimum(0);
//    }
//    private BarData createChartData() {
//        ArrayList<BarEntry> values = new ArrayList<>();
//        for (int i = 0; i < MAX_X_VALUE; i++) {
//            float x = i;
//            float y = new Util().randomFloatBetween(MIN_Y_VALUE, MAX_Y_VALUE);
//            values.add(new BarEntry(x, y));
//        }
//
//        BarDataSet set1 = new BarDataSet(values, SET_LABEL);
//
//        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
//        dataSets.add(set1);
//
//        BarData data = new BarData(dataSets);
//
//        return data;
//    }
//
//    private void prepareChartData(BarData data) {
//        data.setValueTextSize(12f);
//        chart.setData(data);
//        chart.invalidate();
//    }
//
////
////    @Override
////    public void onDestroyView() {
////        super.onDestroyView();
////        binding = null;
////    }
//
//
//}