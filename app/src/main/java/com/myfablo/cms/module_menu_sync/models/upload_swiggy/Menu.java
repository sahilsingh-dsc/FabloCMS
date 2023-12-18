package com.myfablo.cms.module_menu_sync.models.upload_swiggy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Menu {

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("items")
    @Expose
    private List<Item> items;

    /**
     * No args constructor for use in serialization
     */
    public Menu() {
    }

    /**
     * @param type
     * @param title
     * @param items
     */
    public Menu(String type, String title, List<Item> items) {
        super();
        this.type = type;
        this.title = title;
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}