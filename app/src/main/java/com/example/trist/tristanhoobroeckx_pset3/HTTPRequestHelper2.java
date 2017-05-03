package com.example.trist.tristanhoobroeckx_pset3;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tristan on 29/04/2017.
 */

public class HTTPRequestHelper2 {

    protected static synchronized String downloadFromServer(String... params) {
        String result = "";
        String Tag = params[0];

        /*
        Hier maken we de URL aan.
         */
        URL url;
        try {
            String requestAddress = "http://www.omdbapi.com/?t=" + Tag + "&plot=full";
            url = new URL(requestAddress);
            Log.d("tag", requestAddress);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpURLConnection connect;

        try {
            connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");

            Integer responseCode = connect.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                BufferedReader bufReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String line;
                while ((line = bufReader.readLine()) != null) {
                    result += line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Log.d("result", result);
        return result;
    }
}
