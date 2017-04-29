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

    public void watchSearch(View view){
        String search = editText.getText().toString();
        SearchAsyncTask asyncTask = new SearchAsyncTask(this);
        asyncTask.execute(search);

        editText.getText().clear();
//        watchStartIntent();
    }

    public void watchStartIntent(ArrayList<String> searchData){
        Intent dataIntent = new Intent(this, DataActivity.class);
        dataIntent.putExtra("data", searchData);
        this.startActivity(dataIntent);
    }
}
