package com.example.trist.tristanhoobroeckx_pset3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tristan on 29/04/2017.
 */

public class DataActivity extends AppCompatActivity {
    TextView movieResult;
    ListView listItems;
    ArrayList<String> movieArray;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        movieResult = (TextView) findViewById(R.id.movieresult);
        listItems = (ListView) findViewById(R.id.list);

        Bundle extras = getIntent().getExtras();
        movieArray = (ArrayList<String>) extras.getSerializable("data");

        makeListAdapter();
    }

    public void makeListAdapter(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, movieArray);
        listItems = (ListView) findViewById(R.id.list);
        assert listItems != null;
        listItems.setAdapter(arrayAdapter);

    }
}
