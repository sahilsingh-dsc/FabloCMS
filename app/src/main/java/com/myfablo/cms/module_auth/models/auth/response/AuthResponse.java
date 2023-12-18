package com.myfablo.cms.module_auth.models.auth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("subCode")
    @Expose
    private Integer subCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("items")
    @Expose
    private AuthItems authItems;

    /**
     * No args constructor for use in serialization
     */
    public AuthResponse() {
    }

    /**
     * @param subCode
     * @param message
     * @param authItems
     * @param status
     */
    public AuthResponse(Boolean status, Integer subCode, String message, AuthItems authItems) {
        super();
        this.status = status;
        this.subCode = subCode;
        this.message = message;
        this.authItems = authItems;
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

    public AuthItems getAuthItems() {
        return authItems;
    }

    public void setAuthItems(AuthItems authItems) {
        this.authItems = authItems;
    }

}