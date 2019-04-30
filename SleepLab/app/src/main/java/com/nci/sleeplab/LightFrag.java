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

public class LightFrag extends Fragment {

    private String climateLight;

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.lightfrag_layout, container, false);
        //Calling to get data
        getDataLight();
        getDataLight2();
        return view;
    }

    private void getDataLight() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefLight = database.getReference("LightValues");
        myRefLight.addValueEventListener(valueEventListener);

    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTextLight = (TextView) getView().findViewById(R.id.testingLight);
            myTextLight.setText(dataSnapshot.child("Light/Light1").getValue().toString());
            TextView myTextLight1 = (TextView) getView().findViewById(R.id.testingLight2);
            myTextLight1.setText(dataSnapshot.child("Light/Light2").getValue().toString());
            TextView myTextLight2 = (TextView) getView().findViewById(R.id.testingLight3);
            myTextLight2.setText(dataSnapshot.child("Light/Light3").getValue().toString());
            TextView myTextLight3 = (TextView) getView().findViewById(R.id.testingLight4);
            myTextLight3.setText(dataSnapshot.child("Light/Light4").getValue().toString());
            TextView myTextLight4 = (TextView) getView().findViewById(R.id.testingLight5);
            myTextLight4.setText(dataSnapshot.child("Light/Light5").getValue().toString());
            TextView myTextLight5 = (TextView) getView().findViewById(R.id.testingLight6);
            myTextLight5.setText(dataSnapshot.child("Light/Light6").getValue().toString());
            TextView myTextLight6 = (TextView) getView().findViewById(R.id.testingLight7);
            myTextLight6.setText(dataSnapshot.child("Light/Light7").getValue().toString());
            TextView myTextLight7 = (TextView) getView().findViewById(R.id.testingLight8);
            myTextLight7.setText(dataSnapshot.child("Light/Light8").getValue().toString());
            TextView myTextLight8 = (TextView) getView().findViewById(R.id.testingLight9);
            myTextLight8.setText(dataSnapshot.child("Light/Light9").getValue().toString());
            TextView myTextLight9 = (TextView) getView().findViewById(R.id.testingLight10);
            myTextLight9.setText(dataSnapshot.child("Light/Light10").getValue().toString());

//Calculating the average temp of the night
            String one = myTextLight.getText().toString();
            String two = myTextLight1.getText().toString();
            String three = myTextLight2.getText().toString();
            String four = myTextLight3.getText().toString();
            String five = myTextLight4.getText().toString();
            String six = myTextLight5.getText().toString();
            String seven = myTextLight6.getText().toString();
            String eight = myTextLight7.getText().toString();
            String nine = myTextLight8.getText().toString();
            String ten = myTextLight9.getText().toString();


            int light1 = Integer.parseInt(one);
            int light2 = Integer.parseInt(two);
            int light3 = Integer.parseInt(three);
            int light4 = Integer.parseInt(four);
            int light5 = Integer.parseInt(five);
            int light6 = Integer.parseInt(six);
            int light7 = Integer.parseInt(seven);
            int light8 = Integer.parseInt(eight);
            int light9 = Integer.parseInt(nine);
            int light10 = Integer.parseInt(ten);
            int calculate = light1 + light2 + light3 + light4 + light5 + light6 + light7 + light8 +light9 + light10;

            int result = calculate / 10;

            TextView testingResult = (TextView) getView().findViewById(R.id.lightResult);

            testingResult.setText(" " + result);

            int max = 20;
            int min = 14;


            if (result > 19) {
                climateLight = "might be too high and affecting your sleep cycle";
            } else if (result < max) {
                climateLight = "is the recommended light level for sleeping";
            }


            TextView climateResult = (TextView) getView().findViewById(R.id.climateLightResult);

            climateResult.setText((climateLight));

        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };

    private void getDataLight2() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefLight2 = database.getReference("UserData");
        myRefLight2.addValueEventListener(valueEventListener2);

    }


    ValueEventListener valueEventListener2 = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTextsLight = (TextView) getView().findViewById(R.id.lightBed);
            myTextsLight.setText(dataSnapshot.child("Data/BedTime").getValue().toString());
            TextView myTexts1Light = (TextView) getView().findViewById(R.id.lightSleep);
            myTexts1Light.setText(dataSnapshot.child("Data/SleepTime").getValue().toString());



        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };
}





