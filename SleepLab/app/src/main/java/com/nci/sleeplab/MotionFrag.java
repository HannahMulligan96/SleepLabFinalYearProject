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

import java.util.ArrayList;
import java.util.Calendar;

import static android.support.constraint.Constraints.TAG;



public class MotionFrag extends Fragment {


    private String climateMotion;

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.moionfrag_layout, container, false);
        //Calling to get data
        getDataMotion();
        getDataMotion2();
        return view;
    }

    private void getDataMotion() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefMotion = database.getReference("MotionValues");
        myRefMotion.addValueEventListener(valueEventListener);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTextMotion = (TextView) getView().findViewById(R.id.testingMotion);
            myTextMotion.setText(dataSnapshot.child("Motion/Motion1").getValue().toString());
            TextView myTextMotion1 = (TextView) getView().findViewById(R.id.testingMotion2);
            myTextMotion1.setText(dataSnapshot.child("Motion/Motion2").getValue().toString());
            TextView myTextMotion2 = (TextView) getView().findViewById(R.id.testingMotion3);
            myTextMotion2.setText(dataSnapshot.child("Motion/Motion3").getValue().toString());
            TextView myTextMotion3 = (TextView) getView().findViewById(R.id.testingMotion4);
            myTextMotion3.setText(dataSnapshot.child("Motion/Motion4").getValue().toString());
            TextView myTextMotion4 = (TextView) getView().findViewById(R.id.testingMotion5);
            myTextMotion4.setText(dataSnapshot.child("Motion/Motion5").getValue().toString());
            TextView myTextMotion5 = (TextView) getView().findViewById(R.id.testingMotion6);
            myTextMotion5.setText(dataSnapshot.child("Motion/Motion6").getValue().toString());
            TextView myTextMotion6 = (TextView) getView().findViewById(R.id.testingMotion7);
            myTextMotion6.setText(dataSnapshot.child("Motion/Motion7").getValue().toString());
            TextView myTextMotion7 = (TextView) getView().findViewById(R.id.testingMotion8);
            myTextMotion7.setText(dataSnapshot.child("Motion/Motion8").getValue().toString());
            TextView myTextMotion8 = (TextView) getView().findViewById(R.id.testingMotion9);
            myTextMotion8.setText(dataSnapshot.child("Motion/Motion9").getValue().toString());
            TextView myTextMotion9 = (TextView) getView().findViewById(R.id.testingMotion10);
            myTextMotion9.setText(dataSnapshot.child("Motion/Motion10").getValue().toString());


            //Calculating the average temp of the night
            String one = myTextMotion.getText().toString();
            String two = myTextMotion1.getText().toString();
            String three = myTextMotion2.getText().toString();
            String four = myTextMotion3.getText().toString();
            String five = myTextMotion4.getText().toString();
            String six = myTextMotion5.getText().toString();
            String seven = myTextMotion6.getText().toString();
            String eight = myTextMotion7.getText().toString();
            String nine = myTextMotion8.getText().toString();
            String ten = myTextMotion9.getText().toString();


            int Motion1 = Integer.parseInt(one);
            int Motion2 = Integer.parseInt(two);
            int Motion3 = Integer.parseInt(three);
            int Motion4 = Integer.parseInt(four);
            int Motion5 = Integer.parseInt(five);
            int Motion6 = Integer.parseInt(six);
            int Motion7 = Integer.parseInt(seven);
            int Motion8 = Integer.parseInt(eight);
            int Motion9 = Integer.parseInt(nine);
            int Motion10 = Integer.parseInt(ten);
            int calculate = Motion1 + Motion2 + Motion3 + Motion4 + Motion5 + Motion6 + Motion7 + Motion8 +Motion9 + Motion10;

            int result = calculate / 10;


            TextView testingResult = (TextView) getView().findViewById(R.id.motionResult);

            testingResult.setText(" " + result);

            int max = 20;
            int min = 14;


            if (result > 19) {
                climateMotion = "might be too high and affecting your sleep cycle";
            } else if (result < 15) {
                climateMotion = "might be too cold and affecting your sleep cycle";
            } else if (result < max) {
                climateMotion = "is the recommended Motion level";
            } else if (result > min) {
                climateMotion = "is the recommended Motion level for sleeping";
            }

            TextView climateResult = (TextView) getView().findViewById(R.id.climateMotionResult);

            climateResult.setText((climateMotion));
        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };

    private void getDataMotion2() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefMotion2 = database.getReference("UserData");
        myRefMotion2.addValueEventListener(valueEventListener2);

    }


    ValueEventListener valueEventListener2 = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            TextView myTextsMotion = (TextView) getView().findViewById(R.id.motionBed);
            myTextsMotion.setText(dataSnapshot.child("Data/BedTime").getValue().toString());
            TextView myTexts1Motion = (TextView) getView().findViewById(R.id.motionSleep);
            myTexts1Motion.setText(dataSnapshot.child("Data/SleepTime").getValue().toString());



        }


        @Override
        public void onCancelled(DatabaseError error) {
        }

    };
}





