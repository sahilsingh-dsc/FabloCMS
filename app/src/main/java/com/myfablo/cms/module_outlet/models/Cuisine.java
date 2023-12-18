package com.myfablo.cms.module_outlet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuisine {

    @SerializedName("cuisineId")
    @Expose
    private String cuisineId;
    @SerializedName("cuisineName")
    @Expose
    private String cuisineName;
    @SerializedName("_id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     */
    public Cuisine() {
    }

    /**
     * @param cuisineId
     * @param id
     * @param cuisineName
     */
    public Cuisine(String cuisineId, String cuisineName, String id) {
        super();
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
        this.id = id;
    }

    public String getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}