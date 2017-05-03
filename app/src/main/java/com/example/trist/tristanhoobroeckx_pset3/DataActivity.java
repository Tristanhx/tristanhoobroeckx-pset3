package com.example.trist.tristanhoobroeckx_pset3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    TextView movieResult;
    ListView listItems;
    ArrayList<MovieObject> movieArray;
    ArrayList<String> titleArray;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Log.d("datahere", "Ik ben er!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        movieResult = (TextView) findViewById(R.id.movieresult);
        listItems = (ListView) findViewById(R.id.list);
        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedFromList = (String) listItems.getItemAtPosition(position);
                        Log.d("selected", selectedFromList);
                        SearchAsyncTask asyncTask2 = new SearchAsyncTask(DataActivity.this);
                        asyncTask2.execute(selectedFromList);

                        Intent intent = new Intent(DataActivity.this, MovieActivity.class);
                        intent.putExtra("selectedmovie", selectedFromList);
                        startActivity(intent);
            }});

        Bundle extras = getIntent().getExtras();
        movieArray = (ArrayList<MovieObject>) extras.getSerializable("data");
        titleArray = new ArrayList<>();
        for (MovieObject movieObject : movieArray){
            Log.d("title0", movieObject.getTitle());
            titleArray.add(movieObject.getTitle());
        }



        makeListAdapter();
    }

    public void makeListAdapter(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_2, android.R.id.text1, titleArray);
        assert listItems != null;
        listItems.setAdapter(arrayAdapter);

    }
}
