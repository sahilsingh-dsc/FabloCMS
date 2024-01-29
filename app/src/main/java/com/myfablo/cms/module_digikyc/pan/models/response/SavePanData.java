package com.myfablo.cms.module_digikyc.pan.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavePanData {

    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("aadhaarLinked")
    @Expose
    private Boolean aadhaarLinked;

    /**
     * No args constructor for use in serialization
     */
    public SavePanData() {
    }

    /**
     * @param valid
     * @param aadhaarLinked
     * @param name
     * @param category
     */
    public SavePanData(Boolean valid, String category, String name, Boolean aadhaarLinked) {
        super();
        this.valid = valid;
        this.category = category;
        this.name = name;
        this.aadhaarLinked = aadhaarLinked;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAadhaarLinked() {
        return aadhaarLinked;
    }

    public void setAadhaarLinked(Boolean aadhaarLinked) {
        this.aadhaarLinked = aadhaarLinked;
    }

}