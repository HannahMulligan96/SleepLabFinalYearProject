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



public class TempFrag extends Fragment {

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tempfrag_layout, container, false);
        //Calling to get data
        getData();
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
            myText5.setText(dataSnapshot.child("Temp/Temp1").getValue().toString());
            TextView myText6 = (TextView) getView().findViewById(R.id.testingTemp7);
            myText6.setText(dataSnapshot.child("Temp/Temp2").getValue().toString());
            TextView myText7 = (TextView) getView().findViewById(R.id.testingTemp8);
            myText7.setText(dataSnapshot.child("Temp/Temp3").getValue().toString());
            TextView myText8 = (TextView) getView().findViewById(R.id.testingTemp9);
            myText8.setText(dataSnapshot.child("Temp/Temp4").getValue().toString());
            TextView myText9 = (TextView) getView().findViewById(R.id.testingTemp10);
            myText9.setText(dataSnapshot.child("Temp/Temp5").getValue().toString());


        }




        @Override
        public void onCancelled(DatabaseError error) {
        }

    };




}







