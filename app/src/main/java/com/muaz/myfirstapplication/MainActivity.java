package com.muaz.myfirstapplication;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.button);
        final EditText first_input =(EditText) findViewById(R.id.first_input);
        final EditText second_input = (EditText) findViewById(R.id.second_input);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info", "button is pressed!");
                if(first_input != null && second_input != null){
                    Log.i("first_num", first_input.getText().toString());
                    Log.i("second_num", second_input.getText().toString());
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, second_input.getText().toString(), Toast.LENGTH_LONG).show();

                        }
                    }, 2000);
                    Toast.makeText(MainActivity.this, first_input.getText().toString(), Toast.LENGTH_SHORT).show();
            } else {
                    Toast.makeText(MainActivity.this, "No available data", Toast.LENGTH_SHORT).show();
                }
        }

    });
        Toast.makeText(getApplicationContext(), first_input.toString(), Toast.LENGTH_SHORT).show();
    }
}
