package com.myfablo.cms.module_digikyc.gst.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GstVerifyResponse {

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
    private GstItems gstItems;

    /**
     * No args constructor for use in serialization
     */
    public GstVerifyResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param error
     * @param gstItems
     * @param status
     */
    public GstVerifyResponse(Boolean status, Integer subCode, String message, String error, GstItems gstItems) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.error = error;
        this.gstItems = gstItems;
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

    public GstItems getItems() {
        return gstItems;
    }

    public void setItems(GstItems gstItems) {
        this.gstItems = gstItems;
    }

}