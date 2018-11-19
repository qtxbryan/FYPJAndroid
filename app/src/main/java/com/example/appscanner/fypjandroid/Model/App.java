package com.example.appscanner.fypjandroid.Model;


public class App {

    public String app_id;
    public String title;
    public String url;
    public String developerID;
    public String date_scraped;

    public App(String app_id, String title, String url, String developerID, String date_scraped) {
        this.app_id = app_id;
        this.title = title;
        this.url = url;
        this.developerID = developerID;
        this.date_scraped = date_scraped;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(String developerID) {
        this.developerID = developerID;
    }

    public String getDate_scraped() {
        return date_scraped;
    }

    public void setDate_scraped(String date_scraped) {
        this.date_scraped = date_scraped;
    }
}

