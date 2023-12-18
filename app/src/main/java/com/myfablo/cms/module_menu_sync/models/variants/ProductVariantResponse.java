package com.myfablo.cms.module_menu_sync.models.variants;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductVariantResponse {

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
    private VariantItems variantItems;

    /**
     * No args constructor for use in serialization
     */
    public ProductVariantResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param error
     * @param variantItems
     * @param status
     */
    public ProductVariantResponse(Boolean status, Integer subCode, String message, String error, VariantItems variantItems) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.error = error;
        this.variantItems = variantItems;
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

    public VariantItems getVariantItems() {
        return variantItems;
    }

    public void setVariantItems(VariantItems variantItems) {
        this.variantItems = variantItems;
    }

}