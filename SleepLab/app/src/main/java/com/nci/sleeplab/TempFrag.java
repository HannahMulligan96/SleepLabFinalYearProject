package com.nci.sleeplab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TempFrag extends Fragment {


    private String climate;

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tempfrag_layout, container, false);
        //Calling to get data
        getData();
        getData2();
        return view;
    }

    private void getData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("TempValues");
        myRef.addValueEventListener(valueEventListener);

    }


    ValueEventListener valueEventListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myText = (TextView) getView().findViewById(R.id.testingTemp);
            myText.setText(dataSnapshot.child("Temp/Temp1").getValue().toString());
            TextView myText1 = (TextView) getView().findViewById(R.id.testingTemp2);
            myText1.setText(dataSnapshot.child("Temp/Temp2").getValue().toString());
            TextView myText2 = (TextView) getView().findViewById(R.id.testingTemp3);
            myText2.setText(dataSnapshot.child("Temp/Temp3").getValue().toString());
            TextView myText3 = (TextView) getView().findViewById(R.id.testingTemp4);
            myText3.setText(dataSnapshot.child("Temp/Temp4").getValue().toString());
            TextView myText4 = (TextView) getView().findViewById(R.id.testingTemp5);
            myText4.setText(dataSnapshot.child("Temp/Temp5").getValue().toString());
            TextView myText5 = (TextView) getView().findViewById(R.id.testingTemp6);
            myText5.setText(dataSnapshot.child("Temp/Temp6").getValue().toString());
            TextView myText6 = (TextView) getView().findViewById(R.id.testingTemp7);
            myText6.setText(dataSnapshot.child("Temp/Temp7").getValue().toString());
            TextView myText7 = (TextView) getView().findViewById(R.id.testingTemp8);
            myText7.setText(dataSnapshot.child("Temp/Temp8").getValue().toString());
            TextView myText8 = (TextView) getView().findViewById(R.id.testingTemp9);
            myText8.setText(dataSnapshot.child("Temp/Temp9").getValue().toString());
            TextView myText9 = (TextView) getView().findViewById(R.id.testingTemp10);
            myText9.setText(dataSnapshot.child("Temp/Temp10").getValue().toString());

//Calculating the average temp of the night
            String one = myText.getText().toString();
            String two = myText1.getText().toString();
            String three = myText2.getText().toString();
            String four = myText3.getText().toString();
            String five = myText4.getText().toString();
            String six = myText5.getText().toString();
            String seven = myText6.getText().toString();
            String eight = myText7.getText().toString();
            String nine = myText8.getText().toString();
            String ten = myText9.getText().toString();


            int num1 = Integer.parseInt(one);
            int num2 = Integer.parseInt(two);
            int num3 = Integer.parseInt(three);
            int num4 = Integer.parseInt(four);
            int num5 = Integer.parseInt(five);
            int num6 = Integer.parseInt(six);
            int num7 = Integer.parseInt(seven);
            int num8 = Integer.parseInt(eight);
            int num9 = Integer.parseInt(nine);
            int num10 = Integer.parseInt(ten);
            int calculate = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10;

            int result = calculate / 10;

            TextView testingResult = (TextView) getView().findViewById(R.id.testingResult);

            testingResult.setText(" " + result);

            int max = 20;
            int min = 14;


            if (result > 19) {
                climate = "might be too hot and affecting your sleep cycle";
            } else if (result < 15) {
                climate = "might be too cold and affecting your sleep cycle";
            } else if (result < max) {
                climate = "is the recommended temperature";
            } else if (result > min) {
                climate = "is the recommended temperature for sleeping";
            }

            TextView climateResult = (TextView) getView().findViewById(R.id.climateResult);

            climateResult.setText((climate));




        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };

    private void getData2() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("UserData");
        myRef1.addValueEventListener(valueEventListener2);

    }


    ValueEventListener valueEventListener2 = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTexts = (TextView) getView().findViewById(R.id.tempBed);
            myTexts.setText(dataSnapshot.child("Data/BedTime").getValue().toString());
            TextView myTexts1 = (TextView) getView().findViewById(R.id.tempSleep);
            myTexts1.setText(dataSnapshot.child("Data/SleepTime").getValue().toString());

//
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
//
//            String bed = myTexts.getText().toString();
//            int tempBed ;
//            String sleep = myTexts1.getText().toString();
//            int tempSleep;
//
//            long difference = tempBed.getTime() - tempSleep.getTime();
//            days = (int) (difference / (1000*60*60*24));
//            hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
//            min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
//            hours = (hours < 0 ? -hours : hours);
//            Log.i("======= Hours"," :: "+hours);
//


//            java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm");
//            String bed = myTexts.getText().toString();
//           // java.util.Date tempBed = df.parse();
//            int tempBed = Integer.parseInt(bed);
//            String sleep = myTexts1.getText().toString();
//            int tempSleep= Integer.parseInt(sleep);
//            long diff = tempBed.getTime() - tempSleep.getTime();
//

//            java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");
//            java.util.Date date1 = df.parse("18:40:10");
//            java.util.Date date2 = df.parse("19:05:15");
//            long diff = date2.getTime() - date1.getTime();
        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };
}








