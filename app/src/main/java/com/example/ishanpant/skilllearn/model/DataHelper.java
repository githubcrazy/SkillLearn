package com.example.ishanpant.skilllearn.model;

import com.google.gson.annotations.SerializedName;

public class DataHelper {

    @SerializedName("cityname")
    private String cityname;

    @SerializedName("Position")
    private Position position;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
