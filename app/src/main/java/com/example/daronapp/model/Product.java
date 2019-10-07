package com.example.daronapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("data")
    List<Data> dataList;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
