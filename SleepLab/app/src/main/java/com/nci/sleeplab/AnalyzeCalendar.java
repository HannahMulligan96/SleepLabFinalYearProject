package com.nci.sleeplab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class AnalyzeCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_calendar);


        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.DAY_OF_WEEK, 1); //Calendar set to 1 week in advance

        CalendarPickerView datePicker = findViewById(R.id.calendar);
        datePicker.init(today, nextYear.getTime()).withSelectedDate(today); //todays date

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH)
                        + " " + (calSelected.get(Calendar.MONTH) + 1)
                        + " " + calSelected.get(Calendar.YEAR);

                Intent myIntent = new Intent(getBaseContext(), analysefull.class);
                startActivity(myIntent); //Open the user log


                Toast.makeText(AnalyzeCalendar.this, selectedDate, Toast.LENGTH_SHORT).show();
            }  //Dsiplay todays date

            @Override
            public void onDateUnselected(Date date) {

            }
        });

    }

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

}
