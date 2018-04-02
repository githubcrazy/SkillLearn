package com.example.ishanpant.skilllearn.model;

import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("Longitude")
    private float Longitde;

    @SerializedName("Latitude")
    private float Latitude;

    public float getLongitde() {
        return Longitde;
    }

    public void setLongitde(float longitde) {
        Longitde = longitde;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }
}
