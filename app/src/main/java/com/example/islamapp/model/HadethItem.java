package com.example.islamapp.model;

/**
 * Created by Mohamed Nabil Mohamed on 9/20/2019.
 * m.nabil.fci2015@gmail.com
 */
public class HadethItem {
    String title;
    String content;

    public HadethItem(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
