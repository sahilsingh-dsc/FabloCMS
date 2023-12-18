package com.myfablo.cms.module_menu_sync.models.product.add;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddProductRequest {

    @SerializedName("parentCategoryId")
    @Expose
    private String parentCategoryId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productDesc")
    @Expose
    private String productDesc;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productPrice")
    @Expose
    private Double productPrice;
    @SerializedName("isVeg")
    @Expose
    private Boolean isVeg;

    /**
     * No args constructor for use in serialization
     */
    public AddProductRequest() {
    }

    /**
     * @param productDesc
     * @param productImage
     * @param isVeg
     * @param parentCategoryId
     * @param productName
     * @param productPrice
     */
    public AddProductRequest(String parentCategoryId, String productName, String productDesc, String productImage, Double productPrice, Boolean isVeg) {
        super();
        this.parentCategoryId = parentCategoryId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.isVeg = isVeg;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Boolean getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

}