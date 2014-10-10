package com.scottwaite.myapplication;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText myEditText = (EditText)findViewById(R.id.myEditText);
        ListView myListView = (ListView)findViewById(R.id.myListView);

        final ArrayList todoItems = new ArrayList lt;string>();

        //create an array adapter to bind the array to list view
        final ArrayAdapter lt;string> aa = new ArrayAdapter lt;string>(this,
                android.R.layout.simple_list_item_1, todoItems);

    /*bind the array adapter to the ListView */
        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
                        todoItems.add(0, myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

    }
}