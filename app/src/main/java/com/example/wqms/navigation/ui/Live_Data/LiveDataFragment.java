package com.example.wqms.navigation.ui.Live_Data;

import android.accounts.AuthenticatorDescription;
import android.graphics.Color;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.EventLogTags.Description;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.wqms.R;
import com.example.wqms.databinding.FragmentLiveDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class LiveDataFragment extends Fragment {

    private FragmentLiveDataBinding binding;
    LineChart line_chart;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live_data, container, false);
        line_chart = (LineChart) rootView.findViewById(R.id.nav_live_data);
        graph_init();//for initialize graph
        return rootView;
    }

    private ILineDataSet graph_init() {
        line_chart.setOnChartValueSelectedListener((OnChartValueSelectedListener) this);                // enable description text
        // line_chart.setDescription().setEnabled(true);

        // enable touch gestures
        line_chart.setTouchEnabled(true);

        // enable scaling and dragging
        line_chart.setDragEnabled(true);
        line_chart.setScaleEnabled(true);
        line_chart.setDrawGridBackground(false);

        // if disabled, scaling can be done on x- and y-axis separately
        line_chart.setPinchZoom(true);

        // set an alternative background color
        line_chart.setBackgroundColor(getResources().getColor(R.color.memory_graph_background));

        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);

        // add empty data
        line_chart.setData(data);

        // no description text
        line_chart.setDescription("");
        line_chart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable value highlighting
        //line_chart.setHighlightEnabled(true);

        line_chart.setPinchZoom(false);

        // create a custom MarkerView (extend MarkerView and specify the layout to use for it)
        MyMarkerViewv2 mv = new MyMarkerViewv2(getActivity(), R.layout.fragment_live_data, line_chart);

        // set the marker to the chart
        line_chart.setMarkerView(mv);

        // disable all axes lines and labels
        YAxis leftAxis = line_chart.getAxisLeft();
        leftAxis.setEnabled(false);

        line_chart.getAxisRight().setEnabled(false);

        XAxis bottomAxis = line_chart.getXAxis();
        bottomAxis.setEnabled(false);

        // add data
        setLineChartData((List<Integer>) data);

        //THIS METHOD CANNOT BE RESOLVED********************
        line_chart.setExtraOffsets(30f, 50f, 30f, 0f);

        // get the legend (only possible after setting data)
        Legend l = line_chart.getLegend();
        l.setEnabled(false);

        line_chart.invalidate();

        return (ILineDataSet) data;

    }

    public void setLineChartData(List<Integer> nums) {

        //create xVariables aka strings of the months
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < nums.size(); i++) {
            //xVals.add(Month.getMonthfromIndex(i).getAbbrev());
        }

        //add corresponding numbers
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < nums.size(); i++) {
            yVals.add(new Entry(nums.get(i), i));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals, "DataSet");

        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(0.75f);
        set1.setDrawCircles(true);
        set1.setDrawValues(false);
        set1.setCircleSize(1.75f);
        set1.setDrawCircleHole(false);

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, (ILineDataSet) dataSets);

        // set data
        line_chart.setData(data);
    }

// stuff here

    class MyMarkerViewv2 extends MarkerView {

        private TextView markerContent;
        private LineChart line_chart;

        public MyMarkerViewv2(FragmentActivity context, int layoutResource, LineChart lChart) {
            super(context, layoutResource);

            line_chart = lChart;
            markerContent = (TextView) findViewById(R.id.markerContent);
        }

        // callbacks everytime the MarkerView is redrawn, can be used to update the
        // content (user-interface)

        @Override
        public void refreshContent(Entry e, Highlight highlight) {
            if (e instanceof CandleEntry) {
                CandleEntry ce = (CandleEntry) e;

                List<String> months = line_chart.getLineData().getXVals();
                markerContent.setText(months.get(e.getXIndex() % 12) + "\n"
                        + Utils.formatNumber(ce.getHigh(), 0, true) + "%");
            } else {
                List<String> months = line_chart.getLineData().getXVals();
                markerContent.setText(months.get(e.getXIndex() % 12) + "\n"
                        + Utils.formatNumber(e.getVal(), 0, true) + "%");
            }
        }

        @Override
        public int getXOffset(float xpos) {
            return -(getWidth() / 2);
            //return 0;
        }

        @Override
        public int getYOffset(float ypos) {
            return -getHeight();
           // return 0;
        }
    }
}