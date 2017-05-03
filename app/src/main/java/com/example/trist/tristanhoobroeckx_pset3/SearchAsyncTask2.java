package com.example.trist.tristanhoobroeckx_pset3;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Tristan on 29/04/2017.
 */

public class SearchAsyncTask2 extends AsyncTask<String, Integer, String> {
    Context context;
    DataActivity dataActivity;

    public SearchAsyncTask2(DataActivity data){
        this.dataActivity = data;
        this.context = this.dataActivity.getApplicationContext();
    }

    @Override
    protected String doInBackground(String... params){
        return HTTPRequestHelper2.downloadFromServer(params);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);


        /*
        Make JSONArray and JSONObjects for every part you need. Then put JSONArray in ArrayList
        */
        ArrayList<MovieObject> searchData = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);

                MovieObject movieObject = new MovieObject();

                movieObject.title = jsonObject.getString("Title");
                movieObject.year = jsonObject.getInt("Year");
                movieObject.director = jsonObject.getString("Director");
                movieObject.actors = jsonObject.getString("Actors");
                movieObject.plot = jsonObject.getString("Plot");
                movieObject.poster = jsonObject.getString("Poster");


                searchData.add(movieObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.dataActivity.watchStartIntent(searchData);
    }
}
