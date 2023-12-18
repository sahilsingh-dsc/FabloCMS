package com.myfablo.cms.module_menu_sync.models.category.add;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCategoryRequest {

    @SerializedName("outletId")
    @Expose
    private String outletId;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    @SerializedName("categoryDesc")
    @Expose
    private String categoryDesc;

    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;

    public AddCategoryRequest() {
    }

    public AddCategoryRequest(String outletId, String categoryName, String categoryDesc, String categoryImage) {
        this.outletId = outletId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.categoryImage = categoryImage;
    }

    // Getters and Setters
    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
