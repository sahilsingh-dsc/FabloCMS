package com.myfablo.cms.module_digikyc.pan.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PanVerifyResponse {

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
    private PanItems items;

    /**
     * No args constructor for use in serialization
     */
    public PanVerifyResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param error
     * @param items
     * @param status
     */
    public PanVerifyResponse(Boolean status, Integer subCode, String message, String error, PanItems items) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.error = error;
        this.items = items;
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

    public PanItems getItems() {
        return items;
    }

    public void setItems(PanItems items) {
        this.items = items;
    }

}