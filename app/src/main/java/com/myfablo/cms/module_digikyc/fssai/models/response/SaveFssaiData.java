package com.myfablo.cms.module_digikyc.fssai.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveFssaiData {

    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("entity")
    @Expose
    private String entity;
    @SerializedName("reg")
    @Expose
    private String reg;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("zip")
    @Expose
    private Integer zip;

    /**
     * No args constructor for use in serialization
     */
    public SaveFssaiData() {
    }

    /**
     * @param valid
     * @param zip
     * @param address
     * @param reg
     * @param active
     * @param state
     * @param message
     * @param category
     * @param uuid
     * @param entity
     * @param status
     */
    public SaveFssaiData(Boolean valid, Object message, String status, Boolean active, String entity, String reg, String uuid, String category, String state, String address, Integer zip) {
        super();
        this.valid = valid;
        this.message = message;
        this.status = status;
        this.active = active;
        this.entity = entity;
        this.reg = reg;
        this.uuid = uuid;
        this.category = category;
        this.state = state;
        this.address = address;
        this.zip = zip;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}