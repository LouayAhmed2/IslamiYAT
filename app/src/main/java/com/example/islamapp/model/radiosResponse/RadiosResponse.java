package com.example.islamapp.model.radiosResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RadiosResponse {

    @SerializedName("radios")
    private List<RadiosItem> radios;

    public List<RadiosItem> getRadios() {
        return radios;
    }

    public void setRadios(List<RadiosItem> radios) {
        this.radios = radios;
    }

    @Override
    public String toString() {
        return
                "RadiosResponse{" +
                        "radios = '" + radios + '\'' +
                        "}";
    }
}