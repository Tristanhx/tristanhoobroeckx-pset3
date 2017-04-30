package com.example.trist.tristanhoobroeckx_pset3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTitle;
    EditText editTextYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextYear = (EditText) findViewById(R.id.editTextYear);
//        assert editTextTitle != null;
    }

    /*
    Get input from user and start AsyncTask
    then clear EditText
     */
    public void watchSearch(View view){
        String title = editTextTitle.getText().toString();
        String year = editTextYear.getText().toString();
        SearchAsyncTask asyncTask = new SearchAsyncTask(this);

        if(title != null && year != null){
            asyncTask.execute(title, year);
        }
        else{
            Toast.makeText(this, "Fill in both fields!", Toast.LENGTH_SHORT).show();
        }
        editTextTitle.getText().clear();
        editTextYear.getText().clear();
    }

    /*
    Once we get the Array witch all the data, we need to start the Activity that displays
    the data.
     */
    public void watchStartIntent(ArrayList<String> searchData){
        Intent dataIntent = new Intent(this, DataActivity.class);
        dataIntent.putExtra("data", searchData);
        this.startActivity(dataIntent);
    }
}
