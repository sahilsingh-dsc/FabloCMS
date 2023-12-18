package com.myfablo.cms.module_menu_sync.models.upload_swiggy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Float price;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("isVeg")
    @Expose
    private Boolean isVeg;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dishes")
    @Expose
    private List<Dish> dishes;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param image
     * @param isVeg
     * @param price
     * @param name
     * @param description
     * @param dishes
     * @param type
     * @param title
     */
    public Item(String type, String name, Float price, String description, String image, Boolean isVeg, String title, List<Dish> dishes) {
        super();
        this.type = type;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.isVeg = isVeg;
        this.title = title;
        this.dishes = dishes;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}