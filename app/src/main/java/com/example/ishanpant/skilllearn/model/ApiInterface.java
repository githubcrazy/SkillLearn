package com.example.ishanpant.skilllearn.model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/v2/5ab3b7412f00006600ca391c")
    Call<ArrayList<DataHelper>> getCityData();
}
