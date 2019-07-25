package com.singh.ranjeet.myapplication;

public class show {
    private String title;
    private long date;
    private String bywho;
    private String url
            ;

    public show(String title, long date, String bywho, String url) {
        this.title = title;
        this.date = date;
        this.bywho = bywho;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getBywho() {
        return bywho;
    }

    public void setBywho(String bywho) {
        this.bywho = bywho;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
