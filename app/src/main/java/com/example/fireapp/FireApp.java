package com.example.fireapp;


import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireApp extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseReference mFirebaseRef = FirebaseDatabase.getInstance().getReference();

    }
}
