package com.example.fireapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mRootRef, mUsersRef;
    private EditText mValue;
    private Button mAdd;
    private ArrayList<String> mArrayListUser;
    private ListView mListView;


    // Static Variables
    public static final String FIREBASE_NAME = "Name";
    public static final String FIREBASE_ADDRESS = "Address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Firebase properties
        mRootRef = FirebaseDatabase.getInstance().getReference();
        //Adding a child "Name" to the Users
        mUsersRef = mRootRef.child("Users");

        mArrayListUser = new ArrayList<>();

        mListView = (ListView)findViewById(R.id.listFirebase);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                mArrayListUser);
        mListView.setAdapter(arrayAdapter);

        mAdd = (Button)findViewById(R.id.buttonAdd);
        mValue = (EditText)findViewById(R.id.etValue);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Setting a value to the Child "Name"
                mUsersRef.child(FIREBASE_NAME).setValue(mValue.getText().toString());
                mValue.setText("");
                // mChildName.setText(mUsersRef.child(FIREBASE_NAME).);

            }
        });

        mUsersRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                mArrayListUser.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mUsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Getting the value from the firebase  and display it to the textview
                // TODO
                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                String name = map.get(FIREBASE_NAME);
                String age = map.get(FIREBASE_ADDRESS);

                Log.v("E_VALUE", "Name: " + name);
                Log.v("E_VALUE", "Age: " + age);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
