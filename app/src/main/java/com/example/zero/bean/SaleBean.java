package com.example.zero.bean;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by jojo on 2017/9/11.
 */

public class SaleBean {
    private String name;
    private String price;
    private String content;
    private int img;

    public void setText(String name, String price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public void setImage(int imgId) {
        this.img = imgId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public int getImage() {
        return img;
    }
}
