package com.myfablo.cms.module_auth.models.auth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthItems {

    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     */
    public AuthItems() {
    }

    /**
     * @param token
     */
    public AuthItems(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}