package com.muaz.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View myview;
    public void computeCalc() {
        EditText first_input =(EditText) findViewById(R.id.first_input);
        EditText second_input = (EditText) findViewById(R.id.second_input);
        Log.i("Info", "button is pressed!");
        Log.i("first_num", first_input.getText().toString());
        Log.i("second_num", second_input.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computeCalc();
    }
}
