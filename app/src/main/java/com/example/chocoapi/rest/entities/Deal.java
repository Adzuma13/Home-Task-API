package com.example.chocoapi.rest.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deal {
    @Expose
    @SerializedName("discount")
    int discount;

    @Expose
    @SerializedName("price")
    int price;

    @Expose
    @SerializedName("title_short")
    String title_short;

    @Expose
    @SerializedName("title")
    String title;

    @Expose
    @SerializedName("reviews_rate")
    double reviews_rate;

    @Expose
    @SerializedName("bought")
    int bought;

    @Expose
    @SerializedName("image_url")
    String image_url;

    public Deal(String image_url,int discount, int price, String title_short, String title, double reviews_rate, int bought) {
        this.discount = discount;
        this.price = price;
        this.title_short = title_short;
        this.title = title;
        this.reviews_rate = reviews_rate;
        this.bought = bought;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle_short() {
        return title_short;
    }

    public String getTitle() {
        return title;
    }

    public double getReviews_rate() {
        return reviews_rate;
    }

    public int getBought() {
        return bought;
    }
}
