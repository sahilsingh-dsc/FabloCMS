package com.myfablo.cms.module_menu_sync.models.menu_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubCategory {

    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("hasSubCategory")
    @Expose
    private Boolean hasSubCategory;
    @SerializedName("hasProduct")
    @Expose
    private Boolean hasProduct;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("products")
    @Expose
    private List<Product> products;

    /**
     * No args constructor for use in serialization
     */
    public SubCategory() {
    }

    /**
     * @param hasProduct
     * @param categoryImage
     * @param hasSubCategory
     * @param categoryName
     * @param categoryId
     * @param products
     */
    public SubCategory(String categoryId, String categoryName, Boolean hasSubCategory, Boolean hasProduct, String categoryImage, List<Product> products) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.hasSubCategory = hasSubCategory;
        this.hasProduct = hasProduct;
        this.categoryImage = categoryImage;
        this.products = products;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getHasSubCategory() {
        return hasSubCategory;
    }

    public void setHasSubCategory(Boolean hasSubCategory) {
        this.hasSubCategory = hasSubCategory;
    }

    public Boolean getHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(Boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}