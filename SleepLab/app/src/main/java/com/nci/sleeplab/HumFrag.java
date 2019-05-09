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

public class HumFrag extends Fragment {
    private String climateHum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.humtfrag_layout, container, false);
        //Calling to get data
        getDataHum();
        getDataHum2();
        return view;
    }



    private void getDataHum() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefHum = database.getReference("HumValues");
        myRefHum.addValueEventListener(valueEventListener);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTextHum = getView().findViewById(R.id.testingHum);
            myTextHum.setText(dataSnapshot.child("Hum/Hum1").getValue().toString());
            TextView myTextHum1 = getView().findViewById(R.id.testingHum2);
            myTextHum1.setText(dataSnapshot.child("Hum/Hum2").getValue().toString());
            TextView myTextHum2 = getView().findViewById(R.id.testingHum3);
            myTextHum2.setText(dataSnapshot.child("Hum/Hum3").getValue().toString());
            TextView myTextHum3 = getView().findViewById(R.id.testingHum4);
            myTextHum3.setText(dataSnapshot.child("Hum/Hum4").getValue().toString());
            TextView myTextHum4 = getView().findViewById(R.id.testingHum5);
            myTextHum4.setText(dataSnapshot.child("Hum/Hum5").getValue().toString());
            TextView myTextHum5 = getView().findViewById(R.id.testingHum6);
            myTextHum5.setText(dataSnapshot.child("Hum/Hum6").getValue().toString());
            TextView myTextHum6 = getView().findViewById(R.id.testingHum7);
            myTextHum6.setText(dataSnapshot.child("Hum/Hum7").getValue().toString());
            TextView myTextHum7 = getView().findViewById(R.id.testingHum8);
            myTextHum7.setText(dataSnapshot.child("Hum/Hum8").getValue().toString());
            TextView myTextHum8 = getView().findViewById(R.id.testingHum9);
            myTextHum8.setText(dataSnapshot.child("Hum/Hum9").getValue().toString());
            TextView myTextHum9 = getView().findViewById(R.id.testingHum10);
            myTextHum9.setText(dataSnapshot.child("Hum/Hum10").getValue().toString());

            //Calculating the average hum of the night
            String oneHum = myTextHum.getText().toString();
            String twoHum = myTextHum1.getText().toString();
            String threeHum = myTextHum2.getText().toString();
            String fourHum = myTextHum3.getText().toString();
            String fiveHum = myTextHum4.getText().toString();
            String sixHum = myTextHum5.getText().toString();
            String sevenHum = myTextHum6.getText().toString();
            String eightHum = myTextHum7.getText().toString();
            String nineHum = myTextHum8.getText().toString();
            String tenHum = myTextHum9.getText().toString();


            int num1Hum = Integer.parseInt(oneHum);
            int num2Hum = Integer.parseInt(twoHum);
            int num3Hum = Integer.parseInt(threeHum);
            int num4Hum = Integer.parseInt(fourHum);
            int num5Hum = Integer.parseInt(fiveHum);
            int num6Hum = Integer.parseInt(sixHum);
            int num7Hum = Integer.parseInt(sevenHum);
            int num8Hum = Integer.parseInt(eightHum);
            int num9Hum = Integer.parseInt(nineHum);
            int num10Hum = Integer.parseInt(tenHum);
            int calculate = num1Hum + num2Hum + num3Hum + num4Hum + num5Hum + num6Hum + num7Hum + num8Hum + num9Hum + num10Hum;

            int result = calculate / 10;

            TextView testingResultHum = getView().findViewById(R.id.humAvg);

            testingResultHum.setText(" " + result);


            int max = 30;
            int min = 50;


            if (result > 30) {
                climateHum = "might be too humid and affecting your sleep cycle";
            } else if (result < 30) {
                climateHum = "might not be humid enough and affecting your sleep cycle";
            } else if (result < max) {
                climateHum = "is the recommended humidity for sleeping";
            } else if (result > min) {
                climateHum = "is the recommended humidity for sleeping";
            }

            TextView climateResult = getView().findViewById(R.id.climateResult3);

            climateResult.setText((climateHum));





        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };

    private void getDataHum2() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("UserData");
        myRef1.addValueEventListener(valueEventListener2);

    }


    ValueEventListener valueEventListener2 = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTextsHum = getView().findViewById(R.id.humBed);
            myTextsHum.setText(dataSnapshot.child("Data/BedTime").getValue().toString());
            TextView myTextsHum1 = getView().findViewById(R.id.humSleep);
            myTextsHum1.setText(dataSnapshot.child("Data/SleepTime").getValue().toString());
        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };
}