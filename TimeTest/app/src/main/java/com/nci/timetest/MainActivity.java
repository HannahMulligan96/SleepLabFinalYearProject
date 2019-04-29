package com.nci.timetest;

import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView mTimeTextView;
    Button mtime;

   Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTimeTextView =(TextView) findViewById(R.id.timeText);

        Calendar calendar =Calendar.getInstance();
        final int hour =calendar.get(Calendar.HOUR_OF_DAY);
        final int minute =calendar.get(Calendar.MINUTE);

        mtime = (Button) findViewById(R.id.button);
        mtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mTimeTextView.setText(hourOfDay + ":" + minute);
                    }
                },hour, minute,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();

            }
        });
    }
}
