package com.example.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Users> mUserName;
    private ListView mListView;
    private CustomAdapter mCustomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView)findViewById(R.id.listViewItem);
        mListView.setAdapter(mCustomAdapter);
    }
}
