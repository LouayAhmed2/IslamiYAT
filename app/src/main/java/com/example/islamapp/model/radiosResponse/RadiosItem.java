package com.example.islamapp.model.radiosResponse;

import com.google.gson.annotations.SerializedName;

public class RadiosItem {

    @SerializedName("name")
    private String name;

    @SerializedName("radio_url")
    private String radioUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRadioUrl() {
        return radioUrl;
    }

    public void setRadioUrl(String radioUrl) {
        this.radioUrl = radioUrl;
    }

    @Override
    public String toString() {
        return
                "RadiosItem{" +
                        "name = '" + name + '\'' +
                        ",radio_url = '" + radioUrl + '\'' +
                        "}";
    }
}