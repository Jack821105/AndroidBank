package com.example.demo;

import android.net.Uri;

import java.io.Serializable;
import java.lang.reflect.Type;

public class News implements Serializable {

private String CONTENT_DATE;
private String DESCRIPT;
private String END_TIME;
private String START_TIME;
private String URL;

    public News(String CONTENT_DATE, String DESCRIPT, String END_TIME, String START_TIME, String URL) {
        this.CONTENT_DATE = CONTENT_DATE;
        this.DESCRIPT = DESCRIPT;
        this.END_TIME = END_TIME;
        this.START_TIME = START_TIME;
        this.URL = URL;
    }


    public String getCONTENT_DATE() {
        return CONTENT_DATE;
    }

    public void setCONTENT_DATE(String CONTENT_DATE) {
        this.CONTENT_DATE = CONTENT_DATE;
    }

    public String getDESCRIPT() {
        return DESCRIPT;
    }

    public void setDESCRIPT(String DESCRIPT) {
        this.DESCRIPT = DESCRIPT;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
