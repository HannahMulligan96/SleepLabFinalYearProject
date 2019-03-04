package com.nci.sleeplab;

import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Test extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


    private TextView myDateView;
    private TextView myMonthView;
    private TextView mysleepTime;
    private TextView myBedTime;
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


        //Time picker widget on click listener for button
        Button button = (Button) findViewById(R.id.selectBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });

        //Time picker widget on click listener for button
        Button button1 = (Button) findViewById(R.id.selectBtn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });


        //Sending how many hours you slept to firebase
        myButton = (Button) findViewById(R.id.saveButton);
        myButton.setOnClickListener(new View.OnClickListener() {

            final EditText myText = findViewById(R.id.sleepHours);

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefSleep = database.getReference("SleepHours");
                myRefSleep.setValue(myText.getText().toString().trim());
            }
        });

        //Sending what time you went to bed to firebase
        myButton = (Button) findViewById(R.id.saveButton);
        myButton.setOnClickListener(new View.OnClickListener() {

            final TextView myText = findViewById(R.id.bedTime);

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefBed = database.getReference("BedTime");
                myRefBed.setValue(myText.getText().toString().trim());
            }
        });


        myDateView = (TextView) findViewById(R.id.dateView);
        myMonthView = (TextView) findViewById(R.id.monthView);
        mysleepTime = (TextView) findViewById(R.id.sleepTime);
        myBedTime = (TextView) findViewById(R.id.bedTime);
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


    //Setting the time selected by the user to the views
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = (TextView) findViewById(R.id.bedTime);
        textView.setText("" + hourOfDay + ":" + minute);

     
    }
}
