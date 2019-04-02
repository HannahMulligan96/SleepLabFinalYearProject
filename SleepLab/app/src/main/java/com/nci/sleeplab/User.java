package com.nci.sleeplab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class User extends AppCompatActivity {

    private TextView textViewUserEmail;

    //firebase authentication
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


//        if (firebaseAuth.getCurrentUser() == null) {
//            finish();
//            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//        }
//
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
//        textViewUserEmail.setText("welcome  " + user.getEmail());



    }
}