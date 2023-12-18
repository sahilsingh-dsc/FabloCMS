package com.myfablo.cms.module_menu_sync.models.upload_swiggy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dish {

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("isVeg")
    @Expose
    private Boolean isVeg;

    /**
     * No args constructor for use in serialization
     */
    public Dish() {
    }

    /**
     * @param image
     * @param isVeg
     * @param price
     * @param name
     * @param description
     * @param type
     */
    public Dish(String type, String name, Integer price, String description, String image, Boolean isVeg) {
        super();
        this.type = type;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.isVeg = isVeg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

}