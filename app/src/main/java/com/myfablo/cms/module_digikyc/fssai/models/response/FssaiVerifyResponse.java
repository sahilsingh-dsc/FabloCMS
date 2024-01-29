package com.myfablo.cms.module_digikyc.fssai.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FssaiVerifyResponse {

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
    private FssaiItems fssaiItems;

    /**
     * No args constructor for use in serialization
     */
    public FssaiVerifyResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param error
     * @param fssaiItems
     * @param status
     */
    public FssaiVerifyResponse(Boolean status, Integer subCode, String message, String error, FssaiItems fssaiItems) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.error = error;
        this.fssaiItems = fssaiItems;
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

    public FssaiItems getItems() {
        return fssaiItems;
    }

    public void setItems(FssaiItems fssaiItems) {
        this.fssaiItems = fssaiItems;
    }

}