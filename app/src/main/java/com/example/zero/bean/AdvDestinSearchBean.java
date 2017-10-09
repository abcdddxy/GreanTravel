package com.example.zero.bean;


import java.util.ArrayList;

/**
 * Created by kazu_0122 on 2017/9/22.
 */

public class AdvDestinSearchBean {
    private String title;
    private String time;
    private int comments;
    private int img;
    private int price;
    private float rate;
    private ArrayList<String> labels;

    public void setText(String title, int comments, int
            price, String time, int imgId, float rate, ArrayList<String> labels) {
        this.title = title;
        this.time = time;
        this.comments = comments;
        this.img = imgId;
        this.price = price;
        this.rate = rate;
        this.labels = labels;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public int getComments() {
        return comments;
    }

    public int getImg() {
        return img;
    }

    public int getPrice() {
        return price;
    }

    public float getRate() {
        return rate;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

}
