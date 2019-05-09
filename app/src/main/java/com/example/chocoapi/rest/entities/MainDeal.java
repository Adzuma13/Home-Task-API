package com.example.chocoapi.rest.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainDeal {
    @Expose
    @SerializedName("result")
    List<Deal> resultList;

    public MainDeal(List<Deal> resultList) {
        this.resultList = resultList;
    }

    public List<Deal> getResultList() {
        return resultList;
    }
}
