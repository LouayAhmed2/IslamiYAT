package com.example.islamapp.apis;

import com.example.islamapp.model.radiosResponse.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface WebServices {

    @GET("radios/radio_arabic.json")
    Call<RadiosResponse> getRadioChannels();
}
