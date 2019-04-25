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



    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.moionfrag_layout, container, false);
        //Calling to get data
        getData();
        return view;
    }





    private void getData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("MotionValues");
        myRef.addValueEventListener(valueEventListener);

    }

    //public void onDataChange(DataSnapshot dataSnapshot) {
    //final Integer barHum1= dataSnapshot.child("Hum/Hum1").getValue(Integer.class);


    ValueEventListener valueEventListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView myText = (TextView) getView().findViewById(R.id.test);
                myText.setText(dataSnapshot.child("Motion/Motion1").getValue().toString());
                TextView myText1 = (TextView) getView().findViewById(R.id.test2);
                myText1.setText(dataSnapshot.child("Motion/Motion2").getValue().toString());



            }




        @Override
        public void onCancelled(DatabaseError error) {
        }

    };


}







