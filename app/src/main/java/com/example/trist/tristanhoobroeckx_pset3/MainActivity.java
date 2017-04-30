package com.example.trist.tristanhoobroeckx_pset3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        assert editText != null;
    }

    /*
    Get input from user and start AsyncTask
    then clear EditText
     */
    public void watchSearch(View view){
        String search = editText.getText().toString();
        SearchAsyncTask asyncTask = new SearchAsyncTask(this);
        asyncTask.execute(search);

        editText.getText().clear();
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
