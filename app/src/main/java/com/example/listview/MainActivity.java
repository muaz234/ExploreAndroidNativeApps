package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView places = (ListView) findViewById(R.id.placesListView);
        ArrayList<String> place = new ArrayList<>();
        place.add("Taman Layang2");
        place.add("Masjid Besi");
        place.add("Pasar Malam");
        place.add("Giant Batu Caves");
        place.add("Kuil Batu Caves");
        ArrayAdapter<String> placeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, place);
        places.setAdapter(placeAdapter);
    }
}
