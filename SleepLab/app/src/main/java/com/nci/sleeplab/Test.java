package com.nci.sleeplab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
public class Test extends AppCompatActivity {


    private TextView myDateView;
    private TextView myMonthView;
    private TextView mysleepTime;
    private TextView mysleepBed;
    private TextView mysleepHours;
    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        myDateView =(TextView)findViewById(R.id.dateView);
        myMonthView =(TextView)findViewById(R.id.monthView);
        mysleepTime =(TextView)findViewById(R.id.sleepTime);
        mysleepBed =(TextView)findViewById(R.id.sleepBed);
        mysleepHours =(TextView)findViewById(R.id.sleepHours);


        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        if (mMonth == 1) {
            curMonth = "Jan";
        }else if (mMonth ==2){
            curMonth = "Feb";
        }
        myDateView.setText(Integer.toString(mDay));
        myMonthView.setText((curMonth));
    }
}
