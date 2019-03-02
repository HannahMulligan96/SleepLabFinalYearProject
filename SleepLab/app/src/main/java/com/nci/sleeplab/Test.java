package com.nci.sleeplab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


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
    private Button myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Sending how many hours you slept to firebase
        myButton = (Button) findViewById(R.id.saveButton);
        myButton.setOnClickListener(new View.OnClickListener() {

            final EditText myText = findViewById(R.id.sleepHours);

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefBed = database.getReference("SleepHours");
                myRefBed.setValue(myText.getText().toString().trim());
            }
        });


        myDateView = (TextView) findViewById(R.id.dateView);
        myMonthView = (TextView) findViewById(R.id.monthView);
        mysleepTime = (TextView) findViewById(R.id.sleepTime);
        mysleepBed = (TextView) findViewById(R.id.sleepBed);
        mysleepHours = (TextView) findViewById(R.id.sleepHours);


        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        if (mMonth == 1) {
            curMonth = "Jan";
        } else if (mMonth == 2) {
            curMonth = "February";
        } else if (mMonth == 3) {
            curMonth = "March";
        } else if (mMonth == 4) {
            curMonth = "April";
        } else if (mMonth == 5) {
            curMonth = "May";
        } else if (mMonth == 6) {
            curMonth = "June";
        } else if (mMonth == 7) {
            curMonth = "July";
        } else if (mMonth == 8) {
            curMonth = "August";
        } else if (mMonth == 9) {
            curMonth = "September";
        } else if (mMonth == 10) {
            curMonth = "October";
        } else if (mMonth == 11) {
            curMonth = "November";
        } else if (mMonth == 12) {
            curMonth = "December";
        }


        myDateView.setText(Integer.toString(mDay));
        myMonthView.setText((curMonth));
    }
}
