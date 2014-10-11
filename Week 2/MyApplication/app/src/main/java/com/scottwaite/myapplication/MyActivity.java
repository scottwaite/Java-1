package com.scottwaite.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MyActivity extends ListActivity {



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
            }
        };

        btn.setOnClickListener(listener);

        setListAdapter(adapter);
    }
}