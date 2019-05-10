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

public class SoundFrag extends Fragment {
    private String climateSound;

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.soundfrag_layout, container, false);
        //Calling to get data
        getDataSound();
      getDataSound2();
        return view;
    }

    private void getDataSound() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefSound = database.getReference("SoundValues");
        myRefSound.addValueEventListener(valueEventListener);

    }

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override public void onDataChange(DataSnapshot dataSnapshot) {
                TextView myTextSound = getView().findViewById(R.id.testingSound);
                myTextSound.setText(dataSnapshot.child("Sound/Sound1").getValue().toString());
                TextView myTextSound1 = getView().findViewById(R.id.testingSound2);
                myTextSound1.setText(dataSnapshot.child("Sound/Sound2").getValue().toString());
                TextView myTextSound2 = getView().findViewById(R.id.testingSound3);
                myTextSound2.setText(dataSnapshot.child("Sound/Sound3").getValue().toString());
                TextView myTextSound3 = getView().findViewById(R.id.testingSound4);
                myTextSound3.setText(dataSnapshot.child("Sound/Sound4").getValue().toString());
                TextView myTextSound4 = getView().findViewById(R.id.testingSound5);
                myTextSound4.setText(dataSnapshot.child("Sound/Sound5").getValue().toString());
                TextView myTextSound5 = getView().findViewById(R.id.testingSound6);
                myTextSound5.setText(dataSnapshot.child("Sound/Sound6").getValue().toString());
                TextView myTextSound6 = getView().findViewById(R.id.testingSound7);
                myTextSound6.setText(dataSnapshot.child("Sound/Sound7").getValue().toString());
                TextView myTextSound7 = getView().findViewById(R.id.testingSound8);
                myTextSound7.setText(dataSnapshot.child("Sound/Sound8").getValue().toString());
                TextView myTextSound8 = getView().findViewById(R.id.testingSound9);
                myTextSound8.setText(dataSnapshot.child("Sound/Sound9").getValue().toString());
                TextView myTextSound9 = getView().findViewById(R.id.testingSound10);
                myTextSound9.setText(dataSnapshot.child("Sound/Sound10").getValue().toString());


                //Calculating the average temp of the night
                String one = myTextSound.getText().toString();
                String two = myTextSound1.getText().toString();
                String three = myTextSound2.getText().toString();
                String four = myTextSound3.getText().toString();
                String five = myTextSound4.getText().toString();
                String six = myTextSound5.getText().toString();
                String seven = myTextSound6.getText().toString();
                String eight = myTextSound7.getText().toString();
                String nine = myTextSound8.getText().toString();
                String ten = myTextSound9.getText().toString();


                int Sound1 = Integer.parseInt(one);
                int Sound2 = Integer.parseInt(two);
                int Sound3 = Integer.parseInt(three);
                int Sound4 = Integer.parseInt(four);
                int Sound5 = Integer.parseInt(five);
                int Sound6 = Integer.parseInt(six);
                int Sound7 = Integer.parseInt(seven);
                int Sound8 = Integer.parseInt(eight);
                int Sound9 = Integer.parseInt(nine);
                int Sound10 = Integer.parseInt(ten);
                int calculate = Sound1 + Sound2 + Sound3 + Sound4 + Sound5 + Sound6 + Sound7 + Sound8 +Sound9 + Sound10;

                int result = calculate / 10;


                TextView testingResultSound = getView().findViewById(R.id.soundResult);

                testingResultSound.setText(" " + result +"ADC");

                int max = 20;
                int min = 14;


                if (result > 19) {
                    climateSound = "might be too high and affecting your sleep cycle";
                } else if (result < 15) {
                    climateSound = "might be too cold and affecting your sleep cycle";
                } else if (result < max) {
                    climateSound = "is the recommended sound level";
                } else if (result > min) {
                    climateSound = "is the recommended sound level for sleeping";
                }

                TextView climateResult = getView().findViewById(R.id.climateSoundResult);

                climateResult.setText((climateSound));


                // Write a message to the database


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("SoundAvg").push();
                myRef.setValue(testingResultSound.getText().toString().trim());

            }


            @Override
            public void onCancelled(DatabaseError error) {
            }

        };

        private void getDataSound2() {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRefSound2 = database.getReference("UserData");
            myRefSound2.addValueEventListener(valueEventListener2);

        }


        ValueEventListener valueEventListener2 = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView myTextsSound = getView().findViewById(R.id.soundBed);
                myTextsSound.setText(dataSnapshot.child("Data/BedTime").getValue().toString());
                TextView myTexts1Sound = getView().findViewById(R.id.soundSleep);
                myTexts1Sound.setText(dataSnapshot.child("Data/SleepTime").getValue().toString());



            }


            @Override
            public void onCancelled(DatabaseError error) {
            }

        };
    }





