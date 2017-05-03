package com.example.trist.tristanhoobroeckx_pset3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    ArrayList<MovieObject> movieArray;
    TextView titletext;
    TextView yeartext;
    TextView dirtext;
    TextView actortext;
    TextView plottext;
    ImageView posterview;
    String title;
    String year;
    String actors;
    String plot;
    String dir;
    String poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        titletext = (TextView) findViewById(R.id.titletext);
        yeartext = (TextView) findViewById(R.id.yeartext);
        dirtext = (TextView) findViewById(R.id.dirtext);
        actortext = (TextView) findViewById(R.id.actortext);
        plottext = (TextView) findViewById(R.id.plottext);
        posterview = (ImageView) findViewById(R.id.poster);

        Bundle extras = getIntent().getExtras();
        movieArray = (ArrayList<MovieObject>) extras.getSerializable("data");

        for (MovieObject movieObject : movieArray){
            title = movieObject.getTitle();
            year = movieObject.getYear().toString();
            dir = movieObject.getDir();
            actors = movieObject.getActors();
            plot = movieObject.getPlot();
            poster = movieObject.getPoster();
        }

        titletext.setText(title);
        yeartext.setText(year);
        dirtext.setText(dir);
        actortext.setText(actors);
        plottext.setText(plot);
        new DownloadImage(posterview).execute(poster);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
