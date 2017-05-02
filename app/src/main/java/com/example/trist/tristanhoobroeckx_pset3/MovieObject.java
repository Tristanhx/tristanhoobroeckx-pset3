package com.example.trist.tristanhoobroeckx_pset3;

import java.io.Serializable;

/**
 * Created by trist on 5/2/2017.
 */

class MovieObject implements Serializable {
    String title;
    Integer year;
    String imdbID;

    public String getTitle(){
        return title;
    }
    public Integer getYear(){
        return year;
    }
    public String getImdbID() {
        return imdbID;
    }
}
