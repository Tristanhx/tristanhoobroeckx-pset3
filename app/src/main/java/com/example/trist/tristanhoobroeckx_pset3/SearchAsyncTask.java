package com.example.trist.tristanhoobroeckx_pset3;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Tristan on 29/04/2017.
 */

public class SearchAsyncTask extends AsyncTask<String, Integer, String> {
    Context context;
    MainActivity mainActivity;

    public SearchAsyncTask(MainActivity main){
        this.mainActivity = main;
        this.context = this.mainActivity.getApplicationContext();
    }

    @Override
    protected void onPreExecute(){
        Toast.makeText(context, "Searching for movies...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params){
        return HTTPRequestHelper.downloadFromServer(params);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);


        /*
        Make JSONArray and JSONObjects for every part you need. Then put JSONArray in ArrayList
        */
        ArrayList<JSONObject> searchData = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);

            JSONArray searchArray = jsonObject.getJSONArray("Search");
            Log.d("log", "SearchAsync Search");
            for(int i = 0 ; i < searchArray.length(); i++) {
                searchData.add(searchArray.getJSONObject(i));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mainActivity.watchStartIntent(searchData);
    }
}
