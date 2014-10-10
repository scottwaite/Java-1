package com.scottwaite.androidfundamentals1;

/*
Created By: Scott Waite
Course: Java 1
Instructor: Gyasi Story
Assignment: Mastering the Fundamentals 2
Date: October 10, 2014
*/


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class FundamentalsActivity extends Activity {

    //Debugging tag
    final String TAG = "Android Fundamentals";
    private TextView mUserText;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundamentals);

        //Setting references to user and result text fields
        mUserText = (TextView) findViewById(R.id.usertext);
        mResultText = (TextView) findViewById(R.id.resulttext);


        Button button = (Button) findViewById(R.id.userbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button Clicked");
                showResult(mUserText.getText().toString());

                // Show a confirmation Toast

                if ((mUserText.length() == 0)){


                Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_SHORT).show();
                }

                else if ((mUserText.length() != 0)){


                    Toast.makeText(getApplicationContext(), "You added the entry of " + (mUserText.getText().toString()), Toast.LENGTH_LONG).show();
                }


            }
        });

        ListView userlist = (ListView) findViewById(R.id.userlist);
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "List Item Selected");
                TextView selected = (TextView) view;
                showResult(selected.getText().toString());

            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fundamentals, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Custom Functions
    private void showResult(String result) {
        mResultText.setText(result);
    }
}