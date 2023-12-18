package com.myfablo.cms.module_menu_sync.models.menu_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuItemsResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("subCode")
    @Expose
    private Integer subCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("items")
    @Expose
    private List<MenuItem> menuItems;

    /**
     * No args constructor for use in serialization
     */
    public MenuItemsResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param error
     * @param menuItems
     * @param status
     */
    public MenuItemsResponse(Boolean status, Integer subCode, String message, String error, List<MenuItem> menuItems) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.error = error;
        this.menuItems = menuItems;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSubCode() {
        return subCode;
    }

    public void setSubCode(Integer subCode) {
        this.subCode = subCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<MenuItem> getItems() {
        return menuItems;
    }

    public void setItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}