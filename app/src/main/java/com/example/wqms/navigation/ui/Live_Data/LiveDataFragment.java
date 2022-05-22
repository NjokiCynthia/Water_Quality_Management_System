package com.example.wqms.navigation.ui.Live_Data;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wqms.R;
import com.example.wqms.databinding.FragmentLiveDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LiveDataFragment extends Fragment {

    TextView result;
    LineChart line_chart;
    ArrayList<Entry> yDATA,ydata;

    private static final String LOG_TAG;


    static {
        LOG_TAG = LiveDataFragment.class.getSimpleName();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live_data, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference humido =  database.getReference().child("wqms");////RETURNS INTEGER VALUE ,IT WORKS IN RESPONSE

        //DatabaseReference tempgraph = database.getReference("wqms");


        DatabaseReference humid = database.getReference("counter");///ALLOWS PLOTTING OF THE AGE GRAPH
        //DatabaseReference mygrapgh = database.getReference("wqms/payload");
        line_chart = rootView.findViewById(R.id.line_chart);

        //line_chart = rootView.findViewById(R.id.nav_live_data);

        //graph_init();//for initialize graph
        humid.addValueEventListener(new ValueEventListener() { //plots a graph of all ages collected
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yDATA = new ArrayList<>();
                float i = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    i = i + 1;
                    String SV = Objects.requireNonNull(ds.child("counter").getValue()).toString();//member/age
                    float SensorValue = Float.parseFloat(SV);//parser
                    yDATA.add(new Entry(i, (int) SensorValue));
                }
                final LineDataSet lineDataSet1 = new LineDataSet( yDATA, "counter" );
                //LineData data = new LineData((List<String>) lineDataSet1);
                //line_chart.setData(data);
                line_chart.notifyDataSetChanged();
                line_chart.invalidate();

                lineDataSet1.setDrawCircles(false);
                lineDataSet1.setColors(Collections.singletonList(Color.RED));
                //ss
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(LOG_TAG,"Errr!!! ");
            }
        });

        result = rootView.findViewById(R.id.result);

        humido.addValueEventListener(new ValueEventListener() {//plotted well
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Val = dataSnapshot.getValue(String.class);
                result.setText(String.valueOf(Val));
                Log.d(LOG_TAG ,"Value is: "+Val);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(LOG_TAG ,"ERRR!! ");

            }
        });

        return rootView;
    }
}