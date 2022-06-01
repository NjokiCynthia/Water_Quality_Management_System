package com.example.wqms.navigation.ui.Live_Data;


import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
//import androidx.room.compiler.processing.util.Line;

import com.example.wqms.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LiveDataFragment extends Fragment {

    //TextView result;
    LineChart line_chart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live_data, container, false);

        line_chart = rootView.findViewById(R.id.line_chart);
        line_chart.setTouchEnabled(true);

//        MyMarkerView mv = new MyMarkerView(getApplicationContext(), R.layout.activity_my_marker_view);
//        mv.setChartView(line_chart);
//        line_chart.setMarker(mv);

        // enable touch gestures
//        line_chart.setPinchZoom(true);
//        renderData();
        return rootView;
    }
}

//    public void renderData() {
//        LimitLine llXAxis = new LimitLine(10f, "Index 10");
//        llXAxis.setLineWidth(4f);
//        llXAxis.enableDashedLine(10f, 10f, 0f);
//        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        llXAxis.setTextSize(10f);
//
//        XAxis xAxis = line_chart.getXAxis();
//        xAxis.enableGridDashedLine(10f, 10f, 0f);
//        xAxis.setAxisMaxValue(10f);
//        xAxis.setAxisMinValue(0f);
//        xAxis.setDrawLimitLinesBehindData(true);
//
//        LimitLine ll1 = new LimitLine(215f, "Maximum Limit");
//        ll1.setLineWidth(4f);
//        ll1.enableDashedLine(10f, 10f, 0f);
//        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        ll1.setTextSize(10f);
//
//        LimitLine ll2 = new LimitLine(70f, "Minimum Limit");
//        ll2.setLineWidth(4f);
//        ll2.enableDashedLine(10f, 10f, 0f);
//        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        ll2.setTextSize(10f);
//
//        YAxis leftAxis = line_chart.getAxisLeft();
//        leftAxis.removeAllLimitLines();
//        leftAxis.addLimitLine(ll1);
//        leftAxis.addLimitLine(ll2);
//        leftAxis.setAxisMaxValue(350f);
//        leftAxis.setAxisMinValue(0f);
//        leftAxis.enableGridDashedLine(10f, 10f, 0f);
//        leftAxis.setDrawZeroLine(false);
//        leftAxis.setDrawLimitLinesBehindData(false);
//
//        line_chart.getAxisRight().setEnabled(false);
//        setData();
//    }
//
//    private void setData() {
//
//        ArrayList<Entry> values = new ArrayList<>();
//        values.add(new Entry(1, 50));
//        values.add(new Entry(2, 100));
//        values.add(new Entry(3, 80));
//        values.add(new Entry(4, 120));
//        values.add(new Entry(5, 110));
//        values.add(new Entry(7, 150));
//        values.add(new Entry(8, 250));
//        values.add(new Entry(9, 190));
//
//        LineDataSet set1;
//        if (line_chart.getData() != null &&
//                line_chart.getData().getDataSetCount() > 0) {
//            set1 = (LineDataSet) line_chart.getData().getDataSetByIndex(0);
//            set1.setValues(values);
//            line_chart.getData().notifyDataChanged();
//            line_chart.notifyDataSetChanged();
//        } else {
//            set1 = new LineDataSet(values, "Sample Data");
//            set1.setDrawIcons(false);
//            set1.enableDashedLine(10f, 5f, 0f);
//            set1.enableDashedHighlightLine(10f, 5f, 0f);
//            set1.setColor(Color.DKGRAY);
//            set1.setCircleColor(Color.DKGRAY);
//            set1.setLineWidth(1f);
//            set1.setCircleRadius(3f);
//            set1.setDrawCircleHole(false);
//            set1.setValueTextSize(9f);
//            set1.setDrawFilled(true);
//            set1.setFormLineWidth(1f);
//            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
//            set1.setFormSize(15.f);
//
//            if (Utils.getSDKInt() >= 18) {
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_blue);
//                set1.setFillDrawable(drawable);
//            } else {
//                set1.setFillColor(Color.DKGRAY);
//            }
//            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//            dataSets.add(set1);
//           // LineData data = new LineData(dataSets);
//            line_chart.setData(data);
//        }
//    }
//}
