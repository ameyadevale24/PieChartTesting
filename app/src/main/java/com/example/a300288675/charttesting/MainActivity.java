package com.example.a300288675.charttesting;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    float[] yData = {21f,23f,42f,11f,9f,76f,32f,4f};
    String[] xData = {"food","clothing","transport","health","coffee","groceries","bills","others"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = (PieChart)findViewById(R.id.pie1);

        pieChart.setHoleRadius(25f);
        pieChart.setCenterText("Expenses");
        pieChart.setTransparentCircleAlpha(0);

        addDataInPie(pieChart);

    }

    private void addDataInPie(PieChart chart) {
        ArrayList<PieEntry> yEntry = new ArrayList<>();
        ArrayList<String> xEntry = new ArrayList<>();

        for(int i=0; i<yData.length; i++){
            yEntry.add(new PieEntry(yData[i],i));
        }

        for(int i=0; i<xData.length; i++){
            xEntry.add(xData[i]);
        }

        // create dataset
        PieDataSet pieDataSet = new PieDataSet(yEntry,"Expenses");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //set colors
        ArrayList<Integer> color = new ArrayList<>();
        color.add(Color.LTGRAY);
        color.add(Color.BLUE);
        color.add(Color.GREEN);
        color.add(Color.YELLOW);
        color.add(Color.RED);
        color.add(Color.CYAN);
        color.add(Color.DKGRAY);
        color.add(Color.MAGENTA);

        pieDataSet.setColors(color);

        //add legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }
}
