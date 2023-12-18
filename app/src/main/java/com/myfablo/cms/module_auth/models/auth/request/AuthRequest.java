package com.myfablo.cms.module_auth.models.auth.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequest {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * No args constructor for use in serialization
     */
    public AuthRequest() {
    }

    /**
     * @param password
     * @param type
     * @param email
     */
    public AuthRequest(String type, String email, String password) {
        super();
        this.type = type;
        this.email = email;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}