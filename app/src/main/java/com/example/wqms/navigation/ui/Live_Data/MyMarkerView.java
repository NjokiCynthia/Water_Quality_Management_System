//package com.example.wqms.navigation.ui.Live_Data;
//
//import android.widget.TextView;
//import android.content.Context;
//
//import com.example.wqms.R;
//import com.github.mikephil.charting.charts.LineChart;
//import com.github.mikephil.charting.components.MarkerView;
//import com.github.mikephil.charting.data.CandleEntry;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.highlight.Highlight;
////import com.github.mikephil.charting.utils.MPPointF;
//import com.github.mikephil.charting.utils.Utils;
//
//
//public class MyMarkerView extends MarkerView {
//
//    private TextView tvContent;
//
//    public MyMarkerView(Context context, int layoutResource) {
//        super(context, layoutResource);
//
//        tvContent = (TextView) findViewById(R.id.tvContent);
//    }
//
//    // callbacks everytime the MarkerView is redrawn, can be used to update the
//    // content (user-interface)
//    @Override
//    public void refreshContent(Entry e, Highlight highlight) {
//
//        if (e instanceof CandleEntry) {
//
//            CandleEntry ce = (CandleEntry) e;
//
//            tvContent.setText("" + Utils.formatNumber(ce.getHigh(), 0, true));
//        } else {
//
//            tvContent.setText("" + Utils.formatNumber(e.getY(), 0, true));
//        }
//    }
//
//    @Override
//    public int getXOffset(float xpos) {
//        return 0;
//    }
//
//    @Override
//    public int getYOffset(float ypos) {
//        return 0;
//    }
//
//    public void setChartView(LineChart chartView) {
//        this.chartView = chartView;
//    }
//
//    public LineChart getChartView() {
//        return chartView;
//    }
//
////    @Override
////    public MPPointF getOffset() {
////        return new MPPointF(-(getWidth() / 2), -getHeight());
////    }
//}