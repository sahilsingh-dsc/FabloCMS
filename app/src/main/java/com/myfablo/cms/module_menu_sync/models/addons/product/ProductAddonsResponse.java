package com.myfablo.cms.module_menu_sync.models.addons.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductAddonsResponse {

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
    private List<AddonItems> addonItemsList;

    /**
     * No args constructor for use in serialization
     */
    public ProductAddonsResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param error
     * @param items
     * @param status
     */
    public ProductAddonsResponse(Boolean status, Integer subCode, String message, String error, List<AddonItems> addonItemsList) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.error = error;
        this.addonItemsList = addonItemsList;
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

    public List<AddonItems> getGetAddonItems() {
        return addonItemsList;
    }

    public void setGetAddonItems(List<AddonItems> addonItemsList) {
        this.addonItemsList = addonItemsList;
    }

}