package com.example.trist.tristanhoobroeckx_pset3;

import java.io.Serializable;

/**
 * Created by trist on 5/2/2017.
 */

class MovieObject implements Serializable {
    String title;
    Integer year;
    String director;
    String actors;
    String plot;
    String poster;

    public String getTitle(){
        return title;
    }
    public Integer getYear(){
        return year;
    }
    public String getDir() {
        return director;
    }
    public String getActors() {
        return actors;
    }
    public String getPlot() {
        return plot;
    }
    public String getPoster() {
        return poster;
    }
}
