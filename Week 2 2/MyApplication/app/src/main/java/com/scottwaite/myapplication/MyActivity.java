package com.scottwaite.myapplication;


/*
Created By: Scott Waite
Course: Java 1
Instructor: Gyasi Story
Assignment: Mastering the Fundamentals 2
Date: October 10, 2014
*/

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyActivity extends ListActivity {

    //Debugging tag
    final String TAG = "Android Fundamentals";
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_my);

        Button btn = (Button) findViewById(R.id.submitButton);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                list.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
                //Make a toast
                Toast.makeText(getApplicationContext(), list + "has been added to the list", Toast.LENGTH_LONG).show();
            }
        };




        btn.setOnClickListener(listener);

        setListAdapter(adapter);
    }
}