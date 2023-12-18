package com.myfablo.cms.module_menu_sync.models.upload_swiggy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuUploadResponse {

    @SerializedName("menu")
    @Expose
    private List<Menu> menu;

    /**
     * No args constructor for use in serialization
     */
    public MenuUploadResponse() {
    }

    /**
     * @param menu
     */
    public MenuUploadResponse(List<Menu> menu) {
        super();
        this.menu = menu;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

}