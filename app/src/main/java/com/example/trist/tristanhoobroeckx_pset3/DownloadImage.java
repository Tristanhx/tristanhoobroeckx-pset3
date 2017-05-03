package com.example.trist.tristanhoobroeckx_pset3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Tristan on 04/05/2017.
 */

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView bitImg;

    public DownloadImage(ImageView bmImage) {
        this.bitImg = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap poster = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            poster = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return poster;
    }

    protected void onPostExecute(Bitmap result) {
        bitImg .setImageBitmap(result);
    }
}