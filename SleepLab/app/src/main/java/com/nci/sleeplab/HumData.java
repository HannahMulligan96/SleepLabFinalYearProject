package com.nci.sleeplab;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class HumData extends AppCompatActivity {

    BarChart barChart;
    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private TextView myDateView;
    private TextView myMonthView;
    private static final String TAG = "Hum";



    //Home icon actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    //Home icon on select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefSound = database.getReference("HumValues");

        myRefSound.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barHum1= dataSnapshot.child("Hum/Hum1").getValue(Integer.class);
                final Integer barHum2= dataSnapshot.child("Hum/Hum2").getValue(Integer.class);
                final Integer barHum3= dataSnapshot.child("Hum/Hum3").getValue(Integer.class);
                final Integer barHum4= dataSnapshot.child("Hum/Hum4").getValue(Integer.class);
                final Integer barHum5= dataSnapshot.child("Hum/Hum5").getValue(Integer.class);
                final Integer barHum6= dataSnapshot.child("Hum/Hum6").getValue(Integer.class);
                final Integer barHum7= dataSnapshot.child("Hum/Hum7").getValue(Integer.class);
                final Integer barHum8= dataSnapshot.child("Hum/Hum8").getValue(Integer.class);
                final Integer barHum9= dataSnapshot.child("Hum/Hum9").getValue(Integer.class);
                final Integer barHum10= dataSnapshot.child("Hum/Hum10").getValue(Integer.class);




                ArrayList<BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(barHum1, 0));
                barEntries.add(new BarEntry(barHum2, 1));
                barEntries.add(new BarEntry(barHum3, 2));
                barEntries.add(new BarEntry(barHum4, 3));
                barEntries.add(new BarEntry(barHum5, 4));
                barEntries.add(new BarEntry(barHum6, 5));
                barEntries.add(new BarEntry(barHum7, 6));
                barEntries.add(new BarEntry(barHum8, 7));
                barEntries.add(new BarEntry(barHum9, 8));
                barEntries.add(new BarEntry(barHum10, 9));

                BarDataSet barDataSet = new BarDataSet(barEntries, "Humidity Values");


                setContentView(R.layout.activity_hum_data);

                barChart = findViewById(R.id.bargraph);

                barChart.setTouchEnabled(false);
                barChart.setNoDataText("Loading graph data");


                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theHum= new ArrayList<>();
                theHum.add("11");
                theHum.add("12");
                theHum.add("1");
                theHum.add("2");
                theHum.add("3");
                theHum.add("4");
                theHum.add("5");
                theHum.add("6");
                theHum.add("7");
                theHum.add("8");

                //specifications for graphs
                BarData theData = new BarData(theHum, barDataSet);
                barChart.setData(theData);



                //
        myDateView = findViewById(R.id.dateView);
        myMonthView = findViewById(R.id.monthView);


        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        if (mMonth == 0) {
            curMonth = "Jan";
        } else if (mMonth == 1) {
            curMonth = "February";
        } else if (mMonth == 2) {
            curMonth = "March";
        } else if (mMonth == 3) {
            curMonth = "April";
        } else if (mMonth == 4) {
            curMonth = "May";
        } else if (mMonth == 5) {
            curMonth = "June";
        } else if (mMonth == 6) {
            curMonth = "July";
        } else if (mMonth == 7) {
            curMonth = "August";
        } else if (mMonth == 8) {
            curMonth = "September";
        } else if (mMonth == 9) {
            curMonth = "October";
        } else if (mMonth == 10) {
            curMonth = "November";
        } else if (mMonth == 11) {
            curMonth = "December";
        }

        //Setting day and month
        myDateView.setText(Integer.toString(mDay));
        myMonthView.setText((curMonth));


            }



            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}